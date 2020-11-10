package com.doctors.form.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.form.Model.Doctorslist;
import com.doctors.form.Repository.DoctRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
@RestController
public class DoctConrtoller {
	@Autowired
	DoctRepository doctor;
	
	@PostMapping("/apply")
    public int addUser(@Validated @RequestBody Doctorslist doct) {
        doctor.save(doct);
        return 200;
    }
//	@GetMapping("/getall")
// 	public List<Doctorslist> getUsers() {
//	 		return doctor.findAll();
//	}
	@GetMapping("/getloginid/{id}")
 	public List<Doctorslist> getUser(@PathVariable Long id) {
	 		return doctor.findByLoginid(id);
	}
	@GetMapping("/edituser/{id}")
 	public Optional<Doctorslist> editUser(@PathVariable Long id) {
	 		return doctor.findById(id);
	}
	@GetMapping("/login/{Id}")
	 public String login(@Validated @RequestBody Doctorslist doctinfo) {
		 Optional<Doctorslist> user = doctor.findById(doctinfo.getId());
		 
		 String ss1;
		 if(!user.isPresent()) {
	    	 
	        ss1= "Wrong Username";     
	     }
		 else {
			 Doctorslist dd=user.get();
			 ss1=dd.getName();
		 	}
		return ss1;
	 }
	@DeleteMapping("deletedoctor/{id}")
	public Long deleteuser(@PathVariable Long id) {
		doctor.deleteById(id);
		return id;
	}
	@RequestMapping(value = "/deletedoctor", method = RequestMethod.DELETE)
	public ResponseEntity<Doctorslist> deleteAllUsers() {

		doctor.deleteAll();
		return new ResponseEntity<Doctorslist>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("editdoctor/{id}")
	public Optional<Doctorslist> updateDoctorlist(@PathVariable Long id, @Validated @RequestBody Doctorslist doctrequest) {
		
		return doctor.findById(id).map(doct -> {
			doct.setName(doctrequest.getName());
			doct.setDesignation(doctrequest.getDesignation());
			doct.setGender(doctrequest.getGender());
			doct.setMobile(doctrequest.getMobile());
			doct.setSpecialist(doctrequest.getSpecialist());
			
			return doctor.save(doct);
		});
	}
}


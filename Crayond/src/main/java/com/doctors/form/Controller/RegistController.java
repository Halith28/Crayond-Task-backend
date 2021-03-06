package com.doctors.form.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.form.Model.Registration;
import com.doctors.form.Repository.RegRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class RegistController {
	@Autowired
    private RegRepository ss;
	
	@PostMapping("/register")
    public int addUser(@Validated @RequestBody Registration stud) {
	 ////System.out.println(stud);
		Optional<Registration> register = ss.findByEmail(stud.getEmail());
		int ss1;
		 if(register.isPresent()) {
	    	 
	        ss1= 0;     
	     }
		 else {
			 ss.save(stud);
			 ss1= 200;
		        
		 }
		 return ss1;
		
        
    }
	@PutMapping("/logg")
	 public String login(@Valid @RequestBody Registration patientvals) {
		 Optional<Registration> user = ss.findByEmail(patientvals.getEmail());
		 
		 String ss1;
		 if(!user.isPresent()) {
	    	 
	        ss1= "Wrong Username";     
	     }
		 else {
			 Registration dd=user.get();
				
			ss1=dd.getEmail();
	     if(!dd.getPassword().equals(patientvals.getPassword())){
	    	 ss1= "Incorrect Password";
	     }
		 }

		 return ss1;
	}	
	@PutMapping("/checkuser")
	 public Long checkUser(@Valid @RequestBody Registration checkinfo) {
		 Optional<Registration> user = ss.findByEmail(checkinfo.getEmail());
		 Long ss2;
		 if(!user.isPresent()) {
		        ss2= (long) 5;     
		     }else {
		    	Registration dd=user.get();
				ss2=(long) dd.getAccess();
					if(!dd.getPassword().equals(checkinfo.getPassword())){
				    	 ss2= (long) 10;
				     }
		     }
		 return ss2;
		 
		
	}
	
	@PutMapping("/loginid")
	 public Long passLoginid(@Valid @RequestBody Registration passid){
		 Optional<Registration> loginid = ss.findByEmail(passid.getEmail());
		 
		 Long ss1;
		 Registration dd=loginid.get();
		 ss1=dd.getId();
		 return ss1;
	}
	@PutMapping("/giveaccess/{id}")
			public Optional<Registration> accessUser(@PathVariable Long id) {
				
				return ss.findById(id).map(doct -> {
					doct.setAccess(1);
					
					return ss.save(doct);
				});
	}
	
	@PutMapping("/denyaccess/{id}")
	public Optional<Registration> denyUser(@PathVariable Long id) {
		
		return ss.findById(id).map(doct -> {
			doct.setAccess(0);
			
			return ss.save(doct);
		});
}
	
//	@PutMapping("userlogin/{email}")
//	public Optional<Registration> checkUser(@PathVariable String email, @Validated @RequestBody Registration checkuser) {
//		
//		return ss.findByEmail(email).map(doct -> {
//			checkuser.setAccess(1);
//			
//			return ss.save(checkuser);
//		});
//}
	@DeleteMapping("deleteuser/{id}")
	public Long deleteuser(@PathVariable Long id) {
		ss.deleteById(id);
		return id;
	}
	@GetMapping("/login")
 	public List<Registration> getUsers() {
	 		return ss.findAllByOrderByIdAsc();
 }

}

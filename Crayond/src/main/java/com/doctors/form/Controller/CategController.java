package com.doctors.form.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.form.Model.Categorylist;
import com.doctors.form.Repository.CategRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
@RestController
public class CategController {
	@Autowired
	CategRepository category;
	
	@PostMapping("/savcategory")
    public int addCategory(@Validated @RequestBody Categorylist categ) {
		category.save(categ);
        return 200;
    }
	@GetMapping("/takeall")
 	public List<Categorylist> getUsers() {
	 		return category.findAll();
	}
	@DeleteMapping("deletecategory/{id}")
	public Long deleteuser(@PathVariable Long id) {
		category.deleteById(id);
		return id;
	}
	}

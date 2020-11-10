package com.doctors.form.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctors.form.Model.Doctorslist;


@Repository
public interface DoctRepository extends JpaRepository<Doctorslist, Long>{

	List<Doctorslist> findByLoginid(Long id);
//
//	void setName(String name);
//	
//	void setDesignation(String designation);
//	
//	void setSpecialist(String specialist);
//
//	void setMobile(String mobile);
//
//	void setGender(String gender);
//
////	Optional<Doctorslist> findByUsername(String username);

}

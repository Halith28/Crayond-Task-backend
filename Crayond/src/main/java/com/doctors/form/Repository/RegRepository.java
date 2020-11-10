package com.doctors.form.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctors.form.Model.Registration;

@Repository
public interface RegRepository extends JpaRepository<Registration, Long>{

	Optional<Registration> findByEmail(String email);

	List<Registration> findAllByOrderByIdAsc();

}

package com.doctors.form.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctors.form.Model.Postdata;

@Repository
public interface FileDBRepository extends JpaRepository<Postdata, String> {

}

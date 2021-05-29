package com.ojas.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
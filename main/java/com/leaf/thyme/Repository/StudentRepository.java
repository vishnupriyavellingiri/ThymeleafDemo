package com.leaf.thyme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaf.thyme.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}

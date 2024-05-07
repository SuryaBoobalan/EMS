package com.ebs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ebs.model.Calculated;

public interface CalulatedRepository extends JpaRepository<Calculated, Integer>{

}

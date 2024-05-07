package com.ebs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebs.model.TariffData;

public interface TariffRepository extends JpaRepository<TariffData, Integer>{

	@Query("select tariffid from TariffData order by tariffid")
	List<Integer> getIdList();
	
	@Query("select tariffName from TariffData order by tariffid")
	List<String> getIdName();
}

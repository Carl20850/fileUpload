package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Filedata;


@Repository
public interface FiledataRepository extends JpaRepository<Filedata, Integer> {
	
}

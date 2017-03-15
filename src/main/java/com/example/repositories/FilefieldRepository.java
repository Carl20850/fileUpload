package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.Filefield;

@Repository
public interface FilefieldRepository extends JpaRepository<Filefield, Integer> {
	
	
	List<Filefield> findByFilename(String name);
	
	//get file by id and certain risk level
	@Query("SELECT FF FROM Filefield FF WHERE FF.id = :id AND FF.risklevel >= :risk")
	List<Filefield> findByRisklevel(@Param("id") Integer id, @Param("risk") Integer risklevel);
	
	
}

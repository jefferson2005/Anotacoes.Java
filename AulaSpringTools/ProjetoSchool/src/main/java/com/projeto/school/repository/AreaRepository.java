package com.projeto.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.school.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
	Area findByTituloarea(String tituloarea);
}

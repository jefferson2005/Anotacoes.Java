package br.com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.school.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{

}

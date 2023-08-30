package br.com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.school.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}

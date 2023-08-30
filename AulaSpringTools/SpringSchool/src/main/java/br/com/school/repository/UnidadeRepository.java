package br.com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.school.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer>{

}

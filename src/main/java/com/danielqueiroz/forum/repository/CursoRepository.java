package com.danielqueiroz.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielqueiroz.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);

}

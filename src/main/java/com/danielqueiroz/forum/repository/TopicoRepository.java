package com.danielqueiroz.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielqueiroz.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

}

package com.danielqueiroz.forum.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielqueiroz.forum.dto.TopicoDto;
import com.danielqueiroz.forum.input.TopicoInput;
import com.danielqueiroz.forum.model.Curso;
import com.danielqueiroz.forum.model.Topico;
import com.danielqueiroz.forum.repository.CursoRepository;
import com.danielqueiroz.forum.repository.TopicoRepository;

@RestController("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista() {
		var duvida = new Topico("Duvida sobre JAVA", "Erro ao compilar", new Curso("Java Basics", "Programação"));
		return TopicoDto.converter(Arrays.asList(duvida, duvida));
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoInput input, UriComponentsBuilder uriBuilder) {
		Topico topico = input.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}

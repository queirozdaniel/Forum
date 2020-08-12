package com.danielqueiroz.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielqueiroz.forum.dto.TopicoDto;
import com.danielqueiroz.forum.model.Curso;
import com.danielqueiroz.forum.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		var duvida = new Topico("Duvida sobre JAVA", "Erro ao compilar", new Curso("Java Basics", "Programação"));
		return TopicoDto.converter(Arrays.asList(duvida, duvida));
	}
	
}

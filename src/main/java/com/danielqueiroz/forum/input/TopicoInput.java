package com.danielqueiroz.forum.input;

import com.danielqueiroz.forum.model.Curso;
import com.danielqueiroz.forum.model.Topico;
import com.danielqueiroz.forum.repository.CursoRepository;

public class TopicoInput {

	private String titulo;
	private String mensagem;
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository repository) {
		Curso curso = repository.findByNome(nomeCurso);
		return new Topico(this.titulo, this.mensagem, curso);
	}

}

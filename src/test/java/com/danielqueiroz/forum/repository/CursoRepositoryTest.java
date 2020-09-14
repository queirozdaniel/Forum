package com.danielqueiroz.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.danielqueiroz.forum.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;

	@Test
	public void deveriaRetornarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 5";

		Curso curso = repository.findByNome(nomeCurso);
		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaRetornarUmCursoAoBuscarPorNomeNaoCadastrado() {
		String nomeCurso = "HTML5 e CSS3";
		
		Curso curso = repository.findByNome(nomeCurso);
		Assertions.assertNull(curso);
	}

}

package com.danielqueiroz.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.danielqueiroz.forum.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authenticate) {
		Usuario usuario = (Usuario) authenticate.getPrincipal();
		var date = new Date();
		var dataExpiracao = new Date(date.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setIssuer("API Forum")
				.setSubject(usuario.getId().toString())
				.setIssuedAt(date)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}

package com.oki.matheus.util;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.oki.matheus.model.UsuarioBanco;

public class LoginUtil {

	
	
	
	public static boolean validaLogin(UsuarioBanco usuarioBanco) {
		
		EntityManager mananger = JpaUtil.getEntityManager();
		TypedQuery<UsuarioBanco> querry = mananger.createQuery("FROM UsuarioBanco usu WHERE usu.usuario = :usuario AND usu.senha = :senha ", UsuarioBanco.class);
		querry.setParameter("usuario", usuarioBanco.getUsuario());
		querry.setParameter("senha", usuarioBanco.getSenha());
		
		
		UsuarioBanco singleResult = new UsuarioBanco();
		try {
			 singleResult = querry.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		System.out.println(singleResult.getUsuario());
		return true;
		
		
	}
	
	
}

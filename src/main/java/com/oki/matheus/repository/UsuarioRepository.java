package com.oki.matheus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.oki.matheus.model.UsuarioBanco;


public class UsuarioRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager mananger;

	@Inject
	public UsuarioRepository(EntityManager mananger) {
		this.mananger = mananger;
	}
	
	public UsuarioBanco porId(Long id) {
		return mananger.find(UsuarioBanco.class, id);
	}
	public List<UsuarioBanco> todos() {
		TypedQuery<UsuarioBanco> query = mananger.createQuery("from UsuarioBanco", UsuarioBanco.class);

		return query.getResultList();
	}

	public void adicionar(UsuarioBanco usuarioBanco) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		mananger.merge(usuarioBanco);
		trx.commit();
	}

	public void remover(UsuarioBanco UsuarioSelecionado) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		this.mananger.remove(this.mananger.find(UsuarioBanco.class, UsuarioSelecionado.getId()));
		
		trx.commit();
		
		
	}



}

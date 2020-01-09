package com.oki.matheus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.oki.matheus.model.Pessoa;
import com.oki.matheus.util.JpaUtil;

public class PessoaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager mananger;

	@Inject
	public PessoaRepository(EntityManager mananger) {
		super();
		this.mananger = mananger;
	}

	public Pessoa porId(Long id) {
		return mananger.find(Pessoa.class, id);
	}
	public List<Pessoa> todos() {
		TypedQuery<Pessoa> query = mananger.createQuery("from Pessoa", Pessoa.class);

		return query.getResultList();
	}

	public void adicionar(Pessoa pessoa) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		mananger.merge(pessoa);
		trx.commit();
	}

	public void remover(Pessoa pessoaSelecionada) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		this.mananger.remove(this.mananger.find(Pessoa.class, pessoaSelecionada.getId()));
		
		trx.commit();
		
		
	}

	public List<Pessoa> buscaPorNome(String letra) {
		EntityManager mananger = JpaUtil.getEntityManager();
		TypedQuery<Pessoa> querry = mananger.createQuery("FROM Pessoa p WHERE p.nome LIKE :letra ", Pessoa.class);
		querry.setParameter("letra","%"+letra+"%");
		
		
		return querry.getResultList();
	}
}

package com.oki.matheus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.oki.matheus.model.Lancamento;
import com.oki.matheus.util.JpaUtil;

public class LancamentoRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager mananger;

	@Inject
	public LancamentoRepository(EntityManager mananger) {
		super();
		this.mananger = mananger;
	}

	public List<Lancamento> todos() {
		TypedQuery<Lancamento> query = mananger.createQuery("from Lancamento", Lancamento.class);

		return query.getResultList();

	}

	public void adicionar(Lancamento lancamento) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		this.mananger.merge(lancamento);
		trx.commit();
	}

	public Lancamento porId(Long id) {
		return mananger.find(Lancamento.class, id);

	}

	public void remover(Lancamento lancamento) {
		EntityTransaction trx = this.mananger.getTransaction();
		trx.begin();
		this.mananger.remove(this.mananger.find(Lancamento.class, lancamento.getId()));

		trx.commit();

	}
	
	
	public List<Lancamento> buscaPorNome(String nome) {
		EntityManager mananger = JpaUtil.getEntityManager();
		TypedQuery<Lancamento> querry = mananger.createQuery("FROM Lancamento lan WHERE lan.pessoa.nome LIKE :nome ", Lancamento.class);
		querry.setParameter("nome","%"+nome+"%");
		
		
		return querry.getResultList();
	}
}

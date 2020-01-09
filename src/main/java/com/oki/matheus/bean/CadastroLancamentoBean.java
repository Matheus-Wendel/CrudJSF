package com.oki.matheus.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.oki.matheus.model.Lancamento;
import com.oki.matheus.model.Pessoa;
import com.oki.matheus.model.TipoLancamento;
import com.oki.matheus.repository.LancamentoRepository;
import com.oki.matheus.repository.PessoaRepository;
import com.oki.matheus.util.JpaUtil;

@ManagedBean
@ViewScoped
@Named
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();

	@Inject
	private PessoaRepository pessoaRepository;

	@Inject
	private LancamentoRepository lancamentoRepository;
	
	private List<Pessoa> todasPessoas;

	public void prepararCadastro() {

		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
		this.todasPessoas = pessoaRepository.todos();

	}

	public void salvar() {

		System.err.println("Entreo");
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			transacao.begin();
			lancamentoRepository.adicionar(lancamento);
			this.lancamento = new Lancamento();

			context.addMessage(null, new FacesMessage("Lancamento salvo"));

			transacao.commit();

		} catch (Exception e) {
			transacao.rollback();
		} finally {
			manager.close();
		}

	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}

}

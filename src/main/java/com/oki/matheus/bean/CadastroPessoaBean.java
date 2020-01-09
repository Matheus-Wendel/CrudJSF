package com.oki.matheus.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oki.matheus.model.Pessoa;
import com.oki.matheus.repository.PessoaRepository;

@Named
@ViewScoped
@ManagedBean
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	@Inject
	private PessoaRepository pessoaRepository;

	public void prepararCadastro() {
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
			
		}

	}

	public void salvar() {
//		EntityManager manager = JpaUtil.getEntityManager();
//		EntityTransaction transacao = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
//
//		try {
//		 	transacao.begin();
			pessoaRepository.adicionar(pessoa);
//			this.pessoa= new Pessoa();
//
			context.addMessage(null, new FacesMessage("Pessoa  salva"));
//
			this.pessoa = new Pessoa();
//			transacao.commit();
//
//		} catch (Exception e) {
//			transacao.rollback();
//		} finally {
//			manager.close();
//		}
//
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

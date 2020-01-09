package com.oki.matheus.bean;

import java.io.Serializable;
import java.util.List;

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
public class ConsultaPessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject

	private PessoaRepository pessoaRepository;

	private Pessoa pessoaSelecionada;
	private String busca;

	private List<Pessoa> pessoas;

	public void consultar() {

		this.pessoas = pessoaRepository.todos();
	}

	public void filtraPessoas() {

//		pessoaRepository = new PessoaRepository(JpaUtil.getEntityManager());

		if (busca == null) {
			this.pessoas = pessoaRepository.todos();
			
		}

		this.pessoas = pessoaRepository.buscaPorNome(this.busca);

	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.pessoaRepository.remover(pessoaSelecionada);
		} catch (Exception e) {

			FacesMessage mensagen = new FacesMessage("NÃO É POSSIVEL EXCLUIR PESSOA COM LANCAMENTOS ATIVOS");

			mensagen.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagen);
			return;

		}
		this.consultar();
		context.addMessage(null, new FacesMessage("Pesoa excluída com sucesso!"));
	}

	public Pessoa getLancamentoSelecionado() {
		return pessoaSelecionada;
	}

	public void setLancamentoSelecionado(Pessoa lancamentoSelecionado) {
		this.pessoaSelecionada = lancamentoSelecionado;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
	

}

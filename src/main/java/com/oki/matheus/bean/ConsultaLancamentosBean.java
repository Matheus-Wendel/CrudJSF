package com.oki.matheus.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oki.matheus.model.Lancamento;
import com.oki.matheus.repository.LancamentoRepository;

@Named
@ViewScoped
@ManagedBean
public class ConsultaLancamentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private LancamentoRepository lancamentoRepository;

	private Lancamento lancamentoSelecionado;
	
	private String busca;

	private List<Lancamento> lancamentos;

	public void consultar() {

		this.lancamentos = lancamentoRepository.todos();
	}
	public void filtraLancamentos() {


		if (busca == null) {
			this.lancamentos = lancamentoRepository.todos();
			
		}

		this.lancamentos = lancamentoRepository.buscaPorNome(this.busca);

	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.lancamentoRepository.remover(lancamentoSelecionado);
		this.consultar();
		context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	public String getBusca() {
		return busca;
	}
	public void setBusca(String busca) {
		this.busca = busca;
	}
	
}

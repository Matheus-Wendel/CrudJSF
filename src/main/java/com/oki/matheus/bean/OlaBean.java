package com.oki.matheus.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.oki.matheus.model.Pessoa;
import com.oki.matheus.repository.PessoaRepository;
import com.oki.matheus.util.JpaUtil;

@ManagedBean(name = "ola")
@ViewScoped
@Named
public class OlaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	private Integer quantidadeCaracteres;
	
	private String busca;
	

	private PessoaRepository pessoaRepository;
	
	private List<Pessoa> todasPessoas;
	private Pessoa pessoa;


	
	
	public void filtraPessoas(AjaxBehaviorEvent event) {
		
		
		 pessoaRepository = new PessoaRepository(JpaUtil.getEntityManager());
		
//	if(busca == null)
//		busca='A';
	
		System.out.println(pessoaRepository);
		this.todasPessoas = pessoaRepository.buscaPorNome(this.busca);

	}


	public void dizerOla() {
		this.nomeCompleto = this.nome.toUpperCase() + " " + this.sobrenome.toUpperCase();
	}

	
	public void transformar() {
		this.nome = this.nome.toUpperCase();
		quantidadeCaracteres = this.nome.length();
	}

	
	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}
	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrnome) {
		this.sobrenome = sobrnome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getQuantidadeCaracteres() {
		return quantidadeCaracteres;
	}

	public void setQuantidadeCaracteres(Integer quantidadeCaracteres) {
		this.quantidadeCaracteres = quantidadeCaracteres;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public String getBusca() {
		return busca;
	}


	public void setBusca(String busca) {
		this.busca = busca;
	}
	
	

}

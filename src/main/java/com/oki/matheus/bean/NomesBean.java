package com.oki.matheus.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean

//@RequestScoped // INSTANCIA EH FINALIZADA AO ENVIAR A RESPSOSTA (LISTA NOVA EH CRIADA TODA VEZ QUE A FUNCAO EH  CHAMADA)
//@SessionScoped // INSTACIA DURA ENQUANTO A SESSAO DO USUARIO ESTIVER ATIVA, 
//@ApplicationScoped // UMA INSTACIA POR APLICACAO, COMPARTILHADA POR TODOS OS USUARIOS
@ViewScoped // INSTACIA EXISTE ENQUANTO A PAGINA ESTIVER ABERTA

public class NomesBean {

	private String nome;
	private List<String> nomes = new ArrayList<String>();

	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;

	public void adicionarNomes() {
		this.nomes.add(nome);

		if (this.nomes.size() > 3) {
			this.inputNome.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes");
		}

	}
	
	public String redirecionar() {
		if(this.nomes.size()>3)
			return "Ola";
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public HtmlInputText getInputNome() {
		return inputNome;
	}

	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}

}

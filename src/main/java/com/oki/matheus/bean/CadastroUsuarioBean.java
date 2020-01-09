package com.oki.matheus.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oki.matheus.model.UsuarioBanco;
import com.oki.matheus.repository.UsuarioRepository;



@Named
@ViewScoped
@ManagedBean
public class CadastroUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioBanco usuarioBanco = new UsuarioBanco();

	@Inject
	private UsuarioRepository usuarioRepository;

	public void prepararCadastro() {
		if (this.usuarioBanco == null) {
			this.usuarioBanco = new UsuarioBanco();
			
		}

	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
//
			usuarioRepository.adicionar(usuarioBanco);
//
			context.addMessage(null, new FacesMessage("USUARIO SALVO"));
//
			this.usuarioBanco = new UsuarioBanco();
//
	}

	public UsuarioBanco getUsuarioBanco() {
		return usuarioBanco;
	}

	public void setUsuarioBanco(UsuarioBanco usuarioBanco) {
		this.usuarioBanco = usuarioBanco;
	}


	
	
}

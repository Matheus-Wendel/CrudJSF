package com.oki.matheus.bean;

import java.io.Serializable;
import java.util.List;

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
public class ConsultaUsuariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Inject
	private UsuarioRepository usuarioRepository;

	private UsuarioBanco usuarioSelecionado;
	

	private List<UsuarioBanco> Usuarios;

	public void consultar() {

		this.Usuarios = usuarioRepository.todos();
	}



	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.usuarioRepository.remover(usuarioSelecionado);
		this.consultar();
		context.addMessage(null, new FacesMessage("Usuario excluído com sucesso!"));
	}



	public UsuarioBanco getUsuarioSelecionado() {
		return usuarioSelecionado;
	}



	public void setUsuarioSelecionado(UsuarioBanco usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}



	public List<UsuarioBanco> getUsuarios() {
		return Usuarios;
	}



	public void setUsuarios(List<UsuarioBanco> usuarios) {
		Usuarios = usuarios;
	}

}

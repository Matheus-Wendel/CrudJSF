package com.oki.matheus.bean;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.oki.matheus.model.Usuario;
import com.oki.matheus.model.UsuarioBanco;
import com.oki.matheus.util.LoginUtil;

@Named
@RequestScoped
@ManagedBean
public class LoginBean {

	@Inject
	private Usuario usuario;

	private String nomeUsuario;
	private String senha;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		UsuarioBanco usuarioBanco = new UsuarioBanco();
		usuarioBanco.setSenha(senha);
		usuarioBanco.setUsuario(nomeUsuario);
		
				

		if (("admin".equals(this.nomeUsuario) && "123".equals(this.senha))||LoginUtil.validaLogin(usuarioBanco)) {
			this.usuario.setNome(nomeUsuario);
			this.usuario.setDataLogin(new Date());

			return "/consultaLancamentos?faces-redirect=true";
		} else {
			FacesMessage mensagen = new FacesMessage("usuario / senha invalida");

			mensagen.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagen);

		}
		return null;

	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

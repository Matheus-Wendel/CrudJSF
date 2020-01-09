package com.oki.matheus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.oki.matheus.model.UsuarioBanco;
import com.oki.matheus.repository.UsuarioRepository;
import com.oki.matheus.util.JpaUtil;

@FacesConverter(forClass = UsuarioBanco.class)
public class UsuarioBancoConverter implements Converter {

	private UsuarioRepository usuarioRepository;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		System.err.println("entrou  no converter");
		UsuarioBanco retorno = null;


			if (value != null && !"".equals(value)) {
				 usuarioRepository = new UsuarioRepository(JpaUtil.getEntityManager());
				retorno = usuarioRepository.porId(new Long(value));
			}
			return retorno;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null) {
			UsuarioBanco usuarioBanco = (UsuarioBanco) value;
			return usuarioBanco.getId() == null ? null : usuarioBanco.getId().toString();
		}
		return null;
	}

}

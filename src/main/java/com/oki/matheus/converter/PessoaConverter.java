package com.oki.matheus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.oki.matheus.model.Pessoa;
import com.oki.matheus.repository.PessoaRepository;
import com.oki.matheus.util.JpaUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	private PessoaRepository pessoaRepository;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		System.err.println("entrou  no converter");
		Pessoa retorno = null;


			if (value != null && !"".equals(value)) {
				 pessoaRepository = new PessoaRepository(JpaUtil.getEntityManager());
				retorno = pessoaRepository.porId(new Long(value));
			}
			return retorno;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId() == null ? null : pessoa.getId().toString();
		}
		return null;
	}

}

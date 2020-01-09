package com.oki.matheus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.oki.matheus.model.Lancamento;
import com.oki.matheus.repository.LancamentoRepository;
import com.oki.matheus.util.JpaUtil;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

	private LancamentoRepository lancamentoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Lancamento retorno = null;
		if (value != null && !"".equals(value)) {
			lancamentoRepository = new LancamentoRepository(JpaUtil.getEntityManager());
			retorno = this.lancamentoRepository.porId(new Long(value));
		}
		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Lancamento lancamento = (Lancamento) value;
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return null;

	}

}

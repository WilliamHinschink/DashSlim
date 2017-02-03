/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.converter;

import com.sibentek.comercial.model.Grupo;
import com.sibentek.comercial.repository.GrupoRepository;
import com.sibentek.comercial.util.cdi.CDIServiceLocator;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author william
 */
//@FacesConverter(forClass = Grupo.class, value = "grupoConverter")
@Named
@ApplicationScoped
public class GrupoConverter implements Converter {

    @Inject
    private GrupoRepository grupoRepository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Grupo retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            retorno = this.grupoRepository.porId(new Long(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
//        if (object != null && object instanceof Grupo) {
//            return String.valueOf(((Grupo) object).getGrupo_id());
//        }
        if(object != null){
            Long codigo = ((Grupo) object).getGrupo_id();
            return codigo == null ? null : codigo.toString();
        }
        return "";
    }
}

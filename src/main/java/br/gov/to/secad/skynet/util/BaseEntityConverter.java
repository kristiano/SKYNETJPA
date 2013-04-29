/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.util;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Thales
 */
@FacesConverter(value="baseEntityConverter", forClass=BaseEntity.class)  
public class BaseEntityConverter implements Converter {  
   
  

        /**
     *
     * @param ctx
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

        /**
     *
     * @param ctx
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null && !"".equals(value)) {

            BaseEntity entity = (BaseEntity) value;

            this.addAttribute(component, entity);

            Long codigo = entity.getId();

            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }

    /**
     *
     * @param component
     * @param o
     */
    protected void addAttribute(UIComponent component, BaseEntity o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    /**
     *
     * @param component
     * @return
     */
    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}

package br.edu.ifpb.infra.jsf.convert;

import br.edu.ifpb.model.integrante.CPF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "convert.CPF", forClass = CPF.class)
public class CPFConvert implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || "".equals(value)) {
            return null;
        }
        return new CPF(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return CPF.class.cast(o).getNumero();
    }

}
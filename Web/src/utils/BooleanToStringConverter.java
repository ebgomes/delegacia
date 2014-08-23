package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "booleanToStringConverter")
public class BooleanToStringConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ("SIM".equals(value.toUpperCase())?true:false);
		}

	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof Boolean){
		return (true==(Boolean)object?"Sim":"Não");
		}
		return "";
		}

}

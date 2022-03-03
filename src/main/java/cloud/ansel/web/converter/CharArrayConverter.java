package cloud.ansel.web.converter;

import org.springframework.stereotype.Component;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@Component("charArrayConverter")
@FacesConverter("charArrayConverter")
public class CharArrayConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return s != null ? s.toCharArray() : null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }

        try {
            final char[] input = (char[]) o;
            return new String(input);
        } catch (ClassCastException e) {
            final FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Object was not present in the desired format",
                null);
            throw new ConverterException(message);
        }
    }
}

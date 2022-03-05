package cloud.ansel.web.converter;

import org.springframework.stereotype.Component;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@Component("charArrayConverter")
@FacesConverter("charArrayConverter")
public class CharArrayConverter implements Converter<char[]> {

    @Override
    public char[] getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return s != null ? s.toCharArray() : null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, char[] o) {
        if (o == null) {
            return null;
        }
        return new String(o);
    }
}

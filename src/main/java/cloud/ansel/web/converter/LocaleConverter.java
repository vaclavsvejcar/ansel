package cloud.ansel.web.converter;

import org.springframework.stereotype.Component;

import java.util.Locale;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@Component("localeConverter")
@FacesConverter("localeConverter")
public class LocaleConverter implements Converter<Locale> {

    @Override
    public Locale getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return Locale.forLanguageTag(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Locale locale) {
        return locale.toLanguageTag();
    }
}
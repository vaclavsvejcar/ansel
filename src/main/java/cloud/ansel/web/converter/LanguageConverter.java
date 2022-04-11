package cloud.ansel.web.converter;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.stream.Stream;

import cloud.ansel.model.enums.Language;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@Component("languageConverter")
@FacesConverter("languageConverter")
public class LanguageConverter implements Converter<Language> {
    @Override
    public Language getAsObject(FacesContext context, UIComponent component, String value) {
        return Stream.of(Language.values())
            .filter(language -> language.getName().equals(Locale.forLanguageTag(value)))
            .findAny()
            .orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Language value) {
        return value.getLocale().toLanguageTag();
    }
}
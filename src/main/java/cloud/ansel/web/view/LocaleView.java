package cloud.ansel.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cloud.ansel.model.enums.Language;
import cloud.ansel.service.LocaleService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;

@Component("localeV")
@SessionScope
public class LocaleView {

    private final LocaleService localeService;
    private final List<Language> availableLanguages = new ArrayList<>();

    private Language selectedLanguage;

    @Autowired
    public LocaleView(LocaleService localeService) {
        this.localeService = localeService;
    }

    @PostConstruct
    private void postConstruct() {
        final Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        selectedLanguage = localeService.languageForLocale(locale).orElse(Language.defaultLanguage());

        availableLanguages.addAll(
            localeService.supportedLanguages().stream().sorted(Comparator.comparing(Language::getName)).toList());
    }

    public void saveChanges() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(selectedLanguage.getLocale());
    }

    public List<Language> getAvailableLanguages() {
        return availableLanguages;
    }

    public Language getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(Language selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
}

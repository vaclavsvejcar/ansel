package cloud.ansel.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cloud.ansel.model.enums.Language;
import cloud.ansel.service.LocaleService;
import cloud.ansel.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;

@Component("localeV")
@SessionScope
public class LocaleView extends JsfView {

    private final LocaleService localeService;
    private final UserService userService;
    private final List<Language> availableLanguages = new ArrayList<>();

    private Language selectedLanguage;

    @Autowired
    public LocaleView(LocaleService localeService,
                      UserService userService) {
        this.localeService = localeService;
        this.userService = userService;
    }

    @PostConstruct
    private void postConstruct() {
        withLoggedInUser(user -> selectedLanguage = user.getLanguage());
        if (selectedLanguage == null) {
            selectedLanguage = Language.defaultLanguage();
        }

        availableLanguages.addAll(
            localeService.supportedLanguages().stream().sorted(Comparator.comparing(Language::getLabel)).toList());
    }

    public void saveChanges() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(selectedLanguage.getLocale());
        withLoggedInUser(user -> userService.updateLanguage(user.getId(), selectedLanguage));
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

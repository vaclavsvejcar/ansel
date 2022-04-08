package cloud.ansel.web.view;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;

@Component("localeV")
@SessionScope
public class LocaleView {

    private static final Map<String, Locale> countries = new HashMap<>();

    private Locale selectedLocale;

    static {
        countries.put("English", Locale.ENGLISH);
        countries.put("Čeština", new Locale("cs", "CZ"));
    }

    @PostConstruct
    private void postConstruct() {
        selectedLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public void saveChanges() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(selectedLocale);
    }

    public Map<String, Locale> getCountries() {
        return countries;
    }

    public Locale getSelectedLocale() {
        return selectedLocale;
    }

    public void setSelectedLocale(Locale selectedLocale) {
        this.selectedLocale = selectedLocale;
    }
}

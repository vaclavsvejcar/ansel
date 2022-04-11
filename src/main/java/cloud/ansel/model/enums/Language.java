package cloud.ansel.model.enums;

import java.util.Locale;

public enum Language {

    ENGLISH_US("English", Locale.ENGLISH),
    CZECH("Čeština", new Locale("cs", "CZ"));

    private final String name;
    private final Locale locale;

    Language(String name, Locale locale) {
        this.name = name;
        this.locale = locale;
    }

    public static Language defaultLanguage() {
        return ENGLISH_US;
    }

    public String getName() {
        return name;
    }

    public Locale getLocale() {
        return locale;
    }
}

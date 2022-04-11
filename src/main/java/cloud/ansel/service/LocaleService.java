package cloud.ansel.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import cloud.ansel.model.enums.Language;

public interface LocaleService {

    List<Language> supportedLanguages();

    Optional<Language> languageForLocale(Locale locale);
}

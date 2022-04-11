package cloud.ansel.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

import cloud.ansel.model.enums.Language;
import cloud.ansel.service.LocaleService;

@Service
public class LocaleServiceImpl implements LocaleService {

    @Override
    public List<Language> supportedLanguages() {
        return List.of(Language.values());
    }

    @Override
    public Optional<Language> languageForLocale(Locale locale) {
        return Stream.of(Language.values()).filter(language -> language.getLocale().equals(locale)).findAny();
    }
}

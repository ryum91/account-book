import Vue from 'vue';
import VueI18n from 'vue-i18n';

Vue.use(VueI18n);

const loadedLanguages: Type.Lang[] = [];

const i18n = new VueI18n({
  silentTranslationWarn: process.env.NODE_ENV === 'production'
});

function setI18nLanguage(lang: Type.Lang): Type.Lang {
  i18n.locale = lang;
  document.querySelector('html')!.setAttribute('lang', lang);
  return lang;
}

export async function loadLanguage(lang: Type.Lang): Promise<Type.Lang> {
  if (i18n.locale === lang) {
    return setI18nLanguage(lang);
  }
  if (loadedLanguages.includes(lang)) {
    return setI18nLanguage(lang);
  }

  return import(/* webpackChunkName: "lang-[request]" */ `@/i18n/messages/${lang}.ts`).then(messages => {
    i18n.setLocaleMessage(lang, messages.default);
    loadedLanguages.push(lang);
    return setI18nLanguage(lang);
  });
}

export default i18n;

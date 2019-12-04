import Vue from 'vue';
import VueI18n from 'vue-i18n';
import { Lang } from '@/types/types';

Vue.use(VueI18n);

const loadedLanguages: Lang[] = [];

const i18n = new VueI18n({
  silentTranslationWarn: process.env.NODE_ENV === 'production'
});

function setI18nLanguage(lang: Lang): Lang {
  i18n.locale = lang;
  document.querySelector('html')!.setAttribute('lang', lang);
  return lang;
}

export async function loadLanguage(lang: Lang): Promise<Lang> {
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

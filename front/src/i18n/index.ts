import Vue from 'vue';
import VueI18n from 'vue-i18n';
import { getI18n } from '@/api/index';
import { Lang } from '@/types/enums';

Vue.use(VueI18n);

const loadedLanguages: Array<Lang> = [];

const i18n = new VueI18n({
  silentTranslationWarn: process.env.NODE_ENV === 'production'
});

function setI18nLanguage(lang: Lang) {
  i18n.locale = lang;
}

export async function loadLanguage(lang: Lang) {
  if (i18n.locale === lang) {
    return setI18nLanguage(lang);
  }
  if (loadedLanguages.includes(lang)) {
    return setI18nLanguage(lang);
  }
  const message = await getI18n(lang);
  i18n.setLocaleMessage(lang, message);
  loadedLanguages.push(lang);
  return setI18nLanguage(lang);
}

loadLanguage(Lang.KO);

export default i18n;

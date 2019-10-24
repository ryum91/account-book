import Vue from 'vue';
import VueI18n from 'vue-i18n';
import { getI18n } from '@/api/index';

Vue.use(VueI18n);

let messages;
(async function() {
  const result = await getI18n('ko');
  console.log('result', result);
  messages = result;
})();
console.log('123');

const i18n = new VueI18n({
  locale: 'ko',
  messages
});

export default i18n;

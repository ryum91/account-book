import Vue from 'vue';
import Vuex, { StoreOptions } from 'vuex';
import global from './modules/global';
import category from './modules/category';
import account from './modules/account';
import history from './modules/history';

Vue.use(Vuex);

const store: StoreOptions<Store.RootState> = {
  state: {
    version: '0.0.0.1'
  },
  modules: {
    global,
    category,
    account,
    history
  }
};

export default new Vuex.Store<Store.RootState>(store);

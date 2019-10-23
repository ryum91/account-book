import Vue from 'vue';
import Vuex, { StoreOptions } from 'vuex';
import { RootState } from './types';
import { category } from './modules/category';

Vue.use(Vuex);

const store: StoreOptions<RootState> = {
  state: {
    version: '0.0.0.1'
  },
  modules: {
    category
  }
};

export default new Vuex.Store<RootState>(store);

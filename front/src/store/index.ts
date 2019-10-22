import Vue from 'vue';
import Vuex from 'vuex';
import { Category } from '@/types';
import { getCategories } from '@/api';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    categories: Array<Category>(),
  },
  getters: {
    categories(state) {
      return state.categories;
    }
  },
  mutations: {
    addCategory(state, category: Category) {
      state.categories.push(category);
    }
  },
  actions: {
    async fetchCategories({commit}) {
      const data: Category[] = await getCategories();
      data.forEach((category) => {
        commit('addCategory', category);
      });
    }
  },
});

import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, CategoryState } from '../types';
import { Category } from '@/types';
import { getCategories } from '@/api';

const state: CategoryState = {
  categories: Array<Category>()
};

const getters: GetterTree<CategoryState, RootState> = {
  categories(state): Category[] {
    return state.categories;
  }
};

const mutations: MutationTree<CategoryState> = {
  addCategory(state, category: Category) {
    state.categories.push(category);
  }
};

const actions: ActionTree<CategoryState, RootState> = {
  async fetchCategories({commit}): Promise<void> {
    const data: Category[] = await getCategories();
    data.forEach((category) => {
      commit('addCategory', category);
    });
  }
};

export const category: Module<CategoryState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

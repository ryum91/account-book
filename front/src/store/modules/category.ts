import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, CategoryState } from '../types';
import { Category } from '@/types/types';
import { getCategories } from '@/api';

const state: CategoryState = {
  categories: Array<Category>()
};

const getters: GetterTree<CategoryState, RootState> = {
  // Getter declare 'category/findAll'
  findAll(state): Category[] {
    return state.categories;
  },
  // Getter declare 'category/findByIdx'
  findByIdx(state): Function {
    return function(idx: number): Category | undefined {
      return state.categories.find(category => category.idx === idx);
    };
  }
};

const mutations: MutationTree<CategoryState> = {
  // Mutation declare 'category/clear'
  clear(state): void {
    state.categories = [];
  },
  // Mutation declare 'category/add'
  add(state, category: Category): void {
    state.categories.push(category);
  }
};

const actions: ActionTree<CategoryState, RootState> = {
  // Action declare 'category/load'
  async load({ commit }): Promise<void> {
    const data: Category[] = await getCategories();
    commit('clear');
    data.forEach(category => commit('add', category));
  }
};

export const category: Module<CategoryState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

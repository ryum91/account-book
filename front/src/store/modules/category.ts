import { Category, Unit } from '@/types/types';
import { getCategories } from '@/api';
import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, CategoryState } from '../types';

const state: CategoryState = {
  categories: []
};

const getters: GetterTree<CategoryState, RootState> = {
  // Getter declare 'category/findList'
  findList: state => ({ unit, parentIdx }: { unit: Unit; parentIdx: number }) =>
    state.categories.filter(category => category.unit === unit && category.parentIdx === parentIdx),

  // Getter declare 'category/findByIdx'
  findByIdx: state => (idx: number) => state.categories.find(category => category.idx === idx)
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
    commit('clear');
    const data: Category[] = await getCategories();
    data.forEach(category => commit('add', category));
  }
};

const category: Module<CategoryState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

export default category;

import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { getCategories } from '@/api';

const storage: Store.CategoryState = {
  categories: []
};

const getterTree: GetterTree<Store.CategoryState, Store.RootState> = {
  // Getter declare 'category/findList'
  findList: state => ({ unit, parentIdx }: { unit: Type.Unit; parentIdx: number }) =>
    state.categories.filter(category => category.unit === unit && category.parentIdx === parentIdx),

  // Getter declare 'category/findByIdx'
  findByIdx: state => (idx: number) => state.categories.find(category => category.idx === idx)
};

const mutationTree: MutationTree<Store.CategoryState> = {
  // Mutation declare 'category/clear'
  clear(state): void {
    state.categories = [];
  },
  // Mutation declare 'category/add'
  add(state, category: Type.Category): void {
    state.categories.push(category);
  }
};

const actionTree: ActionTree<Store.CategoryState, Store.RootState> = {
  // Action declare 'category/load'
  async load({ commit }): Promise<void> {
    commit('clear');
    const data: Type.Category[] = await getCategories();

    data.forEach(category => commit('add', category));
  }
};

const category: Module<Store.CategoryState, Store.RootState> = {
  namespaced: true,
  state: storage,
  getters: getterTree,
  mutations: mutationTree,
  actions: actionTree
};

export default category;

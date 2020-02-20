import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { getHistories } from '@/api';

const storage: Store.HistoryState = {
  histories: []
};

const getterTree: GetterTree<Store.HistoryState, Store.RootState> = {
  // Getter declare 'history/findAll'
  findAll: state => state.histories,
  // Getter declare 'history/findByIdx'
  findByIdx: state => (idx: number) => state.histories.find(history => history.idx === idx)
};

const mutationTree: MutationTree<Store.HistoryState> = {
  // Mutation declare 'history/clear'
  clear(state): void {
    state.histories = [];
  },
  // Mutation declare 'history/add'
  add(state, history: Type.History): void {
    state.histories.push(history);
  }
};

const actionTree: ActionTree<Store.HistoryState, Store.RootState> = {
  // Action declare 'history/load'
  async load({ commit }): Promise<void> {
    commit('clear');
    const data: Type.History[] = await getHistories();

    data.forEach(history => commit('add', history));
  }
};

const history: Module<Store.HistoryState, Store.RootState> = {
  namespaced: true,
  state: storage,
  getters: getterTree,
  mutations: mutationTree,
  actions: actionTree
};

export default history;

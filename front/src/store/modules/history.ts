import { History } from '@/types/types';
import { getHistories } from '@/api';
import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, HistoryState } from '../types';

const state: HistoryState = {
  histories: []
};

const getters: GetterTree<HistoryState, RootState> = {
  // Getter declare 'history/findAll'
  findAll: state => state.histories,
  // Getter declare 'history/findByIdx'
  findByIdx: state => (idx: number) => state.histories.find(history => history.idx === idx)
};

const mutations: MutationTree<HistoryState> = {
  // Mutation declare 'history/clear'
  clear(state): void {
    state.histories = [];
  },
  // Mutation declare 'history/add'
  add(state, history: History): void {
    state.histories.push(history);
  }
};

const actions: ActionTree<HistoryState, RootState> = {
  // Action declare 'history/load'
  async load({ commit }): Promise<void> {
    commit('clear');
    const data: History[] = await getHistories();
    data.forEach(history => commit('add', history));
  }
};

const history: Module<HistoryState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

export default history;

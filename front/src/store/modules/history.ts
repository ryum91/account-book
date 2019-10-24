import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, HistoryState } from '../types';
import { History } from '@/types';
import { getHistories } from '@/api';

const state: HistoryState = {
  histories: Array<History>()
};

const getters: GetterTree<HistoryState, RootState> = {
  // Getter declare 'history/findAll'
  findAll(state): History[] {
    return state.histories;
  },
  // Getter declare 'history/findByIdx'
  findByIdx(state): Function {
    return function(idx: number): History | undefined {
      return state.histories.find(history => history.idx === idx);
    };
  }
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
    const data: History[] = await getHistories();
    commit('clear');
    data.forEach(history => commit('add', history));
  }
};

export const history: Module<HistoryState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

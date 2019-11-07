import { Account } from '@/types/types';
import { getAccounts } from '@/api';
import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, AccountState } from '../types';

const state: AccountState = {
  accounts: []
};

const getters: GetterTree<AccountState, RootState> = {
  // Getter declare 'account/findAll'
  findAll: state => state.accounts,
  // Getter declare 'account/findByIdx'
  findByIdx: state => (idx: number) => state.accounts.find(account => account.idx === idx)
};

const mutations: MutationTree<AccountState> = {
  // Mutation declare 'account/clear'
  clear(state): void {
    state.accounts = [];
  },
  // Mutation declare 'account/add'
  add(state, account: Account): void {
    state.accounts.push(account);
  }
};

const actions: ActionTree<AccountState, RootState> = {
  // Action declare 'account/load'
  async load({ commit }): Promise<void> {
    commit('clear');
    const data = await getAccounts();
    data.forEach(account => commit('add', account));
  }
};

const account: Module<AccountState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

export default account;

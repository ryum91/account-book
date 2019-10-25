import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, AccountState } from '../types';
import { Account } from '@/types/types';
import { getAccounts } from '@/api';

const state: AccountState = {
  accounts: Array<Account>()
};

const getters: GetterTree<AccountState, RootState> = {
  // Getter declare 'account/findAll'
  findAll(state): Account[] {
    return state.accounts;
  },
  // Getter declare 'account/findByIdx'
  findByIdx(state): Function {
    return function(idx: number): Account | undefined {
      return state.accounts.find(account => account.idx === idx);
    };
  }
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
    const data: Account[] = await getAccounts();
    commit('clear');
    data.forEach(account => commit('add', account));
  }
};

export const account: Module<AccountState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

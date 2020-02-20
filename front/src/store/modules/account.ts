import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { getAccounts } from '@/api';

const storage: Store.AccountState = {
  accounts: []
};

const getterTree: GetterTree<Store.AccountState, Store.RootState> = {
  // Getter declare 'account/findAll'
  findAll: state => state.accounts,
  // Getter declare 'account/findByIdx'
  findByIdx: state => (idx: number) => state.accounts.find(account => account.idx === idx)
};

const mutationTree: MutationTree<Store.AccountState> = {
  // Mutation declare 'account/clear'
  clear(state): void {
    state.accounts = [];
  },
  // Mutation declare 'account/add'
  add(state, account: Type.Account): void {
    state.accounts.push(account);
  }
};

const actionTree: ActionTree<Store.AccountState, Store.RootState> = {
  // Action declare 'account/load'
  async load({ commit }): Promise<void> {
    commit('clear');
    const data = await getAccounts();

    data.forEach(account => commit('add', account));
  }
};

const account: Module<Store.AccountState, Store.RootState> = {
  namespaced: true,
  state: storage,
  getters: getterTree,
  mutations: mutationTree,
  actions: actionTree
};

export default account;

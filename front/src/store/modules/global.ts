import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { ScreenSize } from '@/constant';

const storage: Store.CommonState = {
  screenSize: ScreenSize.LG
};

const getterTree: GetterTree<Store.CommonState, Store.RootState> = {
  // Getter declare 'global/screenSize'
  screenSize: state => state.screenSize
};

const mutationTree: MutationTree<Store.CommonState> = {
  // Mutation declare 'global/setScreenSize'
  screenSize(state, screenSize: ScreenSize): void {
    state.screenSize = screenSize;
  }
};

const actionTree: ActionTree<Store.CommonState, Store.RootState> = {};

const common: Module<Store.CommonState, Store.RootState> = {
  namespaced: true,
  state: storage,
  getters: getterTree,
  mutations: mutationTree,
  actions: actionTree
};

export default common;

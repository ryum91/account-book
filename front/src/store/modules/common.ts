import { Module, GetterTree, MutationTree, ActionTree } from 'vuex';
import { RootState, CommonState } from '../types';
import { ScreenSize } from '@/types/enums';

const state: CommonState = {
  screenSize: ScreenSize.LG
};

const getters: GetterTree<CommonState, RootState> = {
  // Getter declare 'common/screenSize'
  screenSize: state => state.screenSize
};

const mutations: MutationTree<CommonState> = {
  // Mutation declare 'common/setScreenSize'
  screenSize(state, screenSize: ScreenSize): void {
    state.screenSize = screenSize;
  }
};

const actions: ActionTree<CommonState, RootState> = {
  // Action declare 'common/fetchScreenSize'
  fetchScreenSize({ commit }): void {
    const onResize = () => {
      const width = window.innerWidth;
      if (width >= 1264) {
        commit('screenSize', ScreenSize.LG);
      } else if (width >= 960) {
        commit('screenSize', ScreenSize.MD);
      } else if (width >= 600) {
        commit('screenSize', ScreenSize.SM);
      } else {
        commit('screenSize', ScreenSize.XS);
      }
    };
    onResize();
    window.addEventListener('resize', onResize);
  }
};

export const common: Module<CommonState, RootState> = {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

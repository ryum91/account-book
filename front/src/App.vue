<template>
  <v-app id="app">
    <!-- Top Title -->
    <v-app-bar v-if="!isLoading" clipped-left app height="56">
      <v-app-bar-nav-icon
        v-if="screenSize === ScreenSize.XS"
        @click.stop="isMenuOpen = !isMenuOpen"
      />
      <v-toolbar-title>{{ $t('app.title') }}</v-toolbar-title>
    </v-app-bar>

    <!-- Left Menu -->
    <v-navigation-drawer
      v-if="!isLoading"
      v-model="isMenuOpen"
      :mini-variant="screenSize === 2"
      :permanent="screenSize > 1"
      class="left-menu"
      width="170"
      clipped
      app
    >
      <v-list>
        <v-tooltip v-for="menu in menus" :key="menu.title" :disabled="screenSize !== 2" right>
          <template v-slot:activator="{ on }">
            <router-link :to="menu.link" tag="li">
              <v-list-item link v-on="on">
                <v-list-item-icon>
                  <v-icon>{{ menu.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title v-text="$t(menu.title)"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </router-link>
          </template>
          <span>{{ $t(menu.title) }}</span>
        </v-tooltip>
      </v-list>
    </v-navigation-drawer>

    <!-- Contents -->
    <v-content v-if="!isLoading">
      <v-container fluid>
        <transition name="fade" mode="out-in">
          <router-view />
        </transition>
      </v-container>
    </v-content>

    <!-- Footer -->
    <v-footer v-if="!isLoading" app>
      <span class="px-4">{{ new Date().getFullYear() }}</span>
    </v-footer>

    <div v-if="isLoading" class="loading-wrap">
      <sync-loader :color="'#FFFFFF'" size="20px"></sync-loader>
    </div>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Getter } from 'vuex-class';
import { loadLanguage } from './i18n/index';
import { Lang, ScreenSize } from '@/types/enums';
import SyncLoader from 'vue-spinner/src/SyncLoader.vue';

interface Menu {
  title: string;
  icon: string;
  link: string;
}

@Component({
  components: {
    SyncLoader
  }
})
export default class App extends Vue {
  public beforeCreate() {
    const { dispatch } = this.$store;
    Promise.all([
      dispatch('common/fetchScreenSize'),
      dispatch('category/load'),
      dispatch('account/load'),
      dispatch('history/load'),
      loadLanguage(Lang.KO)
    ]).then(() => {
      this.isLoading = false;
    });
  }

  @Getter('common/screenSize')
  private screenSize?: ScreenSize;
  private ScreenSize = ScreenSize;
  private isLoading: boolean = true;
  private isMenuOpen: boolean = true;
  private menus: Menu[] = [
    {
      title: 'word.main',
      icon: 'mdi-home',
      link: '/'
    },
    {
      title: 'word.list',
      icon: 'mdi-view-list',
      link: '/list'
    },
    {
      title: 'word.calendar',
      icon: 'mdi-calendar',
      link: '/calendar'
    },
    {
      title: 'word.graph',
      icon: 'mdi-chart-bar',
      link: '/graph'
    },
    {
      title: 'word.setting',
      icon: 'mdi-settings',
      link: '/setting'
    }
  ];
}
</script>

<style lang="scss">
@import url(http://cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css);
html {
  overflow-y: auto !important;
}
.loading-wrap {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
  width: 100%;
  height: 0;
  text-align: center;
}
.v-application {
  font-family: 'Nanum Barun Gothic' !important;
}
.left-menu li {
  list-style: none;
}
.fade-enter-active,
.fade-leave-active {
  transition-duration: 0.3s;
  transition-property: opacity;
  transition-timing-function: ease;
}
.fade-enter,
.fade-leave-active {
  opacity: 0;
}
</style>

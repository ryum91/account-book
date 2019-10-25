<template>
  <v-app id="app">
    <v-app-bar clipped-left app>
      <v-app-bar-nav-icon v-if="!isLargeScreen" @click.stop="isMenuOpen = !isMenuOpen" />
      <v-toolbar-title>Account Book</v-toolbar-title>
    </v-app-bar>

    <v-navigation-drawer
      v-model="isMenuOpen"
      :permanent="isLargeScreen"
      :mini-variant="isLargeScreen"
      width="200px"
      class="left-menu"
      clipped
      app
      overflow
    >
      <v-list>
        <v-tooltip v-for="menu in menus" :key="menu.title" :disabled="!isLargeScreen" right>
          <template v-slot:activator="{ on }">
            <router-link :to="menu.link" tag="li">
              <v-list-item link v-on="on">
                <v-list-item-icon>
                  <v-icon large>{{ menu.icon }}</v-icon>
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

    <v-content>
      <router-view />
    </v-content>

    <v-footer app>
      <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script lang="ts">
import { Category, History } from '@/types/types';
import { Getter } from 'vuex-class';
import { Vue, Component, Watch } from 'vue-property-decorator';

interface Menu {
  title: string;
  icon: string;
  link: string;
}

@Component
export default class App extends Vue {
  isMenuOpen: boolean = true;
  isLargeScreen: boolean = true;
  menus: Array<Menu> = [
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
      title: 'word.setting',
      icon: 'mdi-settings',
      link: '/setting'
    }
  ];

  beforeCreate() {
    const { dispatch } = this.$store;
    dispatch('category/load');
    dispatch('account/load');
    dispatch('history/load');
  }

  created() {
    this.onResize();
    window.addEventListener('resize', () => this.onResize());
  }

  onResize() {
    if (window.innerWidth > 600) {
      this.isLargeScreen = true;
    } else {
      this.isLargeScreen = false;
    }
  }
}
</script>

<style lang="scss">
html {
  overflow: hidden !important;
}
.left-menu li {
  list-style: none;
}
</style>

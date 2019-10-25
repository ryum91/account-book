<template>
  <v-app id="app">
    <!-- Top Title -->
    <v-app-bar clipped-left app>
      <v-app-bar-nav-icon v-if="!isLargeScreen" @click.stop="isMenuOpen = !isMenuOpen" />
      <v-toolbar-title>Account Book</v-toolbar-title>
    </v-app-bar>

    <!-- Left Menu -->
    <v-navigation-drawer
      v-model="isMenuOpen"
      :mini-variant="isLargeScreen"
      :permanent="isLargeScreen"
      class="left-menu"
      width="200px"
      overflow
      clipped
      app
    >
      <v-list>
        <v-tooltip v-for="menu in menus" :key="menu.title" :disabled="!isLargeScreen" right>
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
    <v-content>
      <v-container fluid>
        <router-view />
      </v-container>
    </v-content>

    <!-- Footer -->
    <v-footer app>
      <span class="px-4">{{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Freeze } from '@/plugins/custom-decorator';

interface Menu {
  title: string;
  icon: string;
  link: string;
}

@Component
export default class App extends Vue {
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

  private isMenuOpen: boolean = true;
  private isLargeScreen: boolean = true;

  @Freeze()
  private menus: Array<Menu> = [
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

  private onResize() {
    this.isLargeScreen = window.innerWidth > 600;
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

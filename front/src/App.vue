<template>
  <v-app id="sandbox">
    <v-navigation-drawer class="left-menu" clipped mini-variant permanent app overflow>
      <v-list>
        <v-tooltip v-for="menu in menus" :key="menu.title" right>
          <template v-slot:activator="{ on }">
            <router-link :to="menu.link" tag="li">
              <v-list-item link v-on="on">
                <v-list-item-icon>
                  <v-icon large>{{ menu.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title v-text="menu.title"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </router-link>
          </template>
          <span>{{ $t(menu.title) }}</span>
        </v-tooltip>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar clipped-left app>
      <v-toolbar-title>Account Book</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <router-view />
    </v-content>

    <v-footer app>
      <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script lang="ts">
import { Category, History } from '@/types';
import { Getter } from 'vuex-class';
import { Component, Vue } from 'vue-property-decorator';

interface Menu {
  title: string;
  icon: string;
  link: string;
}

@Component
export default class App extends Vue {
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
      title: 'word.settings',
      icon: 'mdi-settings',
      link: '/settings'
    }
  ];

  private beforeCreate() {
    const { dispatch } = this.$store;
    dispatch('category/load');
    dispatch('account/load');
    dispatch('history/load');
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

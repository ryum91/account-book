<template>
  <v-app id="app">
    <!-- Top Title -->
    <v-app-bar clipped-left app>
      <v-app-bar-nav-icon v-if="screenSize === 1" @click.stop="isMenuOpen = !isMenuOpen" />
      <v-toolbar-title>{{ $t('app.title') }}</v-toolbar-title>
    </v-app-bar>

    <!-- Left Menu -->
    <v-navigation-drawer
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
    <v-content>
      <v-container fluid>
        <transition name="fade" mode="out-in">
          <router-view />
        </transition>
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

interface Menu {
  title: string;
  icon: string;
  link: string;
}

@Component
export default class App extends Vue {
  private beforeCreate() {
    const { dispatch } = this.$store;
    dispatch('category/load');
    dispatch('account/load');
    dispatch('history/load');
  }

  private created() {
    this.onResize();
    window.addEventListener('resize', () => this.onResize());
  }

  private isMenuOpen: boolean = true;
  private screenSize: number = 0;
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

  private onResize() {
    const width = window.innerWidth;
    if (width >= 1200) {
      this.screenSize = 3;
    } else if (width >= 600) {
      this.screenSize = 2;
    } else {
      this.screenSize = 1;
    }
  }
}
</script>

<style lang="scss">
@import url(http://cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css);
html {
  overflow: hidden !important;
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

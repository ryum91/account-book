<template>
  <v-app id="sandbox">
    <v-navigation-drawer clipped mini-variant permanent app overflow></v-navigation-drawer>

    <v-app-bar clipped-left app>
      <v-toolbar-title>Account Book</v-toolbar-title>
    </v-app-bar>

    <v-footer app>
      <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script lang="ts">
import { Category, History } from '@/types';
import { Getter } from 'vuex-class';
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class App extends Vue {
  public beforeCreate() {
    this.$store.dispatch('category/load');
    this.$store.dispatch('account/load');
    this.$store.dispatch('history/load');
  }
}
</script>

<style lang="scss">
html {
  overflow: hidden !important;
}
</style>

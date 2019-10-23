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

<style lang="scss">
html {
  overflow: hidden !important;
}
</style>

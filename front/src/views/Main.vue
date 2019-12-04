<template>
  <div class="main">
    <h1>This is an main page</h1>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import errorAlert from '@/helper/alert';

@Component
export default class Main extends Vue {
  public beforeCreate() {
    const { name: routeName } = this.$route;
    if ('notfound' === routeName) {
      errorAlert({
        title: '404 Not Found',
        text: this.$t('error.404').toString()
      }).then(() => {
        this.$router.replace('/');
      });
    }
  }
}
</script>

<template>
  <div class="main">
    <h1>This is an main page</h1>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import Swal from 'sweetalert2';

@Component
export default class Main extends Vue {
  public beforeCreate() {
    const { name: routeName } = this.$route;
    if ('notfound' === routeName) {
      Swal.fire({
        type: 'error',
        title: '404 Not Found',
        heightAuto: false,
        text: this.$t('message.error.404').toString()
      }).then(() => {
        this.$router.replace('/');
      });
    }
  }
}
</script>

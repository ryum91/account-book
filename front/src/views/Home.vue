<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
  </div>
</template>

<script lang="ts">
import { Category } from '@/types';
import { Getter } from 'vuex-class';
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Home extends Vue {
  @Getter('category/findAll')
  private categories!: Category[];

  public created() {
    this.$store.dispatch('category/load');
  }
}
</script>

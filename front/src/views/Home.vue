<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script lang="ts">
import { Category } from '@/types';
import { Getter } from 'vuex-class';
import { Component, Vue } from 'vue-property-decorator';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

@Component({
  components: {
    HelloWorld
  }
})
export default class Home extends Vue {
  @Getter('category/categories')
  categories!: () => Category[];

  public created() {
    this.$store.dispatch('category/fetchCategories');
    console.log(this.categories);
  }
}
</script>

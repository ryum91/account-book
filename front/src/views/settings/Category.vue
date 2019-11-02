<template>
  <v-dialog v-model="isOpen">
    <v-card>
      <v-card-title class="headline">Use Google's location service?</v-card-title>
      <v-card-text>
        Let Google help apps determine location. This means sending anonymous location data to
        Google, even when no apps are running.
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { Vue, Component, Watch } from 'vue-property-decorator';

type Flag = 'in' | 'out';

@Component
export default class Category extends Vue {
  private flag!: Flag | null;
  private isOpen: boolean = true;

  public created() {
    this.flag = this.$attrs.flag as Flag;
  }

  private back() {
    this.$router.replace('/setting');
  }

  @Watch('$route.params.flag')
  private onChangeFlag(val: Flag) {
    this.flag = val;
    this.isOpen = true;
  }

  @Watch('isOpen')
  private onChangeIsOpen(val: boolean) {
    if (!val) {
      this.back();
    }
  }
}
</script>

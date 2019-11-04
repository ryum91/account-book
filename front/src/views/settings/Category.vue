<template>
  <v-dialog v-model="isOpen" max-width="600" scrollable>
    <v-card>
      <v-card-title class="headline">
        <v-icon v-if="unit === 'PLUS'" dense class="mr-2">mdi-application-import</v-icon>
        <v-icon v-if="unit === 'MINUS'" dense class="mr-2">mdi-application-export</v-icon>
        <span>{{ $t(`word.category_setting_${unit}`) }}</span>
      </v-card-title>
      <v-card-text>
        <v-list-group
          v-for="category in categories.filter(e => e.parentIdx === 0)"
          :key="category.idx"
          no-action
        >
          <template v-slot:activator>
            <v-list-item-avatar>
              <v-icon>mdi-silverware-fork-knife</v-icon>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title>{{ category.name }}</v-list-item-title>
              <v-list-item-subtitle>
                {{ `하위 ${categories.filter(e => e.parentIdx === category.idx).length}개` }}
              </v-list-item-subtitle>
            </v-list-item-content>
          </template>

          <v-list-item
            v-for="subCategory in categories.filter(e => e.parentIdx === category.idx)"
            :key="subCategory.idx"
            link
          >
            <v-list-item-avatar>
              <v-icon>mdi-silverware-fork-knife</v-icon>
            </v-list-item-avatar>
            <v-list-item-title>{{ subCategory.name }}</v-list-item-title>
          </v-list-item>
        </v-list-group>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { Vue, Component, Watch } from 'vue-property-decorator';
import { Getter } from 'vuex-class';
import { Category } from '@/types/types';
import { Unit } from '@/types/types';

@Component
export default class CategoryComp extends Vue {
  private unit!: Unit;
  private isOpen: boolean = true;
  private categories: Category[] = [];

  public created() {
    this.unit = this.$attrs.unit as Unit;
    this.isOpen = true;
    this.categories = this.getCategories(this.unit);
  }

  @Watch('isOpen')
  private onChangeIsOpen(val: boolean) {
    if (!val) {
      this.$router.replace('/setting');
    }
  }

  @Getter('category/findList')
  private getCategories!: (unit: Unit) => Category[];
}
</script>

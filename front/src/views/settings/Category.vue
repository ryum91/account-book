<template>
  <v-dialog v-model="isOpen" max-width="600" scrollable>
    <v-card>
      <v-card-title class="headline">{{ $t(`word.category_setting_${unit}`) }}</v-card-title>
      <v-card-text>
        <v-list-group
          v-for="category in categories.filter(e => e.parentIdx === 0)"
          :key="category.idx"
          no-action
          sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>{{ category.name }}</v-list-item-title>
            </v-list-item-content>
          </template>

          <v-list-item
            v-for="subCategory in categories.filter(e => e.parentIdx === category.idx)"
            :key="subCategory.idx"
            link
          >
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
import { Unit } from '@/types/enums';

interface UnitMapType {
  [key: string]: Unit;
}

const unitMap: UnitMapType = {
  in: Unit.PLUS,
  out: Unit.MINUS
};

@Component
export default class CategoryComp extends Vue {
  private unit!: Unit;
  private isOpen: boolean = true;
  private categories: Category[] = [];

  public created() {
    this.unit = unitMap[this.$attrs.flag];
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

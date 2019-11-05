<template>
  <v-dialog v-model="isOpen" max-width="600" scrollable>
    <v-card>
      <v-card-title class="headline category-dialog-title">
        <v-icon v-if="unit === 'PLUS'" dense class="mr-2">mdi-application-import</v-icon>
        <v-icon v-if="unit === 'MINUS'" dense class="mr-2">mdi-application-export</v-icon>
        <span>{{ $t(`word.category_setting_${unit}`) }}</span>
      </v-card-title>
      <v-card-text>
        <v-list-item
          v-for="category in categories"
          :key="category.idx"
          @click="category.parentIdx === 0 ? onClickItem(category.idx) : null"
        >
          <v-list-item-avatar>
            <v-icon>{{ category.icon }}</v-icon>
          </v-list-item-avatar>
          <v-list-item-content>
            <v-list-item-title>{{ category.name }}</v-list-item-title>
          </v-list-item-content>

          <v-list-item-action v-if="category.idx !== 0">
            <v-btn icon @click="onClickMenu($event, category.idx)">
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
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
    this.categories = this.getCategories({ unit: this.unit, parentIdx: 0 });
  }

  @Watch('isOpen')
  private onChangeIsOpen(val: boolean) {
    if (!val) {
      this.$router.replace('/setting');
    }
  }

  private onClickItem(idx: number) {
    if (idx === 0) {
      this.categories = this.getCategories({ unit: this.unit, parentIdx: idx });
    } else {
      this.categories = [
        { idx: 0, icon: 'mdi-folder-upload', name: '...', unit: this.unit, parentIdx: 0 },
        ...this.getCategories({ unit: this.unit, parentIdx: idx })
      ];
    }
  }

  private onClickMenu(event: MouseEvent, idx: number) {
    console.log('onClickMenu', idx);
    event.stopPropagation();
  }

  @Getter('category/findList')
  private getCategories!: ({ unit, parentIdx }: { unit: Unit; parentIdx: number }) => Category[];
}
</script>

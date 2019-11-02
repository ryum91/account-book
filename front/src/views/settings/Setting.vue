<template>
  <div class="settings">
    <v-row dense>
      <v-col v-for="(item, index) in items" :key="index" cols="12" lg="3" md="4" sm="6" xs="12">
        <v-card hover link :to="item.link" replace>
          <v-card-title>
            <div>
              <v-icon dense class="mr-2">{{ item.icon }}</v-icon>
              <span>{{ item.title }}</span>
            </div>
          </v-card-title>
          <v-card-subtitle>
            <div>{{ item.description }}</div>
          </v-card-subtitle>
        </v-card>
      </v-col>
    </v-row>
    <router-view />
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Getter } from 'vuex-class';

interface Item {
  icon: string;
  title: string;
  description: string;
  link: any;
}

@Component
export default class Setting extends Vue {
  private items: Item[] = [
    {
      icon: 'mdi-application-import',
      title: '수입 카테고리 설정',
      description: '수입 내역 카테고리를 관리합니다.',
      link: {
        name: 'setting/category/in'
      }
    },
    {
      icon: 'mdi-application-export',
      title: '지출 카테고리 설정',
      description: '지출 내역 카테고리를 관리합니다.',
      link: {
        name: 'setting/category/out'
      }
    }
  ];

  public beforeCreate() {
    console.log('setting created');
  }
}
</script>

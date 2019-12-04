<template>
  <div class="settings">
    <v-row dense>
      <v-col v-for="(item, index) in items" :key="index" cols="12" lg="3" md="4" sm="6" xs="12">
        <v-card hover link :to="item.link" replace>
          <v-card-title>
            <div>
              <v-icon dense class="mr-2">{{ item.icon }}</v-icon>
              <span>{{ $t(item.title) }}</span>
            </div>
          </v-card-title>
          <v-card-subtitle>
            <div>{{ $t(item.description) }}</div>
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
      icon: 'mdi-application',
      title: 'word.account_setting',
      description: 'message.account_description',
      link: {
        name: 'setting/account'
      }
    },
    {
      icon: 'mdi-application-import',
      title: 'word.category_setting_PLUS',
      description: 'message.category_description_PLUS',
      link: {
        name: 'setting/category/in'
      }
    },
    {
      icon: 'mdi-application-export',
      title: 'word.category_setting_MINUS',
      description: 'message.category_description_MINUS',
      link: {
        name: 'setting/category/out'
      }
    }
  ];
}
</script>

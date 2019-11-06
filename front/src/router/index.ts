import Vue from 'vue';
import VueRouter, { RouteConfig } from 'vue-router';

Vue.use(VueRouter);

const routes: RouteConfig[] = [
  {
    name: 'main',
    path: '/',
    component: () => import('../views/Main.vue')
  },
  {
    name: 'list',
    path: '/list',
    component: () => import('../views/List.vue')
  },
  {
    name: 'calendar',
    path: '/calendar',
    component: () => import('../views/Calendar.vue')
  },
  {
    name: 'graph',
    path: '/graph',
    component: () => import('../views/Graph.vue')
  },
  {
    name: 'setting',
    path: '/setting',
    component: () => import('../views/settings/Setting.vue'),
    children: [
      {
        name: 'setting/account',
        path: 'account',
        component: () => import('../views/settings/Account.vue')
      },
      {
        name: 'setting/category/in',
        path: 'category/in',
        component: () => import('../views/settings/Category.vue'),
        props: {
          unit: 'PLUS'
        }
      },
      {
        name: 'setting/category/out',
        path: 'category/out',
        component: () => import('../views/settings/Category.vue'),
        props: {
          unit: 'MINUS'
        }
      }
    ]
  },
  {
    name: 'notfound',
    path: '*',
    component: () => import('../views/Main.vue')
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;

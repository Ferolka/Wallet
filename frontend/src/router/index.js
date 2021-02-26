import Vue from 'vue'
import VueRouter from 'vue-router'
import Outcomes from '../views/Outcomes.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/main',
    name: 'Outcomes',
    component: Outcomes
  },
  {
    path: '/',
    name: 'Outcomеs',
    component: Outcomes
  },
  {
    path: '/settings',
    name: 'Settings',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Settings.vue')
    }
  },
  {
    path: '/incomes',
    name: 'Incomes',
    component: function () {
      return import('../views/Incomes.vue')
    }
  },
  {
    path: '/auth',
    name: 'Auth',
    component: function () {
      return import('../views/Auth.vue')
    }
  },
  {
    path: '/statistic',
    name: 'Statistic',
    component: function () {
      return import('../views/Statistic.vue')
    }
  },
  {
    path: '/calendar',
    name: 'Calendar',
    component: function () {
      return import('../views/Calendar.vue')
    }
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router

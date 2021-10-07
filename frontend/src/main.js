import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import {store} from './store'
import axios from "axios";

Vue.config.productionTip = false

axios.defaults.baseURL = 'http://localhost:8080/api/';
axios.defaults.headers.Authorization = 'Bearer ' + localStorage.getItem("token");

new Vue({
  vuetify,
  router,
  store: store,
  render: h => h(App)
}).$mount('#app')

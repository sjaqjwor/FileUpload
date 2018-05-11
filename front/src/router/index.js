import Vue from 'vue'
import Router from 'vue-router'
import InputFile from '@/components/InputFile'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'InputFile',
      component: InputFile
    }
  ]
})

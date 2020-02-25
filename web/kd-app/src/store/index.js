import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import user from './modules/user'
import useredit from './modules/useredit'
import category from './modules/category'
import article from './modules/article'


export default new Vuex.Store({
  modules:{
    user,
    useredit,
    category,
    article,
  }
})

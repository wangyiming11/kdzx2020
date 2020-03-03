import axios from '@/http/axios'
import editor from 'mavon-editor'
export default {
  namespaced: true,
  state: {
    users: [],
    editors: [],
    admins: []
  },
  mutations: {
    resetUsers (state, data) {
      const res = data.filter(item => item.role === 'user')
      state.users = res
    },
    resetEditors (state, data) {
      const res = data.filter(item => item.role === 'editor')
      state.editors = res
    },
    resetAdmins (state, data) {
      const res = data.filter(item => item.role === 'admin')
      state.admins = res
    }
  },
  actions: {
    // 1.保存用户
    saveUser (context, params) {
      return new Promise((resolve, reject) => {
        axios.post('/manager/user/saveOrUpdateUser', params).then((res) => {
          resolve(res)
        }).catch((err) => {
          reject(err)
        })
      })
    },
    // 2.改变用户的状态
    changeUserStatus (context, params) {
      return new Promise((resolve, reject) => {
        axios.post('/manager/user/changeStatus', params).then((res) => {
          resolve(res)
        }).catch((err) => {
          reject(err)
        })
      })
    },
    // 3.加载所有的用户信息
    async loadUsers (context) {
      const response =  await axios.get('/manager/user/findAllUser')
      context.commit('resetUsers', response.data.data)
      context.commit('resetEditors', response.data.data)
      context.commit('resetAdmins', response.data.data)
    }
  }
}

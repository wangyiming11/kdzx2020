import axios from '@/http/axios';
export default {
  state:{
   users:[]
  },
  getters:{
   users:state=>state.users
  },
  mutations:{
    changeUser(state,data){
      // console.log(data)
      state.users = data
    }
  },
  actions:{
    // 保存用户
    saveUser(context,params){
         return new Promise((resolve,reject)=>{
          axios.post('/manager/user/saveOrUpdateUser',params).then((res)=>{
            resolve(res)
          }).catch((err)=>{
            reject(err)
          })
      })
    },
    // 改变用户的状态
    changeUserStatus(context,params){
       return new Promise((resolve,reject)=>{
          axios.post('/manager/user/changeStatus',params).then((res)=>{
            resolve(res)
          }).catch((err)=>{
            reject(err)
          })
      })
    },
    // 加载所有的用户信息
    loadUsers(context){
      return new Promise((resolve,reject)=>{
          axios.get('/manager/user/findAllUser').then((res)=>{
            context.commit('changeUser',res.data.data)
            resolve(res)
          }).catch((err)=>{
            reject(err)
          })
      })
    }
  }
}
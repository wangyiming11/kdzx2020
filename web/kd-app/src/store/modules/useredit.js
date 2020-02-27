import {get, post} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        users:[]
    },
    mutations: {
        refreshUsers(state,users){
            state.users = users;
        }
    },
    actions: {
        // 根据当前用户id查询所有信息
        async findAllUsers({commit,rootState}){
            console.log('rootState',rootState)
            let name = rootState.user.info.name
            let response = await get('/manager/user/findUserByUsername?username='+name)
            commit('refreshUsers',response.data)
        },
        // 添加修改地址
        UpdateUser(context,params){
            return new Promise((resolve,reject)=>{
             axios.post('/manager/user/saveOrUpdateUser',params).then((res)=>{
               resolve(res)
             }).catch((err)=>{
               reject(err)
             })
         })
       },
    }
}
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
        // 根据当前用户名查询用户信息
        async findAllUsers({commit,rootState}){
            console.log('rootState',rootState)
            let name = rootState.user.info.name
            let response = await get('/manager/user/findUserByUsername?username='+name)
            commit('refreshUsers',response.data)
        },
        // 修改用户信息
        async UpdateUser({commit},form){
            console.log('form',form)
            let response = await post('/manager/user/saveOrUpdateUser',form)
            commit('refreshUsers',response.data)
       },
    }
}
import {get,post} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        categories:[]
    },
    mutations :{
        refreshCategories(state,categories){
            state.categories = categories
        }
    },
    actions :{
        // 查找所有栏目分类信息
        async findAllCategories({commit}) {
            let response = await get('/manager/category/findAllCategory')
            // console.log('response',response)
            commit('refreshCategories',response.data)
        }
    }
 }
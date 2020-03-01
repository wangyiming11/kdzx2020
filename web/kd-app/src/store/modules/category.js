import {get,post} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        categories:[],
        childs:[]
    },
    mutations :{
        //重置父栏目
        refreshCategories(state,categories){
            state.categories = categories
        },
        //重置子栏目
        refreshChilds(state,childs){
            state.childs = childs
        }
    },
    actions :{
        // 查找所有栏目分类信息
        async findAllCategories({commit}) {
            let response = await get('/manager/category/findAllCategory')
            // console.log('response',response)
            commit('refreshCategories',response.data)
        },
         // 查找所有子栏目分类信息
         async findAllChilds({commit},id) {
             console.log(id)
            let response = await get('/manager/category/findCategoryByParentId?id='+id)
            // console.log('子栏目',response)
            commit('refreshChilds',response.data)
        }
    }
 }
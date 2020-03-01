import {post,get} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        articles:[],
        details:[],
        childs:[]
    },
    mutations :{
        refreshDetails(state,details){
            state.details = details
        },
        refreshArticles(state,articles){
            state.articles = articles
        },
        refreshChildCate(state,childs){
            state.childs = childs
        }
    },
    actions :{
        async findChild({commit},id){
            // this.findAllChilds({id})
            let response = await get('/manager/category/findCategoryByParentId?id='+id)
            commit('refreshChildCate',response.data)
        },
        // 查找所有文章信息
        async QueryArticles({commit},id) {
            let response = await get('/index/findArticleByCategoryId?categoryId='+id)
            // console.log('response',response)
            commit('refreshArticles',response.data)

        },
         // 添加修改文章
         async SaveOrUpdateArticle({dispatch},form){
            let response = await post('/manager/article/saveOrUpdateArticle',form)
            dispatch('QueryArticles')
            return response
        },
        // 根据当前文章id查询文章详情
        async readArticle({commit},id){
            let response = await get('index/readArticle?id='+id)
            commit('refreshdetails',response.data)
        }
    }
 }
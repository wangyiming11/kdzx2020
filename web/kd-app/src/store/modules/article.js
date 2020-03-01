import {post,get} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        articles:[],
        details:[],
    },
    mutations :{
        refreshDetails(state,details){
            state.details = details
        },
        refreshArticles(state,articles){
            state.articles = articles
        }
    },
    actions :{
        // 查找所有文章信息
        async QueryArticles({commit},id) {
            let response = await get('/index/findArticleByCategoryId?id='+id)
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
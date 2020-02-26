import {post,get} from '../../http/axios'
export default {
    namespaced:true,
    state: {
        articles:[],
        details:[],
    },
    getters: {
        articleCustomerFilter(state){
            return(categoryId)=>{
                return state.articles.filter(item=>item.categoryId === categoryId)
            }
        }
    },
    mutations :{
        refreshArticles(state,articles){
            state.articles = articles
        }
    },
    actions :{
        // 查找所有商品分类信息
        async QueryArticles({commit}) {
            let response = await get('/index/findArticleByCategoryId')
            // 为产品添加number属性
            // response.data.list.forEach(item=>{
            //     item.number = 0;
            // })
            console.log('response',response)
            commit('refreshArticles',response.data)

        },
         // 添加修改文章
         async SaveOrUpdateArticle({dispatch},form){
            let response = await post('/manager/article/saveOrUpdateArticle',form)
            dispatch('QueryArticles')
            return response
        },
    }
 }
import axios from '@/http/axios';
export default {
  namespaced: true,
  state: {
    article: [],
    total: 10
  },
  mutations: {
    // 1.重置文章
    resetArticle (state, article) {
      state.article = article
    },
    // 2.重置total
    resetTotal (state, total) {
      state.total = total
    },
    // // 3.重置page
    // resetPage (state, page) {
    //   state.page = page - 1
    //   console.log(state.page)
    // }
  },
  actions: {
    // 1.分页加载文章
    async loadArticle ({ commit }, payload) {
      await axios.get('/manager/article/findArticle', {
        params: payload
      }).then((response) => {
        commit('resetArticle', response.data.data.list)
        commit('resetTotal', response.data.data.total)
      })
    },
    // 2.保存或更新文章信息
    async saveOrUpDateArticle ({ dispatch }, article) {
      let response = await axios.post('/manager/article/saveOrUpdateArticle', article)
      return response
    },
    // 3.通过ID删除文章
    async deleteArticleById ({ dispatch }, id) {
      await axios.get('/manager/article/deleteArticleById?id=' + id)
    },
    // 4. 批量删除文章
    async batchDelectArticle (context, ids) {
      await axios.post('/manager/article/batchDeleteArticle', ids)
    }
  }
}
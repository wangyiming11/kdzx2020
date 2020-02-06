import axios from '@/http/axios';
export default {
  namespaced: true,
  state: {
    article: [],
    page: 1,
    total: 10,
    pageSize: 5,
    categoryId: null
  },
  getters: {
   
  },
  mutations: {
    // 1.重置文章
    resetArticle (state, article) {
      state.article = article
    },
    // 2.重置total
    resetTotal (state, total) {
      state.total = total
    }
  },
  actions: {
    // 1.分页加载文章
    async loadArticle ({ commit }, payload) {
      console.log(payload.page)
      console.log(payload.pageSize)
      let response = await axios.get('/manager/article/findArticle', {
        params: payload
      })
      commit ('resetArticle', response.date.date.list)
      commit ('resetTotal', response.date.date.total)
      console.log(response)
    }
  }
}
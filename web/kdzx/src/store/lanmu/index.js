import axios from '@/http/axios'
export default {
  namespaced: true,
  state: {
    categories: [],
    children: []
  },
  getters: {
    categories: state => state.categories
  },
  mutations: {
    changeCategories (state, data) {
      const res = data.filter(item => item.parent === null)
      state.categories = res
    },
    change2_categories (state, content) {
      state.children = content
    }
  },
  actions: {
    // 批量删除
    deleteAllLm (context, params) {
      return new Promise((resolve, reject) => {
        axios.post('/manager/category/batchDeleteCategory', params).then((res) => {
          resolve(res)
        }).catch((error) => {
          reject(error)
        })
      })
    },
    // 删除栏目
    async deleteLm (context, id) {
      const response = await axios.get('/manager/category/deleteCategoryById?id=' + id)
      // console.log('删除结果' + response.status)
      return response
    },
    // 保存栏目
    saveCategories (context, params) {
      return new Promise((resolve, reject) => {
        axios.post('/manager/category/saveOrUpdateCategory', params).then((res) => {
          resolve(res)
        }).catch((error) => {
          reject(error)
        })
      })
    },
    // 加载所有栏目
    loadCategories (context) {
      return new Promise((resolve, reject) => {
        axios.get('/manager/category/findAllCategory').then((res) => {
          context.commit('changeCategories', res.data.data)
          resolve(res)
        }).catch((error) => {
          reject(error)
        })
      })
    },
    // 1.根据父栏目查询子栏目
    async findCategoryByParentId (context, id) {
      const response = await axios.get('/manager/category/findCategoryByParentId?id=' + id)
      context.commit('change2_categories', response.data.data)
    }
  }
}

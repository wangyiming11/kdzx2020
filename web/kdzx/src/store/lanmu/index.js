import axios from '@/http/axios';
export default {
  state:{
    categories:[]
  },
  getters:{
   	categories:state=>state.categories 
  },
  mutations:{
    changeCategories(state,data){
		state.categories = data
    }
  },
  actions:{
    // 批量删除
    deleteAllLm(context,params){
      return new Promise((resolve,reject)=>{
          axios.post('/manager/category/batchDeleteCategory',params).then((res)=>{
            resolve(res)
          }).catch((error)=>{
            reject(error)
          })
        })
    },
    // 删除栏目
    deleteLm(context,id){
      return new Promise((resolve,reject)=>{
          axios.get('/manager/category/deleteCategoryById?id='+id).then((res)=>{
            resolve(res)
          }).catch((error)=>{
            reject(error)
          })
        })
    },
    // 保存栏目
      saveCategories(context,params){
         return new Promise((resolve,reject)=>{
          axios.post('/manager/category/saveOrUpdateCategory',params).then((res)=>{
            resolve(res)
          }).catch((error)=>{
            reject(error)
          })
        })
      },
    // 加载所有栏目
    loadCategories(context){
		 return new Promise((resolve,reject)=>{
        axios.get('/manager/category/findAllCategory').then((res)=>{
          context.commit("changeCategories",res.data.data)
          resolve(res)
        }).catch((error)=>{
          reject(error)
        })
      })
    }
  }
}
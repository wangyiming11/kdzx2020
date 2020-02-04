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
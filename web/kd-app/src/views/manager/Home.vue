<template>
  <div class="home">
    <!-- 头部 -->
    <div class="header">
      看点资讯精选
    </div>
    <van-tabs color="#2E8FF4">
      <van-tab v-for="item in categories" :key='item.id'>
        <div class="tab-title" slot="title" @click="findChildHandler(item.id)">{{ item.name }}</div>
          <van-tabs color="#2E8FF4">
            <van-tab v-for="item in childs" :key='item.id'>
                <div class="tab-title" slot="title" @click="findArticleHandler(item.id)">{{ item.name }}</div>
                <div class="article"
                v-for='item in articles' 
                :key="item.id"
                @click="ShowArticlesHandler(item.id)">
                  <van-row span="14">
                    <van-col span="8">
                      <van-image
                      round
                      width="4rem"
                      height="4rem"
                      :src="item.author.userface"
                      /></van-col>
                     <van-col span="16">
                      <van-row >{{item.author.username}}</van-row>
                      <van-row >{{item.author.regTime}}</van-row>
                    </van-col>
                  </van-row>
                  <van-row>{{item.content}}</van-row>
                </div>
            </van-tab>
          </van-tabs>
      </van-tab>
    </van-tabs>

    <!-- {{categories}} -->
    <!-- {{articles}} -->
    <!-- {{childs}} -->

   
  </div>
</template>
<script>
import {mapState, mapActions} from 'vuex'
import {get,post} from '../../http/axios'
export default {
  data() {
      return{
          childs:[],
      }
  },
  computed:{
    ...mapState('category',['categories']),
    ...mapState('article',['articles']),
  },
  created(){
    this.findAllCategories();
    this.QueryArticles();
  },
  methods:{
    ...mapActions('category',['findAllCategories']),
    ...mapActions('article',['QueryArticles']),
    // 页面跳转文章详情页面
    ShowArticlesHandler(id){
      console.log("文章id",id)
      this.$router.push({path:'/manager/article',query:{id}})
    },
    //查询子栏目
    async findChildHandler(id){
      console.log("父栏目id",id)
      // this.findAllChilds({id})
      let response = await get('/manager/category/findCategoryByParentId?id='+id)
      this.childs=response.data
       this.QueryArticles(id)
    },
    //分类查询文章
    findArticleHandler(id){
      console.log("子栏目id",id)
      this.QueryArticles(id)
    }
  }
}
</script>
<style scoped>
.header {
  height: 50px;
  line-height: 50px;
  background-color: #2E8FF4;
  font-size: 17px;
  color: white;
  font-weight: bold;
  text-align: center;
}
.article{
  line-height: 50px;
  font-size: 17px;
  border:1px solid #ededed;
}
</style>
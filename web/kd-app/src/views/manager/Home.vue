<template>
  <div class="home">
    <!-- 头部 -->
    <div class="header">
      看点资讯精选
    </div>
    <van-tabs>
      <van-tab 
      v-for="index in categories.length" 
      :title="categories[index-1].name" :key="categories[index-1].name">
        <div class="list" style="margin-top:1em">
          <van-card
             v-for="index in articles.length" 
             :title="articles[index-1].name" 
             :key="articles[index-1].id"
            :num="articles[index-1].readtime"
            :desc="articles[index-1].content"
            :thumb="articles[index-1].author.userface">
            <div slot="tags" >
              <van-tag plain type="default">{{articles[index-1].author.username}}</van-tag>
              <van-tag plain type="default">{{articles[index-1].author.regTime}}</van-tag>
            </div>
            <div slot="footer">
              <van-button size="mini" to="article">详情</van-button>
            </div>
          </van-card>
        </div> 
      </van-tab>
    </van-tabs>

    <!-- {{categories}} -->
    <!-- {{articles}} -->

   
  </div>
</template>
<script>
import {mapState, mapActions} from 'vuex'

export default {
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
    // // 页面跳转产品分类，显示更多的栏目
    // ShowCategoriesHandler(){
    //   var obj = {
    //     id:this.categories[0].id,
    //     activeKey:0
    //   }
    //   this.$router.push({path:'/manager/article_list',query:obj})
    // },
    // // 栏目区域 页面跳转至商品分类，各个产品
    // toArticleHandler(id,activeKey){
    //   this.$router.push({path:'/manager/article',query:{id,activeKey}})
    // },
    // // 产品区域 页面跳转商品分类
    // toArticleListHandler(id,activeKey){
    //   this.$router.push({path:'/manager/article',query:{id,activeKey}})
    // },
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
</style>
<template>
  <div class="home">
    <!-- 头部 -->
    <div class="header">
      wenzhang
    </div>
 

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
    ...mapActions('article',['QueryArticles'],['readArticle']),
    // 页面跳转文章详情页面
    ShowArticlesHandler(){
      this.$router.push({path:'/manager/article',id})
    },
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
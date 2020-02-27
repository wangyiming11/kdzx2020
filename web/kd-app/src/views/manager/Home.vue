<template>
  <div class="home">
    <!-- 头部 -->
    <div class="header">
      看点资讯精选
    </div>
    <van-tabs color="#2E8FF4">
      <van-tab 
      v-for="item in categories" 
      :title="item.name" 
      :key="item.id"
      @click="findChildHandler(item.id)">
          <!-- <van-tabs>
            <van-tab 
            v-for="index in childs.length" 
            :title="childs[index-1].name" 
            :key="childs[index-1].name"
            @click="findArticleHandler()">
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
                    <van-button size="mini" @click.proevent="ShowArticlesHandler(articles[index-1].id)">详情</van-button>
                  </div>
                </van-card>
              </div> 
            </van-tab>
          </van-tabs> -->
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
    ...mapState('category',['categories'],['childs']),
    ...mapState('article',['articles']),
  },
  created(){
    this.findAllCategories();
    this.QueryArticles();
  },
  methods:{
    ...mapActions('category',['findAllCategories'],['findAllChilds']),
    ...mapActions('article',['QueryArticles'],['readArticle']),
    // 页面跳转文章详情页面
    ArticlesHandler(){
      this.$router.push({path:'/manager/article',id})
    },
    //查询子栏目
    findChildHandler(id){
      console.log("id",id)
      this.findAllChilds(id)
    },
    //分类查询文章
    findArticleHandler(){
      let id = this.childs[index-1].id
      this.readArticle(id)
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
</style>
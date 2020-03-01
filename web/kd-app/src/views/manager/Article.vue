<template>
  <div class="home">
    <div class="header">文章详情</div>
    <!-- 文章详情 -->
    <van-panel :title="details.title" style="text-align:center">
        <van-tag color="#7232dd" plain>点赞次数：{{details.thumbup}}</van-tag>
        <van-tag color="#7232dd" plain>鄙视次数：{{details.thumbdown}}</van-tag>
      <div>{{details.author.username}}<van-tag></van-tag>{{details.publishtime}}</div>
     <h4>{{details.content}}</h4>
    </van-panel>
    <div style="text-align:left; margin:1em 1.5em">评论</div>
    <div v-for="item in details.comments" 
    style="margin:1em 1.5em; text-align:left;" 
    :key="item.id">
      <div>{{item.content}}</div>
      <div>{{item.commenttime}}</div>
    </div>
    <!-- /文章详情 -->
    <!--发表评论 -->
      {{message}}
      <van-sticky :offset-top="400">
        <van-field
        v-model="message"
        rows="1"
        autosize
        type="textarea"
        placeholder="请输入评论内容">
        <van-button 
        slot="button" 
        size="small" 
        type="info"
        @click="commentHandler()">发表评论</van-button>
        </van-field>
      </van-sticky>
    <!-- 发表评论 -->
  </div>
</template>
<script>
import {mapState, mapActions} from 'vuex'
import {get,post} from '../../http/axios'

export default {
  data() {
      return{
        details:[],
        message:'',
      }
  },
  created(){
    console.log("传递id",this.$route.query.id)
    let id = this.$route.query.id;
    this.QueryArticles(id)
    this.getTime();
  },
  methods:{
    ...mapActions('article',['readArticle']),
    // 页面跳转文章详情页面
    ShowArticlesHandler(){
      this.$router.push({path:'/manager/home'})
    },
    //查询文章
    async QueryArticles(id){
      let response = await get('/index/readArticle?id='+id)
      this.details=response.data
    },
    //发表评论
    async commentHandler(){
      console.log("当前时间",new Date().toLocaleString())
      let form = {
          commenttime:new Date().toLocaleString(),
          articleId:this.$route.query.id,
          customerId:this.details.author.id,
          content:this.message,    
        }
      console.log("form值",form)
      let response = await post('/manager/comment/saveOrUpdateComment',form)  
      this.QueryArticles(this.$route.query.id)
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
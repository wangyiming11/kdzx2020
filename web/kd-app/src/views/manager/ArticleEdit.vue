<template>
    <!-- 顶部导航栏 -->
    <div class="form">
         <van-nav-bar
        title="发布文章"

        />
        {{form}}
        <van-cell-group>
            <van-field
            v-model="form.title"
            clearable
            label="标题"
            placeholder="请输入文章标题"
            icon="question-o"
            />
            <van-field
            v-model="form.liststyle"
            clearable
            label="列表样式"
            placeholder="请输入列表样式"
            icon="question-o"
            />
            <van-field
            v-model="form.music"
            clearable
            placeholder="请输入音乐地址 "
            label="音乐地址"
            icon="question-o"
            />
            <van-field
            v-model="form.video"
            clearable
            label="视频地址"
            placeholder="请输入视频地址"
            icon="question-o"
            />
            <van-field
            v-model="form.content"
            rows="1"
            autosize
            label="内容"
            type="textarea"
            placeholder="请输入文章内容"
            />
        </van-cell-group>           
        <!-- 编辑信息 -->
        <van-button 
            @click="backListHandler()" 
            size="large" 
            type="info">发布</van-button>
        <!-- /编辑信息 -->
    </div>
    <!-- /顶部导航栏 -->
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
    data() {
        return{
            form:{ },
        }
    },

    created() {

    },
    methods: {
        ...mapActions('article',['SaveOrUpdateArticle']),
        // 回到个人页面
        backListHandler(){
            this.$router.push({path:'/manager/user'})
            console.log('表单数据' + this.form)
            this.saveOrUpDateArticle(this.form)
            .then((response) => {
                let payload = {
                    page:this.page,
                    pageSize: this.pageSize,
                    categoryId: this.categoryId
                }
                this.loadArticle(payload)
                this.$message({type:"success",message:'操作成功'});
            })
        },
        
        }
       
}
</script>

<style>
.van-col .one{
    border-bottom: 1px solid #efefef;
    padding:1em；
}
</style>
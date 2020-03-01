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
            clear
            />
            <van-field
            v-model="form.liststyle"
            clearable
            label="列表样式"
            placeholder="请输入列表样式"
            icon="question-o"
            />
            <van-field
            readonly
            clickable
            label="栏目"
            :value="form.categoryId"
            placeholder="请选择栏目"
            @click="showPicker = true"
            />
            <van-popup v-model="showPicker" position="bottom">
                <van-picker
                    valid-v-for="item in categories"
                    show-toolbar
                    :columns="item.name"
                    @cancel="showPicker = false"
                    @confirm="onConfirm"
                    ：key="item.id"
                />
            </van-popup>
<!-- {{categories}} -->
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
    computed: {
    ...mapState('category',['categories']),
    ...mapState("user",["info"])
    },
    data() {
        return{
            form:{
                categoryId:'',
             },
            showPicker: false,
        }
    },

    created() {
        this.findAllCategories()
    },
    methods: {
        ...mapActions('category',['findAllCategories']),
        ...mapActions('article',['SaveOrUpdateArticle']),
        // 回到个人页面
        onConfirm(value) {
            this.form.categoryId = value;
            this.showPicker = false;
        },
        backListHandler(){
            let form = {
                username:this.form.username,
                password:this.form.password,
                nickname:this.form.nickname,
                email:this.form.email,
                userface:this.form.userface,
                userId:this.info.id,
                categoryId:this.form.categoryId,
                content:this.form.content,
            }
            console.log("用户表单",form)
            this.$router.push({path:'/manager/user'})
            // this.SaveOrUpdateArticle(form)
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
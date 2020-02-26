<template>
    <!-- 顶部导航栏 -->
    <div class="form">
        {{form}}
        <van-cell-group>
            <van-field
            v-model="form.title"
            clearable
            label="标题"
            icon="question-o"
            />
            <van-field
            v-model="form.liststyle"
            clearable
            label="列表样式"
            icon="question-o"
            />
                <van-field
            v-model="form.publishtime"
            clearable
            label="发布时间"
            icon="question-o"
            />
                <van-field
            v-model="form.music"
            clearable
            label="音乐地址"
            icon="question-o"
            />
            <van-field
            v-model="form.video"
            clearable
            label="视频地址"
            icon="question-o"
            />
        </van-cell-group>           
        <!-- 编辑信息 -->
        <van-button 
            @click="backListHandler()" 
            size="large" 
            type="warning">发布</van-button>
        <!-- /编辑信息 -->
    </div>
    <!-- /顶部导航栏 -->
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
    data() {
        return{
            form:{
                type:'customer',
            },
        }
    },
    computed: {
        ...mapState('article',['SaveOrUpdateArticle'])
    },
    created() {
        // 利用this.$this.query获取参数
        this.username = this.$route.query.username,
        this.password = this.$route.query.password
        this.nickname = this.$route.query.nickname
        this.email = this.$route.query.email
        this.userface = this.$route.query.userface
        this.regTime = this.$route.query.regTime
    },
    methods: {
        ...mapActions('user',['findAllUsers','SaveOrUpdateUser']),
        // 回退
        backHandler(){
            this.$router.back();
        },
        // 回到个人页面
        backListHandler(){
            let form = {
                id:this.$route.query.id,
                username:this.username,
                password:this.password,
                nickname:this.nickname,
                email:this.email,
                userface:this.userface,
                regTime:this.regTime
            }
            this.$router.push({path:'/manager/user'})
            
            this.SaveOrUpdateUser(form)
        }
       
    }
}
</script>

<style>
.van-col .one{
    border-bottom: 1px solid #ccc;
    padding:1em
}
</style>
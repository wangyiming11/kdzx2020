<template>
    <div>
        <!-- 顶部导航栏 -->
        <briup-fullpagelayout title="编辑个人信息" @back="backHandler">
            <div class="user_edit" >
                <div class="edit">
                    {{$route.query}}
                    <van-cell-group>
                        <van-field v-model="username" />
                        <van-field v-model="password" />
                        <van-field v-model="nickname" />
                        <van-field v-model="email" />
                        <van-field v-model="userface" />
                        <van-field v-model="regTime" />
                    </van-cell-group>
                </div>
                <!-- 编辑信息 -->
                <van-button 
                    @click="backListHandler()" 
                    size="large" 
                    type="warning">确定</van-button>
                <!-- /编辑信息 -->
            </div>
        </briup-fullpagelayout>
        <!-- /顶部导航栏 -->
    </div>
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
    data() {
        return{
            username:'',
            password:'',
            nickname:'',
            email:'',
            userface:'',
            regTime:'',
        }
    },
    computed: {
        ...mapState('user',['users'])
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
<template>
    <div class="useredit">
        <!-- 顶部导航栏 -->
        <!-- {{users}} -->
        <div class="users" :data="users">
            <van-cell-group>
                <van-field
                v-model="users.username"
                clearable
                label="用户名"
                icon="question-o"
                />
                <van-field
                v-model="users.password"
                type="password"
                label="密码"
                />
                 <van-field
                v-model="users.nickname"
                clearable
                label="昵称"
                icon="question-o"
                />
                 <van-field
                v-model="users.email"
                clearable
                label="邮箱"
                icon="question-o"
                />
                <div style="text-align:top">
                头像：
                <van-image
                    round
                    width="4rem"
                    height="4rem"
                    :src="users.userface"
                    />
                </div>
            </van-cell-group>           
            <van-button 
                    @click="backListHandler()" 
                    size="large" 
                    type="warning">确定修改</van-button>
        </div>
        <!-- /顶部导航栏 -->
    </div>
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
    data() {
        return{
            user:{
                type:'customer',
            },
        }
    },
    computed: {
        ...mapState('useredit',['users']),
        ...mapState("user",["info"])
    },
    created() {
        this.findAllUsers({});
        // 利用this.$this.query获取参数
        this.username = this.$route.query.username,
        this.password = this.$route.query.password
        this.nickname = this.$route.query.nickname
        this.email = this.$route.query.email
        this.userface = this.$route.query.userface
    },
    methods: {
        ...mapActions('useredit',['findAllUsers','SaveOrUpdateUser']),

        // 回到个人页面
        backListHandler(){
            let users = {
                id:this.users.id,
                username:this.users.username,
                password:this.users.password,
                nickname:this.users.nickname,
                email:this.users.email,
                userface:this.users.userface,
            }
            this.$router.push({path:'/manager/user'})
            
            this.SaveOrUpdateUser(users)
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
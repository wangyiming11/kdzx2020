<template>
    <div class="useredit">
        <van-nav-bar
        title="修改信息"
        />
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
                    type="info">确定修改</van-button>
        </div>
        <!-- /顶部导航栏 -->
    </div>
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
    computed: {
        ...mapState('useredit',['users']),
        ...mapState("user",["info"])
    },
    created() {
        this.findAllUsers()
    },
    methods: {
        ...mapActions('useredit',['findAllUsers','UpdateUser']),

        // 回到个人页面
        backListHandler(){
            let form = {
                id:this.users.id,
                username:this.users.username,
                password:this.users.password,
                nickname:this.users.nickname,
                email:this.users.email,
                userface:this.users.userface,
            }
            console.log("用户表单",form)
            this.UpdateUser(form)
            this.$router.push({path:'/login'})
        }
       
    }
}
</script>

<style>
.van-col .one{
    border-bottom: 1px solid #efefef;
    padding:1em
}
</style>
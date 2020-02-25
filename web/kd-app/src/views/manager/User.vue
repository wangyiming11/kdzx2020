<template>
  <div class="user">
    <!-- 标题 -->
    <div class="title">
      <van-nav-bar title="我的" />
    </div>
    <!-- /标题 -->
    <!-- 头像信息 -->
    <div class="header">
      <div class="photo">
        <van-uploader :before-read="beforeRead"  >
          <img src="../../assets/tx.jpeg" alt=""/>
        </van-uploader>
      </div>
      <div class="name">您好，{{info.name}}</div>
    </div>
    <!-- /头像信息 -->

    <!-- 个人信息 -->
    <van-cell icon="records" title="个人信息" is-link to="useredit" />
    <!-- /个人信息 -->

    <!-- 联系我们 -->
    <van-cell icon="phone-o" title="联系我们" @click="show = true" />
    <van-overlay :show="show" @click="show = false"  >
      <div class="wrapper" @click.stop>
        <div class="block">
          <van-cell title="联系我们" size="large" >
          <van-icon
            @click="closeModal()"
            slot="right-icon"
            name="cross"
            style="line-height: inherit;" />
          </van-cell>
          <van-cell title="0471-1234-888" />
        </div>
      </div>
    </van-overlay>
    <!-- /联系我们 -->

    <!-- 退出登录 -->
    <div class="btn" @click="logoutHandler">
      退出
    </div>
    <!-- /退出登录 -->
  </div>
</template>
<script>

import {mapState, mapActions} from 'vuex'
import Vue from 'vue';
import { Overlay } from 'vant';
Vue.use(Overlay);

export default {
  data() {
    return {
      show: false
    }
  },
  methods:{
    ...mapActions('user',['logout']),
    // 返回布尔值
    beforeRead(file) {
      if (file.type !== 'image/jpeg') {
        Toast('请上传 jpg 格式图片');
        return false;
      }
      return true;
    },
    asyncBeforeRead(file) {
      return new Promise((resolve, reject) => {
        if (file.type !== 'image/jpeg') {
          Toast('请上传 jpg 格式图片');
          reject();
        } else {
          resolve();
        }
      });
    },
    // 关闭联系我们模态框
    closeModal(){
      this.show = false
    },
    logoutHandler(){
      this.logout()
      .then(()=>{
        this.$router.push({path:'/login'})
      })
    }
  },
  computed:{
    ...mapState("user",["info"])
  }
}
</script>

<style scoped>
.wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
.block {
  width: 240px;
  height: 120px;
  background-color: #fff;
}
.header {
  padding-top: 25px;
  text-align: center;
  margin-bottom:2.5em;
  /* background: #1659a0; */
}
.header .photo {
  margin: 0 auto;
  width: 10em;
  height: 10em;
  border-radius: 50%;
  box-sizing: border-box;
  border:1px solid #ccc;
  overflow:hidden;
  padding: .5em;
}
.header .name {
  margin: 0 auto;
  width:200px;
  margin-top: 1.5em;
  line-height: 3em;
  font-size: 14px;
  border:1px solid #ccc;
  border-radius: 10px;
}
.header .photo img {
 width: 100%;
 border-radius: 50%;
}
.btn {
  background-color: #ededed;
  width: 90%;
  margin: 4em auto;
  line-height: 3em;
  text-align: center;
  border: 1px solid #ededed;
  border-radius: 1.5em;
  font-size: 14px;
}

</style>
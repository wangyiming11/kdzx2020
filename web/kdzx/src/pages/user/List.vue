<template>
	<div class="user">
		<div class="user-top">
			<el-button type="success" size='small' @click='adduser()'>新增</el-button>
		</div>
		<div class="content">
			<el-row :gutter="12">
			   <el-col :span="6" v-for='item in users'>
			    <el-card shadow="hover">
			      	<div class="image">
			      		<img :src="item.userface">
			      	</div>
			      	<div class="info">
			      		<div>
			      			<span>用户名:</span>
			      			<span>{{item.username}}</span>
			      		</div>
			      		<div>
			      			<span>真实姓名:</span>
			      			<span>{{item.nickname}}</span>
			      		</div>
			      		<div>
			      			<span>手机号:</span>
			      			<span>{{item.tel}}</span>
			      		</div>
			      		<div>
			      			<span>email:</span>
			      			<span>{{item.email}}</span>
			      		</div>
			      		<div>
			      			<span>状态:</span>
			      			<span>
			      				<el-switch
								  v-model="item.enabled"
								  active-color="#13ce66"
								  inactive-color="#ff4949"
								  @change='changeStatus(item)'>
								</el-switch>
			      			</span>
			      		</div>
			      	</div>
			    </el-card>
			  </el-col>
			</el-row>
		</div>

		<!-- 新增用户模态框开始 -->
		<el-dialog
		  title="新增用户"
		  :visible.sync="dialogVisible"
		  width="30%"
		  >
		  <!-- 表单开始 -->
		 <el-form label-position="right" label-width="80px" :model="userForm">
		  <el-form-item label="用户名">
		    <el-input v-model="userForm.username"></el-input>
		  </el-form-item>
		  <el-form-item label="密码">
		    <el-input v-model="userForm.password"></el-input>
		  </el-form-item>
		   <el-form-item label="真实姓名">
		    <el-input v-model="userForm.nickname"></el-input>
		  </el-form-item>
		 <!--   <el-form-item label="手机号码">
		    <el-input v-model="userForm.type"></el-input>
		  </el-form-item> -->
		  <el-form-item label="email">
		    <el-input v-model="userForm.email"></el-input>
		  </el-form-item>
		</el-form>
			<!-- 表单结束 -->
		  <span slot="footer" class="dialog-footer">
		    <el-button size='small' @click="dialogVisible = false">取 消</el-button>
		    <el-button size='small' type="success" @click="savaUser">确 定</el-button>
		  </span>
		</el-dialog>
		<!-- 新增用户模态框结束 -->
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapGetters,mapMutations} from 'vuex';
	export default {
		data(){
			return {
				dialogVisible: false,
				userForm: {}
			}
		},
		 computed: {
    		...mapGetters(['users'])
  		},
  		created(){
			this.loadUsers()
  		},
  		methods:{
  			...mapActions(['loadUsers','changeUserStatus','saveUser']),
  			// 新增用户
  			adduser(){
				this.dialogVisible = true
  			},
  			// 保存用户
  			savaUser(){
  				this.dialogVisible = false
  				this.userForm.enabled = false
				this.saveUser(this.userForm).then((r)=>{
					this.loadUsers()
				})
  				
  			},
  			// 改变用户的状态
  			changeStatus(item){
  				var obj={
  					id:item.id,
  					status:!item.enabled
  				}
				this.changeUserStatus(obj)
  			}
  		}
	}
</script>
<style type="text/css">
	.user{
		padding: 0.5em;
	}
	.user-top{
		margin-bottom: 1em;
	}
	.el-card{
		margin-bottom: 1em;
	}
	.image {
		text-align: center;
	}
	.el-row{
		height: 550px;
		overflow-y: auto;
		width: 102.5%;
	}
	.image img{
		width: 100px;
		height: 100px;
		border-radius: 50%;
	}
	.info div{
		text-align: center;
		overflow: hidden;
		margin-top: 1em;
		color: #7E7F7F;
	}
	.info div>span:first-child{
		float: left;
		width: 100px;
		text-align: right;
		padding-right: 10px;
	}
	.info div>span:last-child{
		float: left;
		width: 50%;
		padding-left: 0.5em;
		text-align: left;
		position: relative!important;
	}
	.el-switch {
		/*top:-5px;*/
		position: absolute!important;
		top:-15px;
	}
</style>
<template>
	<div class="lanmu">
		<div class="lanmu_top">
			<el-button type="success" size='small' @click='toAdd'>新增</el-button>
			<el-button type="success" size='small'>批量删除</el-button>
		</div>
		<div class="lanmu_content">
		<!-- 表格开始 -->
		   <el-table :data="categories" style="width: 100%" size='small' :border='true'
			@selection-change="handleSelectionChange">
	     	<el-table-column
		      type="selection"
		      width="100" align='center'>
		    </el-table-column>
		    <el-table-column
	        prop="id"
	        label="编号"
	         align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="name"
	        label="栏目名称"
	        align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="parent.name"
	        label="父栏目"
	        align='center'>
	      </el-table-column>
	      <el-table-column prop="comment" label="描述" align='center' width="300">
	      </el-table-column>
	      <el-table-column width="150" label="操作" align='center'>
	      	<template slot-scope='{row}'>
	      		<i class="fa fa-trash"></i>
	      		<i class="fa fa-pencil"></i>
	      	</template>
	      </el-table-column>
	    </el-table>
	    <!-- 表格结束 -->
		</div>
		<!-- 新增栏目模态框开始 -->
		<el-dialog
		  title="新增栏目"
		  :visible.sync="dialogVisible"
		  width="30%"
		  >
		  <!-- 表单开始 -->
		 <el-form label-position="right" label-width="80px" :model="categoriesForm">
		  <el-form-item label="栏目名称">
		    <el-input v-model="categoriesForm.name"></el-input>
		  </el-form-item>
		 <el-form-item label="父栏目">
		    <el-select v-model="categoriesForm.parentId" placeholder="请选择父栏目">
		       <el-option :key='c.id' v-for='c in categories' :label="c.name" :value="c.id"></el-option>
		    </el-select>
		  </el-form-item>
		 <el-form-item label="描述">
		    <el-input type="textarea" v-model="categoriesForm.comment"></el-input>
		  </el-form-item>
		</el-form>
			<!-- 表单结束 -->
		  <span slot="footer" class="dialog-footer">
		    <el-button size='small' @click="dialogVisible = false">取 消</el-button>
		    <el-button size='small' type="success" @click="save">确 定</el-button>
		  </span>
		</el-dialog>
		<!-- 新增栏目模态框结束 -->
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapGetters,mapMutations} from 'vuex';
	export default {
		data(){
			return {
				multipleSelection:[],
				dialogVisible: false,
				categoriesForm:{}
			}
		},

		 computed: {
    		...mapGetters(['categories'])
  		},
		created(){
			this.loadCategories()
		},
  		methods:{
  			 ...mapActions(['loadCategories','saveCategories']),
  			 // 点击新增按钮
  			 toAdd(){
  			 	this.dialogVisible = true
  			 },
  			 // 保存栏目
			 save(){
				this.dialogVisible = false
				this.saveCategories(this.categoriesForm)
			 },
  			 // 多选框
  			 handleSelectionChange(val){
				this.multipleSelection = val;
			}
  		
  		}
	}
</script>
<style type="text/css">
	.lanmu{
		padding: 0.5em;
	}
	.lanmu_top{
		margin-bottom: 1em;
	}
</style>
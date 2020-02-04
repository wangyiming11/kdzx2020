<template>
	<div class="lanmu">
		<div class="lanmu_top">
			<el-button type="success" size='small'>新增</el-button>
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
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapGetters,mapMutations} from 'vuex';
	export default {
		data(){
			return {
				multipleSelection:[],
			}
		},

		 computed: {
    		...mapGetters(['categories'])
  		},
		created(){
			this.loadCategories()
		},
  		methods:{
  			 ...mapActions(['loadCategories']),
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
<template>
	<div class="article">
		<div class="article_top">
			<el-button type="success" size='small' @click='toAddHandler'>新增</el-button>
			<el-button type="success" size='small' @click=''>批量删除</el-button>
		</div>
		<div class="article_content">
			<!-- 表格开始 -->
			<el-table :data="article" style="width: 100%" size='small' :border='true'
			@selection-change="">
	     	<el-table-column
		      type="selection"
		      width="100" 
					align='center'>
		    </el-table-column>
		    <el-table-column
	        prop="id"
	        label="编号"
	        width="100"
					align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="title"
	        label="文章标题"
	        width="300"
					align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="category.name"
	        label="所属栏目"
	        width="150"
					align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="publishtime"
	        label="发布时间"
					width="150"
					align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="readtimes"
	        label="阅读次数"
	        width="150"
					align='center'>
	      </el-table-column>
	      <el-table-column
	        prop="liststyle"
	        label="列表样式"
	        width="150" 
					align='center'>
	      </el-table-column>
	     
	      <el-table-column label="操作" align='center'>
	      	<template slot-scope='{row}'>
	      		<i class="fa fa-trash" @click='deleteById(row.id)'></i>
	      		<i class="fa fa-pencil" @click='toUpdateArticle(row)'></i>
	      	</template>
	      </el-table-column>
	    </el-table>
	   	<!-- 表格结束 -->
			<!-- 模态框开始 -->
			<el-dialog
				:title=title
				:visible.sync="dialogVisible"
				width="30%"
				>
				<!-- 表单开始 -->
			<el-form label-position="right" label-width="80px" :model="articleForm">
				<el-form-item label="文章名称">
					<el-input v-model="articleForm.name"></el-input>
				</el-form-item>
			<el-form-item label="父栏目">
				<el-select v-model="articleForm.categoryId" placeholder="请选择所属栏目">
					<el-option :key='c.id' v-for='c in categories' :label="c.name" :value="c.id"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="正文">
				<el-input type="textarea" v-model="articleForm.content"></el-input>
			</el-form-item>
			</el-form>
				<!-- 表单结束 -->
				<span slot="footer" class="dialog-footer">
					<el-button size='small' @click="dialogVisible = false">取 消</el-button>
					<el-button size='small' type="success" @click="save">确 定</el-button>
				</span>
			</el-dialog>
			<!-- 模态框结束 -->
			<!-- 分页开始 -->
			<div class="page">
				<el-pagination
					layout="prev, pager, next"
					:page-size='this.pageSize'
					@current-change='handleCurrentChange()'
					:total="this.total">
				</el-pagination>
			</div>
			<!-- 分页结束 -->
		</div>
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapState,mapMutations} from 'vuex';
	export default {
		data(){
			return {
				multipleSelection:[],
				dialogVisible: false,
				articleForm:{
					liststyle:'style-one'
				},
				title:''
			}
		},
			created() {
				let payload = {
					page:this.page,
					pageSize: this.pageSize,
					categoryId: this.categoryId
				}
				this.loadArticle(payload)
			},
		  computed: {
    		...mapState('Article',['article','page','pageSize','total','categoryId'])
			},
			methods: {
				...mapActions('Article',['loadArticle']),
				// 1.分页page处理
				handleCurrentChange (page) {
					this.page = page - 1
				},
				// 2.打开添加模态框
				toAddHandler() {
					this.dialogVisible=true;
					this.title='添加文章';
					this.articleForm={
						liststyle:'style-one'
					}
				}
			}
	}
</script>
<style type="text/css">
	.article{
		padding: 0.5em;
	}
	.article_top{
		margin-bottom: 1em;
	}
</style>
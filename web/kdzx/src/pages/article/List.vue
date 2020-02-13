<template>
	<div class="article">
		<div class="article_top">
			<el-button type="success" size='small' @click='toAddHandler'>新增</el-button>
			<el-button type="success" size='small' @click='batchDelect'>批量删除</el-button>
			<el-select v-model="categoryId" placeholder="请选择栏目" class="select">
				<el-option
					v-for="item in categories"
					:key="item.id"
					:label="item.name"
					:value="item.id">
				</el-option>
			</el-select>
			<el-button @click='resetData'>重置</el-button>
		</div>
		<div class="article_content">
			<!-- 表格开始 -->
			<el-table :data="article" style="width: 100%" size='small' :border='true'
			@selection-change="selectionChangeHandler">
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
	      		<i class="fa fa-trash" @click='deleteHandler(row.id)'></i>&emsp;
	      		<i class="fa fa-pencil" @click='toEditHandler(row)'></i>
	      	</template>
	      </el-table-column>
	    </el-table>
	   	<!-- 表格结束 -->
			<!-- 模态框开始 -->
			<el-dialog
				:title=title
				:visible.sync="dialogVisible"
				width="85%"
				>
				<!-- {{articleForm}} -->
				<!-- 表单开始 -->
			<el-form label-position="right" label-width="80px" :model="articleForm">
				<el-form-item label="文章标题">
					<el-input v-model="articleForm.title"></el-input>
				</el-form-item>
			<el-form-item label="所属栏目">
				<el-select v-model="articleForm.categoryId" placeholder="请选择所属栏目">
					<el-option :key='c.id' v-for='c in categories' :label="c.name" :value="c.id"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="列表样式" >
				<ul class="list_style">
					<li class="style_one" :class="{current:articleForm.liststyle=='style-one'}" @click="articleForm.liststyle = 'style-one'">
						<img src="@/assets/form_images/1.jpg" alt="图片丢了">
					</li>
					<li class="style_two" :class="{current:articleForm.liststyle=='style-two'}"  @click="articleForm.liststyle = 'style-two'">
						<img src="@/assets/form_images/2.jpg" alt="图片丢了">
					</li>
				</ul>
			</el-form-item>
			<el-form-item label="正文">
				<!-- <el-input type="textarea" v-model="articleForm.content"></el-input> -->
				<!-- 富文本编辑器 -->
		    <mavon-editor ref="articleContent" v-model="articleForm.content"/>
			</el-form-item>
			</el-form>
				<!-- 表单结束 -->
				<span slot="footer" class="dialog-footer">
					<el-button size='small' @click="dialogVisible = false">取 消</el-button>
					<el-button size='small' type="success" @click="toSaveHandler">确 定</el-button>
				</span>
			</el-dialog>
			<!-- 模态框结束 -->
			<!-- 分页开始 -->
			<div class="page">
				<el-pagination
					layout="prev, pager, next"
					:page-size='this.pageSize'
					@current-change='handleCurrentChange'
					:total="this.total">
				</el-pagination>
			</div>
			<!-- 分页结束 -->
		</div>
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapState,mapMutations,mapGetters} from 'vuex';
	export default {
		data(){
			return {
				page: 0,
				pageSize: 5,
				categoryId: null,
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
				...mapState('Article',['article','total']),
				...mapGetters('Lanmu',['categories'])
			},
			methods: {
				...mapActions('Article',['loadArticle','saveOrUpDateArticle','deleteArticleById','batchDelectArticle']),
				// 1.分页page处理
				handleCurrentChange (page) {
					this.page = page -1
					let payload = {
						page:this.page,
						pageSize: this.pageSize,
						categoryId: this.categoryId
					}
					this.loadArticle(payload)
					console.log('页码'+page, this.page)
				},
				// 2.打开添加模态框
				toAddHandler() {
					this.dialogVisible=true
					this.title='添加文章'
					this.articleForm={
						liststyle:'style-one'
					}
				},
				// 3.打开修改模态框
				toEditHandler(row) {
					// let article = row
					// article.categoryId = article.category.id;
					// //1. 删除category,添加categoryId
					// delete article.category;

					// //删除空字段
					// for(let key in article){
					// 	let val=article[key]
					// 	if(!val){
					// 		delete article[key];
					// 	}
					// }
					let article = {
						id:row.id,
						title:row.title,
						categoryId:row.category.id,
						liststyle:row.liststyle,
						publishtime:row.publishtime,
						readtimes:row.readtimes,
						status:row.status,
						thumbup:row.thumbup,
						thumbdown:row.thumbdown,
						content:row.content
					}
					this.title='修改文章'
					this.articleForm = article
					this.dialogVisible=true
				},
				// 4.提交表单
				toSaveHandler() {
					console.log('表单数据' + this.articleForm)
					this.dialogVisible=false
					this.saveOrUpDateArticle(this.articleForm)
					.then((response) => {
						let payload = {
							page:this.page,
							pageSize: this.pageSize,
							categoryId: this.categoryId
						}
						this.loadArticle(payload)
						this.$message({type:"success",message:'操作成功'});
					})
				},
				// 5.通过ID删除
				deleteHandler(id) {
					this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
		          confirmButtonText: '确定',
		          cancelButtonText: '取消',
		          type: 'warning'
		        }).then(()=>{
		        		this.deleteArticleById(id)
							.then(()=>{
								this.$notify.success({
						          title: '成功',
						          message: '删除成功！'
										});
										let payload = {
											page:this.page,
											pageSize: this.pageSize,
											categoryId: this.categoryId
										}
						        this.loadArticle(payload)
							})
							.catch(()=>{
								this.$notify.error({
						          title: '错误',
						          message: '删除失败！'
						        });
							});
		        })
				},
				// 6.批量删除
				batchDelect() {
					this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
		          confirmButtonText: '确定',
		          cancelButtonText: '取消',
		          type: 'warning'
		        }).then(() => {
							let ids = this.multipleSelection.map((item) => {
								return item.id
							})
							this.batchDelectArticle({ids})
							.then(()=>{
								this.$notify.success({
											title: '成功',
											message: '删除成功！'
										});
										let payload = {
											page:this.page,
											pageSize: this.pageSize,
											categoryId: this.categoryId
										}
						        this.loadArticle(payload)
							})
							.catch(()=>{
								this.$notify.error({
											title: '错误',
											message: '删除失败！'
										});
							})
						})
						.catch(()=>{
		        	this.$message({
		            type: 'info',
		            message: '已取消删除'
		          });   
		        })
				},
				// 7.多选框集合
				selectionChangeHandler(val) {
					this.multipleSelection = val
				},
				// 8.重置按钮，刷新数据
				resetData() {
					this.categoryId = null
					let payload = {
						page: 0,
						pageSize: this.pageSize,
					}
					this.loadArticle(payload)
				}
			},
			// 监听categoryId的变化，做数据重载
			watch: {
				categoryId:function(now,old) {
					let payload = {
						page: 0,
						pageSize: this.pageSize,
						categoryId: this.categoryId
					}
					this.loadArticle(payload)
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
	.list_style >li {
		list-style: none;
		border: 1px solid #ededed;
		border-radius: 3px;
		padding: .5em;
	}
	.list_style >li.current {
		border-color: #409eff;
	}
	.list_style >li.style_one {
		float: left;
		margin-left: -40px;
	}
	.list_style >li.style_two {
		margin-left: 220px;
		width: 220px;
	}
	.select {
		margin-left: 840px;
	}
</style>
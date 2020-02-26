<template>
    <div class="article">
       
    </div>
</template>

<script>
import {mapState,mapActions,mapGetters} from 'vuex'
export default {
    data() {
        return{
            activeKey: 0,
            categoryId:''
        }
    },
    computed: {
        ...mapState('article',['articles']),
        ...mapState('category',['categories']),
    },
    created() {
        this.QueryCategories({page:0,pageSize:100});
        // 查询所有文章信息
        this.QueryArticles({page:0,pageSize:100});
        // this.finArticleById(this.$route.query.id)
        this.categoryId = this.$route.query.id;
        this.activeKey = this.$route.query.activeKey
    },
    methods: {
        ...mapActions('category',['findAllCategories']),
        ...mapActions('article',['QueryArticles']),
        // 回退
        backHandler(){
            this.$router.push({path:'/manager/home'});
        }
    }
}
</script>

<style>
.domn{
    position: fixed;
    bottom: 0;
    line-height: 4em;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.3);
    color: #ffffff;
    text-align: center;
}
</style>
<template>
	<div class="user">
		用户管理,{{userid}}
	</div>
</template>
<script type="text/javascript">
import {mapActions,mapGetters,mapMutations} from 'vuex';
	export default {
		data(){
			return {

			}
		},
		 computed: {
    		...mapGetters(['userid'])
  		},
	}
</script>
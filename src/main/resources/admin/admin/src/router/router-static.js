import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import yuangong from '@/views/modules/yuangong/list'
	import xiangmujindu from '@/views/modules/xiangmujindu/list'
	import caigou from '@/views/modules/caigou/list'
	import ruku from '@/views/modules/ruku/list'
	import cailiaokucun from '@/views/modules/cailiaokucun/list'
	import kaoqinxinxi from '@/views/modules/kaoqinxinxi/list'
	import chuku from '@/views/modules/chuku/list'
	import xiangmuxinxi from '@/views/modules/xiangmuxinxi/list'
	import yuangongjixiao from '@/views/modules/yuangongjixiao/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
	,{
		path: '/yuangong',
		name: '员工',
		component: yuangong
	}
	,{
		path: '/xiangmujindu',
		name: '项目进度',
		component: xiangmujindu
	}
	,{
		path: '/caigou',
		name: '采购',
		component: caigou
	}
	,{
		path: '/ruku',
		name: '入库',
		component: ruku
	}
	,{
		path: '/cailiaokucun',
		name: '材料库存',
		component: cailiaokucun
	}
	,{
		path: '/kaoqinxinxi',
		name: '考勤信息',
		component: kaoqinxinxi
	}
	,{
		path: '/chuku',
		name: '出库',
		component: chuku
	}
	,{
		path: '/xiangmuxinxi',
		name: '项目信息',
		component: xiangmuxinxi
	}
	,{
		path: '/yuangongjixiao',
		name: '员工绩效',
		component: yuangongjixiao
	}
	,{
		path: '/newstype',
		name: '公告信息分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;

<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="select" v-if="type!='info'" label="工号" prop="gonghao" >
					<el-select :disabled="ro.gonghao" @change="gonghaoChange" v-model="ruleForm.gonghao" placeholder="请选择工号">
						<el-option
							v-for="(item,index) in gonghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.gonghao" label="工号" prop="gonghao" >
					<el-input v-model="ruleForm.gonghao" placeholder="工号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="绩效月份" prop="jixiaoyuefen" >
					<el-select :disabled="ro.jixiaoyuefen" v-model="ruleForm.jixiaoyuefen" placeholder="请选择绩效月份" >
						<el-option
							v-for="(item,index) in jixiaoyuefenOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="绩效月份" prop="jixiaoyuefen" >
					<el-input v-model="ruleForm.jixiaoyuefen"
						placeholder="绩效月份" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="员工考勤" prop="yuangongkaoqin" >
					<el-select :disabled="ro.yuangongkaoqin" v-model="ruleForm.yuangongkaoqin" placeholder="请选择员工考勤" >
						<el-option
							v-for="(item,index) in yuangongkaoqinOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="员工考勤" prop="yuangongkaoqin" >
					<el-input v-model="ruleForm.yuangongkaoqin"
						placeholder="员工考勤" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="工作态度" prop="gongzuotaidu" >
					<el-select :disabled="ro.gongzuotaidu" v-model="ruleForm.gongzuotaidu" placeholder="请选择工作态度" >
						<el-option
							v-for="(item,index) in gongzuotaiduOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="工作态度" prop="gongzuotaidu" >
					<el-input v-model="ruleForm.gongzuotaidu"
						placeholder="工作态度" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="业务技能" prop="yewujineng" >
					<el-select :disabled="ro.yewujineng" v-model="ruleForm.yewujineng" placeholder="请选择业务技能" >
						<el-option
							v-for="(item,index) in yewujinengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="业务技能" prop="yewujineng" >
					<el-input v-model="ruleForm.yewujineng"
						placeholder="业务技能" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="工作绩效" prop="gongzuojixiao" >
					<el-select :disabled="ro.gongzuojixiao" v-model="ruleForm.gongzuojixiao" placeholder="请选择工作绩效" >
						<el-option
							v-for="(item,index) in gongzuojixiaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="工作绩效" prop="gongzuojixiao" >
					<el-input v-model="ruleForm.gongzuojixiao"
						placeholder="工作绩效" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="奖惩加减分" prop="jiangchengjiajianfen" >
					<el-select :disabled="ro.jiangchengjiajianfen" v-model="ruleForm.jiangchengjiajianfen" placeholder="请选择奖惩加减分" >
						<el-option
							v-for="(item,index) in jiangchengjiajianfenOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="奖惩加减分" prop="jiangchengjiajianfen" >
					<el-input v-model="ruleForm.jiangchengjiajianfen"
						placeholder="奖惩加减分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'" label="总得分" prop="zongdefen" >
					<el-input v-model="zongdefen" placeholder="总得分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zongdefen" label="总得分" prop="zongdefen" >
					<el-input v-model="ruleForm.zongdefen" placeholder="总得分" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="评价等级" prop="pingjiadengji" >
					<el-select :disabled="ro.pingjiadengji" v-model="ruleForm.pingjiadengji" placeholder="请选择评价等级" >
						<el-option
							v-for="(item,index) in pingjiadengjiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="评价等级" prop="pingjiadengji" >
					<el-input v-model="ruleForm.pingjiadengji"
						placeholder="评价等级" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="点评" prop="dianping" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="点评"
					v-model="ruleForm.dianping" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.dianping" label="点评" prop="dianping" >
				<span class="text">{{ruleForm.dianping}}</span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					gonghao : false,
					xingming : false,
					jixiaoyuefen : false,
					yuangongkaoqin : false,
					gongzuotaidu : false,
					yewujineng : false,
					gongzuojixiao : false,
					jiangchengjiajianfen : false,
					zongdefen : false,
					pingjiadengji : false,
					dianping : false,
				},
			
				ruleForm: {
					gonghao: '',
					xingming: '',
					jixiaoyuefen: '',
					yuangongkaoqin: '',
					gongzuotaidu: '',
					yewujineng: '',
					gongzuojixiao: '',
					jiangchengjiajianfen: '',
					zongdefen: '',
					pingjiadengji: '',
					dianping: '',
				},
		
				gonghaoOptions: [],
				jixiaoyuefenOptions: [],
				yuangongkaoqinOptions: [],
				gongzuotaiduOptions: [],
				yewujinengOptions: [],
				gongzuojixiaoOptions: [],
				jiangchengjiajianfenOptions: [],
				pingjiadengjiOptions: [],

				rules: {
					gonghao: [
					],
					xingming: [
					],
					jixiaoyuefen: [
						{ required: true, message: '绩效月份不能为空', trigger: 'blur' },
					],
					yuangongkaoqin: [
						{ required: true, message: '员工考勤不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					gongzuotaidu: [
						{ required: true, message: '工作态度不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					yewujineng: [
						{ required: true, message: '业务技能不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					gongzuojixiao: [
						{ required: true, message: '工作绩效不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					jiangchengjiajianfen: [
						{ required: true, message: '奖惩加减分不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zongdefen: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					pingjiadengji: [
						{ required: true, message: '评价等级不能为空', trigger: 'blur' },
					],
					dianping: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			zongdefen: {
				get: function () {
					return 0+parseFloat(this.ruleForm.yuangongkaoqin==""?0:this.ruleForm.yuangongkaoqin)+parseFloat(this.ruleForm.gongzuotaidu==""?0:this.ruleForm.gongzuotaidu)+parseFloat(this.ruleForm.yewujineng==""?0:this.ruleForm.yewujineng)+parseFloat(this.ruleForm.gongzuojixiao==""?0:this.ruleForm.gongzuojixiao)+parseFloat(this.ruleForm.jiangchengjiajianfen==""?0:this.ruleForm.jiangchengjiajianfen) || 0
				}
			},



		},
		components: {
		},
		created() {
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'){
					this.info(id);
				}else if(this.type=='logistics'){
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='gonghao'){
							this.ruleForm.gonghao = obj[o];
							this.ro.gonghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='jixiaoyuefen'){
							this.ruleForm.jixiaoyuefen = obj[o];
							this.ro.jixiaoyuefen = true;
							continue;
						}
						if(o=='yuangongkaoqin'){
							this.ruleForm.yuangongkaoqin = obj[o];
							this.ro.yuangongkaoqin = true;
							continue;
						}
						if(o=='gongzuotaidu'){
							this.ruleForm.gongzuotaidu = obj[o];
							this.ro.gongzuotaidu = true;
							continue;
						}
						if(o=='yewujineng'){
							this.ruleForm.yewujineng = obj[o];
							this.ro.yewujineng = true;
							continue;
						}
						if(o=='gongzuojixiao'){
							this.ruleForm.gongzuojixiao = obj[o];
							this.ro.gongzuojixiao = true;
							continue;
						}
						if(o=='jiangchengjiajianfen'){
							this.ruleForm.jiangchengjiajianfen = obj[o];
							this.ro.jiangchengjiajianfen = true;
							continue;
						}
						if(o=='zongdefen'){
							this.ruleForm.zongdefen = obj[o];
							this.ro.zongdefen = true;
							continue;
						}
						if(o=='pingjiadengji'){
							this.ruleForm.pingjiadengji = obj[o];
							this.ro.pingjiadengji = true;
							continue;
						}
						if(o=='dianping'){
							this.ruleForm.dianping = obj[o];
							this.ro.dianping = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(this.$storage.get("role")!="管理员") {
							this.ro.zongdefen = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/yuangong/gonghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.gonghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.jixiaoyuefenOptions = "一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月".split(',')
				this.yuangongkaoqinOptions = "10,15,20,25".split(',')
				this.gongzuotaiduOptions = "10,15,20,25".split(',')
				this.yewujinengOptions = "10,15,20,25".split(',')
				this.gongzuojixiaoOptions = "10,15,20,25".split(',')
				this.jiangchengjiajianfenOptions = "5,0,-5".split(',')
				this.pingjiadengjiOptions = "优秀,良好,一般,差".split(',')
			
			},
			// 下二随
			gonghaoChange () {
				this.$http({
					url: `follow/yuangong/gonghao?columnValue=`+ this.ruleForm.gonghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.xingming){
							this.ruleForm.xingming = data.data.xingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `yuangongjixiao/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.zongdefen = this.zongdefen
var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `yuangongjixiao/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.yuangongjixiaoCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.yuangongjixiaoCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		padding: 0px;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: auto;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: auto;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #157ed2;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #59b5ff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #50adfd;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #3bc1ff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #70ecff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>

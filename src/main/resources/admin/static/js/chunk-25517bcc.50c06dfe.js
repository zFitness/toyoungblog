(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25517bcc"],{"171e":function(e,t,r){},"277f":function(e,t,r){},"3ad2":function(e,t,r){"use strict";var a=r("c8dd"),l=r.n(a);l.a},8877:function(e,t,r){"use strict";var a=r("277f"),l=r.n(a);l.a},a192:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-row",{attrs:{gutter:"40"}},[r("el-col",{staticStyle:{"padding-right":"8px","margin-bottom":"30px"},attrs:{xs:{span:24},sm:{span:24},md:{span:12},lg:{span:12},xl:{span:12}}},[r("category-list")],1),r("el-col",{staticStyle:{"margin-bottom":"30px"},attrs:{xs:{span:24},sm:{span:24},md:{span:12},lg:{span:12},xl:{span:12}}},[r("category-add")],1)],1)],1)},l=[],s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"table-wrapper"},[r("el-card",{staticClass:"box-card"},[r("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[r("span",[e._v("分类列表")])]),r("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:"",fit:""}},[r("el-table-column",{attrs:{prop:"date",label:"名称",width:"150"}}),r("el-table-column",{attrs:{prop:"name",label:"别名",width:"120"}}),r("el-table-column",{attrs:{prop:"province",label:"描述"}}),r("el-table-column",{attrs:{prop:"city",label:"文章数",width:"120"}}),r("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"text",size:"small"}},[e._v("编辑")]),r("el-divider",{attrs:{direction:"vertical"}}),r("el-dropdown",{attrs:{trigger:"click"}},[r("span",{staticClass:"el-dropdown-link"},[e._v(" 更多 ")]),r("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[r("el-dropdown-item",[e._v("添加到菜单")]),r("el-dropdown-item",[e._v("删除")])],1)],1)]}}])})],1)],1)],1)},n=[],o={methods:{handleClick:function(e){console.log(e)}},data:function(){return{tableData:[{date:"2016-05-02",name:"王小虎",province:"上海",city:"普陀区",address:"上海市普陀区金沙江路 1518 弄",zip:200333},{date:"2016-05-04",name:"王小虎",province:"上海",city:"普陀区",address:"上海市普陀区金沙江路 1517 弄",zip:200333},{date:"2016-05-01",name:"王小虎",province:"上海",city:"普陀区",address:"上海市普陀区金沙江路 1519 弄",zip:200333},{date:"2016-05-03",name:"王小虎",province:"上海",city:"普陀区",address:"上海市普陀区金沙江路 1516 弄",zip:200333}]}}},i=o,c=(r("8877"),r("2877")),d=Object(c["a"])(i,s,n,!1,null,"1456b29b",null),u=d.exports,m=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"form-wrapper"},[r("el-card",{staticClass:"box-card"},[r("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[r("span",[e._v("添加分类")])]),r("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px"}},[r("el-form-item",{attrs:{label:"名称",prop:"name"}},[r("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1),r("el-form-item",{attrs:{label:"别名",prop:"name"}},[r("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1),r("el-form-item",{attrs:{label:"上级目录",prop:"region"}},[r("el-select",{attrs:{placeholder:"请选择活动区域"},model:{value:e.ruleForm.region,callback:function(t){e.$set(e.ruleForm,"region",t)},expression:"ruleForm.region"}},[r("el-option",{attrs:{label:"区域一",value:"shanghai"}}),r("el-option",{attrs:{label:"区域二",value:"beijing"}})],1)],1),r("el-form-item",{attrs:{label:"描述",prop:"desc"}},[r("el-input",{attrs:{type:"textarea"},model:{value:e.ruleForm.desc,callback:function(t){e.$set(e.ruleForm,"desc",t)},expression:"ruleForm.desc"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("保存")]),r("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("重置")])],1)],1)],1)],1)},p=[],g={data:function(){return{ruleForm:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},rules:{name:[{required:!0,message:"请输入活动名称",trigger:"blur"},{min:3,max:5,message:"长度在 3 到 5 个字符",trigger:"blur"}],region:[{required:!0,message:"请选择活动区域",trigger:"change"}],date1:[{type:"date",required:!0,message:"请选择日期",trigger:"change"}],date2:[{type:"date",required:!0,message:"请选择时间",trigger:"change"}],type:[{type:"array",required:!0,message:"请至少选择一个活动性质",trigger:"change"}],resource:[{required:!0,message:"请选择活动资源",trigger:"change"}],desc:[{required:!0,message:"请填写活动形式",trigger:"blur"}]}}},methods:{submitForm:function(e){this.$refs[e].validate((function(e){if(!e)return console.log("error submit!!"),!1;alert("submit!")}))},resetForm:function(e){this.$refs[e].resetFields()}}},b=g,f=(r("3ad2"),Object(c["a"])(b,m,p,!1,null,"5690cebd",null)),v=f.exports,h={components:{CategoryList:u,CategoryAdd:v}},y=h,F=(r("a20d"),Object(c["a"])(y,a,l,!1,null,"4a33f4de",null));t["default"]=F.exports},a20d:function(e,t,r){"use strict";var a=r("171e"),l=r.n(a);l.a},c8dd:function(e,t,r){}}]);
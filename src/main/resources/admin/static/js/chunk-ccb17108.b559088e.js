(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ccb17108"],{"09b5":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"markdown-container"},[i("mavon-editor",{attrs:{ishljs:!0,toolbars:t.isMobile?t.toolbarsMov:void 0,subfield:!t.isMobile},model:{value:t.article.articleContent,callback:function(e){t.$set(t.article,"articleContent",e)},expression:"article.articleContent"}}),i("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"primary"},on:{click:function(e){t.dialogFormVisible=!0}}},[t._v("发布")]),i("el-dialog",{attrs:{title:"文章设置",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("el-form",{attrs:{model:t.article}},[i("el-form-item",{attrs:{label:"文章标题"}},[i("el-input",{attrs:{autocomplete:"off"},model:{value:t.article.articleTitle,callback:function(e){t.$set(t.article,"articleTitle",e)},expression:"article.articleTitle"}})],1),i("el-form-item",{attrs:{label:"状态"}},[i("el-radio-group",{model:{value:t.article.articleStatus,callback:function(e){t.$set(t.article,"articleStatus",e)},expression:"article.articleStatus"}},[i("el-radio",{attrs:{label:"publish"}},[t._v("发布")]),i("el-radio",{attrs:{label:"draft"}},[t._v("草稿")])],1)],1),i("el-form-item",{attrs:{label:"发表日期"}},[i("el-date-picker",{attrs:{type:"datetime",placeholder:"选择日期时间",align:"right","picker-options":t.pickerOptions},model:{value:t.article.articleDate,callback:function(e){t.$set(t.article,"articleDate",e)},expression:"article.articleDate"}})],1),i("el-form-item",{attrs:{label:"摘要"}},[i("el-input",{attrs:{type:"textarea",rows:4,placeholder:"为空则自动生成"},model:{value:t.article.articleSummary,callback:function(e){t.$set(t.article,"articleSummary",e)},expression:"article.articleSummary"}})],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),i("el-button",{attrs:{type:"primary"},on:{click:t.handlerCreateArticle}},[t._v("确 定")])],1)],1)],1)},l=[],r=i("2423"),o={name:"ArticleModify",components:{},data:function(){return{pickerOptions:{shortcuts:[{text:"今天",onClick:function(t){t.$emit("pick",new Date)}},{text:"昨天",onClick:function(t){var e=new Date;e.setTime(e.getTime()-864e5),t.$emit("pick",e)}},{text:"一周前",onClick:function(t){var e=new Date;e.setTime(e.getTime()-6048e5),t.$emit("pick",e)}}]},dialogFormVisible:!1,article:{articleTitle:"",articleDate:new Date,articleSummary:"",articleStatus:"draft",articleContent:""},windowWidth:document.documentElement.clientWidth,isMobile:!1,toolbarsMov:{link:!0,imagelink:!0,undo:!0,redo:!0,preview:!0}}},computed:{language:function(){}},watch:{windowWidth:function(t){console.log(t),this.isMobile=this.windowWidth<768}},mounted:function(){var t=this;this.getArticle(),window.onresize=function(){return function(){window.fullWidth=document.documentElement.clientWidth,t.windowWidth=window.fullWidth}()}},methods:{handlerCreateArticle:function(){var t=this;""==this.article.articleTitle?this.$notify({title:"提示",message:"标题不能为空"}):""==this.article.articleContent?this.$notify({title:"提示",message:"内容不能为空"}):Object(r["g"])(this.article).then((function(e){console.log(e),2e4==e.code&&t.$notify({title:"提示",message:"更新成功"})}))},getArticle:function(){var t=this;console.log(this.$route.params.id),Object(r["c"])(this.$route.params.id).then((function(e){console.log(e),t.article=e.data}))}}},n=o,c=(i("c9a5"),i("2877")),s=Object(c["a"])(n,a,l,!1,null,"50869014",null);e["default"]=s.exports},2423:function(t,e,i){"use strict";i.d(e,"d",(function(){return l})),i.d(e,"c",(function(){return r})),i.d(e,"b",(function(){return o})),i.d(e,"f",(function(){return n})),i.d(e,"e",(function(){return c})),i.d(e,"a",(function(){return s})),i.d(e,"g",(function(){return u}));var a=i("b775");function l(t){return Object(a["a"])({url:"api/admin/articles",method:"get",params:t,baseURL:"http://localhost:8080"})}function r(t){return Object(a["a"])({url:"api/admin/articles/".concat(t),method:"get",params:{},baseURL:"http://localhost:8080"})}function o(t){return Object(a["a"])({url:"api/admin/articles/delete",method:"post",params:{id:t},baseURL:"http://localhost:8080"})}function n(t,e){return Object(a["a"])({url:"api/admin/articles/setStatus",method:"post",params:{articleStatus:e,articleId:t},baseURL:"http://localhost:8080"})}function c(t){return Object(a["a"])({url:"/vue-element-admin/article/pv",method:"get",params:{pv:t}})}function s(t){return Object(a["a"])({url:"api/admin/articles/add",method:"post",data:t,baseURL:"http://localhost:8080"})}function u(t){return Object(a["a"])({url:"api/admin/articles/update",method:"post",data:t,baseURL:"http://localhost:8080"})}},4083:function(t,e,i){},c9a5:function(t,e,i){"use strict";var a=i("4083"),l=i.n(a);l.a}}]);
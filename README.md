# vue-blog
vue blog based on BootstrapVue
## reference 
- [vue](https://cn.vuejs.org/index.html)
- [BootstrapVue](https://bootstrap-vue.js.org/docs/)
- [vue cli ](https://cli.vuejs.org/)

## Project setup
### create a vue project 
use vue cli3 create a vue project 
```
vue create blog
```
### install 
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```
project preview 
![hello vue](image/hello.png)
### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


###  defult project structure
```
blog
├─ node_modules 安装的依赖包
├─ public 存放静态资源，该目录下的静态资源会被复制到输出目录中（默认输出目录为dist）,不经过 webpack。需要通过绝对路径来引用它们。
│  ├─ favicon.ico 浏览器首段图标 
│  └─ index.html index 文件
├─ src 代码
│  ├─ assets 静态资源，如图片、图标、字体等
│       └─ logo.png
│  ├─ components  公共组件
│       └─ HelloWorld.vue
│  ├─ App.vue 路由组件的顶层路由
│  ├─ main.js vue入口文件
├─ babel.config.js  babel配置
├─ package-lock.json 锁定安装时的包的版本号,保证依赖一致
├─ package.json 定义项目所需要的各种模块，以及项目的配置信息，npm install下载所需的模块
```
### 引入bootstrap vue 
```
vue add bootstrap-vue
```
会新建一个pugins目录
```
blog
├─ plugins
│       └─ bootstrap-vue.js
```

bootstrap-vue.js
```js
import Vue from 'vue'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

```

main.js中自动引入插件
```js
import './plugins/bootstrap-vue'
```
## crate a login page 
在src目录下新建一个目录"views"，用来存放所有的路由组件,再新建一个pages来存放单独（没有其他页面结构）的路由组件，
```
blog
├─ src 代码
│  ├─ views 所有路由组件
│       └─ pages
│            └─ login
│                 └─ index.vue 登录路由

```
### a vue page structure 
```js
<template>
//组件 一个tempalte只能有一个根div组件
</template>

<script>
//脚本
</script>

<style scoped>
//样式
</style>
```
### used components
# 省考务院自学考试考务管理系统（EMSystem）

## 1.简介

  本系统主要实现考试报名及考务管理系统的主要功能。系统的开发采用Java与SpringBoot编程环境,以MySQL为数据库，并以IntelliJ IDEA编辑器作为开发平台, 利用SpringBoot微服务框架为基础使用Mybatis作为ORM框架构建系统的数据接口以及实现RESTful风格的路径访问系统资源,同时采用了ThymeLeaf为模板引擎融入自适应UI框架Bootstrap美化用户界面。

  系统采用流行的MVC架构，以角色分类设计开发。
  系统功能主要分为三个部分：考生考试报名系统、考务人员管理系统、考务管理中心系统，通过各个子系统的协作运行，为所有社会考试体系的不同用户提供了定制功能及服务。
  系统模块可划分为登录注册模块 + 4个角色模块：考务院   市州人员   院校老师    考生

## 2.目录结构

  前端结构：公共模块包括登录注册，报错页面，页眉页脚，在common文件夹；其他4个角色得所有功能在各自文件夹中
  后端结构：4个角色4个Controller控制器，另外Base和BaseError为全局配置，UrlController为登录注册控制器，UrlInfo为全局用户信息控制器
          Controller调用Service，然后调用Dao。
## 3.配置

环境：Windows

IDE：IDEA

语言：Java，HTML，CSS，JavaScript，SQL

框架：SpringBoot+Mybatis

数据库：MySQL

## 4.源代码运行

### 1）配置java环境

https://www.runoob.com/java/java-environment-setup.html

### 2）安装Typora软件阅读MarkDown文件--可不做本步骤

安装教程：https://jingyan.baidu.com/article/8ebacdf07c71f849f65cd5e5.html

### 3）MySQL操作

a.安装MySQL（window上安装，MySQL密码设置为123456，默认用户为root）：https://www.runoob.com/mysql/mysql-install.html

b.使用MySQL的workbench工具新建数据库erems，并将doc下的emsystem.sql脚本导入数据库：

在Mysql得workbench左边数据库表列表得下方有2个菜单，Administration   Schemas
选择Administration这个，点击 Data Import 
有2个选项，选择下面得  import from self-contained file
然后点击导入即可，本项目得sql文件包含创建数据库得内容


### 4）安装IDEA导入项目

安装教程：https://jingyan.baidu.com/article/afd8f4debd60f434e286e91f.html

a.打开代码文件的所在目录导入

b.点击运行项目：打开com.demo目录下的DemoApplication右键运行main即可，Springboot内置了tomcat

c.使用浏览器访问：`localhost:8088`，点击主页面的登录按钮，角色默认的用户名密码均为：admin，其余角色登录信息参见用户信息表。

d.你需要注意：
  先测试下数据库能不能访问，在application.yml文件中修改数据库地址
  还可以修改里面得绝对路径
  
  本系统4个角色得功能互相衔接，形成逻辑闭环，如：
  考务院发布得考试才能被报名
  学生报名应用型时必须在院校管理得白名单里面
  院校集体给未报名得考生报名
  所有报名信息皆需要市州人员审核后才能报考
  报考后缴费
  院校老师上报考场时本校必须是考点
  市州上报违纪情况需要考务院审核处理
  
  所有逻辑都处理了，读者如果你点击某个按钮显示找不到页面，可能是卡了，再试一次就好了，或者你提交得信息需要前置条件，我建议你去读一下Dao层的数据库语句，会对你运行本系统有帮助

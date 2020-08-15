# Blog
在线演示(小站勿压，谢谢):

 http://www.spirit-guy.com

基于Boostrap，springboot，mybatis的博客

图片存储采用七牛云

### 部署

1.修改配置文件的数据库连接，以及七牛云的配置文件，需要去七牛云官网注册，新建存储空间

2.运行SQL文件，创建数据库以及表

3.执行 命令 mvn clean compile package -Dmaven.test.skip=true

4.以jar包方式运行

5.后台管理用户名admin，密码123456
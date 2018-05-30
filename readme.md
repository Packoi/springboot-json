**项目说明：**

	springboot接口项目，用于提供接口供cms触发写数据到任务池和提供前端调用接口

**相关技术如下：**

	- 框架：springboot
	- 数据库：mongodb
	- 关系型数据库：sqlserver
	- 缓存：redis集群
	- 容器：undertow

**代码结构说明：**

	- com.packoi.json	主函数
	- com.packoi.json.config	配置（包括多数据库配置和redis配置等）
	- com.packoi.json.domain	实体类
	- com.packoi.json.dao.*	多数据源分库dao
	- com.packoi.json.aop.*	切面
	- com.packoi.json.mapper.*	mybatis配置文件
	- com.packoi.json.repository.*	分库相关的Repository
	- com.packoi.json.service.*	逻辑处理类
	- com.packoi.json.controller.*	控制器
	- com.packoi.json.utils.*	工具类
	- com.packoi.json.interceptor.*	拦截器

dev1分支修改

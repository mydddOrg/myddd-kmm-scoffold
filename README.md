# myddd-kmm-scoffold

## 是什么

myddd-kmm-scoffold是基于kotlin multiplatform mobile的移动端解决方案。

KMM是一个业务逻辑跨平台移动端解决方案，有自身独特的优势与缺点。

访问[KMM官网](https://kotlinlang.org/lp/mobile/)以了解更多

## 项目内容

这只是一个示例项目，用于演示基于KMM的一个最简单的实现。项目的内容包含：

* 从微言码道后台服务读取所有博客内容摘要，显示成列表
* 将读取到的博客内容摘要存储到数据库

## 效果示例

![](https://images.taoofcoding.tech/2022/05/myddd-kmm-scoffold.png)



## 环境准备

请注意，请使用Android Studio来运行与开发基于KMM的项目。并安装以下插件

* SQLDelight 插件
* Kotlin Multiplatform Mobile 插件

而对于iOS开发，进入iosApp目录，使用XCode打开就可以了

## 下一步计划

这是一个验证了KMM基本可行性的一个示例，包括了网络与数据库。但基于myddd的理念，下一步将会进一步验证以下方面的理念：

- [ ] 引入一个IOC框架，以支持依赖流入与反转
- [ ] 尝试使用ddd分层的模式来进行跨平台业务开发
- [ ] 引入单元测试支持，对业务模块能方便的进行业务上的单元测试
- [x] Android的UI实现仍然是旧有的XML方式，后续将迁移至使用Jetpack compose实现


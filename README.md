# blog
Springboot+dubbo+shiro+jwt+swagger2
分层开发
    公共模块：blog-core
    api接口模块：blog-api
    提供者模块：blog-provider
    消费者模块（web）：blog-consumer
shiro+jwt实现权限认证及管理
    ps:自定义的MyRealm类中直接注入dubbo接口失败。解决办法：先在ShiroConfig类中注入dubbo接口，然后传入MyRealm类中
swagger2的web界面http://{ip}:{port}/swagger-ui.html
前端为vue项目，项目GitHub地址https://github.com/peiyilin/vue-manage-system
    操作流程是vue项目build生成的整个文件夹拷贝到web项目的/resources/static下即可
    浏览器访问路径：http://{ip}:{port}/dist/index.html





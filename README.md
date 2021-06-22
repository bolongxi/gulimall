GuliMall Shopping e-commerce platform


The GuliMall project is committed to establishing a complete large-scale distributed architecture e-commerce platform, which is implemented by adopting popular technologies at this stage and is written separately from the front end and the back end.

The GuliMall project is a group of e-commerce projects, including a front-end shopping mall system and a back-end management system based on SpringCloud, SpringCloud Alibaba, and MyBatis Plus. The front-end mall system includes user login, registration, product search, product detailed information, shopping cart, order, spike activity, and other modules. The back-end management system includes seven modules: system management, merchandise system, discount marketing, inventory system, order system, user system, and content management.

gulimall
├── gulimall-common 
├── renren-generator 
├── gulimall-auth-server 
├── gulimall-cart 
├── gulimall-coupon 
├── gulimall-gateway 
├── gulimall-order 
├── gulimall-product 
├── gulimall-search 
├── gulimall-seckill 
├── gulimall-third-party 
├── gulimall-ware 
└── gulimall-member 

```



|                    |       |                                                |
| :----------------: |      | :---------------------------------------------: |
|     SpringBoot     |      |     https://spring.io/projects/spring-boot      |
|    SpringCloud     |      |     https://spring.io/projects/spring-cloud     |
| SpringCloudAlibaba |      | https://spring.io/projects/spring-cloud-alibaba |
|    MyBatis-Plus    |      |             https://mp.baomidou.com             |
|  renren-generator  |      |   https://gitee.com/renrenio/renren-generator   |
|   Elasticsearch    |      |    https://github.com/elastic/elasticsearch     |
|      RabbitMQ      |      |            https://www.rabbitmq.com             |
|   Springsession    |      |    https://projects.spring.io/spring-session    |
|      Redisson      |      |      https://github.com/redisson/redisson       |
|       Docker       |      |             https://www.docker.com              |
|        OSS         |      |  https://github.com/aliyun/aliyun-oss-java-sdk  |


|           |  |                          |
| :-------: | | :-----------------------: |
|    Vue    | |     https://vuejs.org     |
|  Element  | | https://element.eleme.io  |
| thymeleaf | | https://www.thymeleaf.org |
|  node.js  | |   https://nodejs.org/en   |





[![UUvRAS.png](https://images.gitee.com/uploads/images/2020/0714/193425_4a1056c4_4914148.png)](https://imgchr.com/i/UUvRAS)



![UUvb7T.png](https://images.gitee.com/uploads/images/2020/0714/193425_9bb153d1_4914148.png)





|     工具      |   |                      官网                       |
| :-----------: |   | :---------------------------------------------: |
|     IDEA      |   |     https://www.jetbrains.com/idea/download     |
| RedisDesktop  |   |        https://redisdesktop.com/download        |
|  SwitchHosts  |   |       https://oldj.github.io/SwitchHosts        |
|    X-shell    |   | http://www.netsarang.com/download/software.html |
|    Navicat    |   |       http://www.formysql.com/xiazai.html       |
| PowerDesigner |   |             http://powerdesigner.de             |
|    Postman    |   |             https://www.postman.com             |
|    Jmeter     |   |            https://jmeter.apache.org            |




|               |        |                                                              |
| :-----------: | :----: | :----------------------------------------------------------: |
|      JDK      |  1.8   | https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html |
|     Mysql     |  5.7   |                    https://www.mysql.com                     |
|     Redis     | Redis  |                  https://redis.io/download                   |
| Elasticsearch | 7.6.2  |               https://www.elastic.co/downloads               |
|    Kibana     | 7.6.2  |               https://www.elastic.co/cn/kibana               |
|   RabbitMQ    | 3.8.5  |            http://www.rabbitmq.com/download.html             |
|     Nginx     | 1.1.6  |              http://nginx.org/en/download.html               |


192.168.56.10	gulimall.com
192.168.56.10	search.gulimall.com
192.168.56.10  item.gulimall.com
192.168.56.10  auth.gulimall.com
192.168.56.10  cart.gulimall.com
192.168.56.10  order.gulimall.com
192.168.56.10  member.gulimall.com
192.168.56.10  seckill.gulimall.com
以上端口换成自己Linux的ip地址
```

- 修改Linux中Nginx的配置文件

```
1、在nginx.conf中添加负载均衡的配置    
upstream gulimall {
        server 192.168.43.182:88;
    }
2、在gulimall.conf中添加如下配置
server {
    listen       80;
    server_name  gulimall.com  *.gulimall.com hjl.mynatapp.cc;

    #charset koi8-r;
    #access_log  /var/log/nginx/log/host.access.log  main;

    #配置静态资源的动态分离
    location /static/ {
        root   /usr/share/nginx/html;
    }

    #支付异步回调的一个配置
    location /payed/ {
        proxy_set_header Host order.gulimall.com;        #不让请求头丢失
        proxy_pass http://gulimall;
    }

    location / {
        #root   /usr/share/nginx/html;
        #index  index.html index.htm;
        proxy_set_header Host $host;        #不让请求头丢失
        proxy_pass http://gulimall;
    }










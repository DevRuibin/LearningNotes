1. 数据库应用的发展历程
   这些都是关系型数据库
      单机数据库时代
      缓存，水平切分时代：
        将多个表分到多个数据库中
      读写分离时代： 一个主要的作为写的， 其他的用来写
      垂直分割时代，一个表存到多个表，甚至多个时代，这就是集群时代。
   后面发展到了非关系型数据库(NoSql)，：彻底改变存储机制，采用聚合数据结构存储数据
    redis, mongoDB, HBase,....
2. redis remote dicctionary server
    使用C编写，基于内存运行并支持持久化
    追求极致的速度，但是不适合大量数据的存储，严格来讲，可以称之为缓存数据库
    
3. install redis
    downlaod redis*.tar.gz, 
    解压到/opt
    执行make, 如果没有make命令，先安装，然后执行make distclean ,删除上次编译失败的版本
    执行make
    可以执行install， 将src下许多命令copy到/usr/local/bin下
   
4. 启动redis，
    1. redis-server 前台启动
    2. redis-server & 后台启动
    3. redis-server /path/redis.conf & 指定配置文件
    ps -ef|grep redis check redis 是否启动

    
5. 关闭服务
    1. kill 
        ps -ef |grep redis
        kill -9 $pid
    2. redis-cli shutdown
    
6. 启动数据库
    1. 默认不需要密码， 只需要指定ip和port
    2. redis -h host -p port
    
    
7. 退出命令客户端
    1. exit
    
    
8. redis-benchmark 看redis的性能能否满足
9. ping 在连接上后使用，判断是否正常运行，正常的话返回pong,连接后一段时间，用来检查是否还在正常执行。
10. 统计redis的统计信息：
    info: 查看使用了多少CPU等
    info [信息段]： 查看某一段： －－》 info Replication
    
    
11. redis实例
    作用类似于mysql数据库实例，但是redis不能由程序员创建数据库实例，只能由redis服务创建，默认使用的是16个服务，且名字是0～15， 不能改名， 可以在配置文件修改。
    默认连接0号数据库实例
    切换数据库实例 select <index>: select 1
    dbsize: 查看有多少键值对
    查询所有的key: keys *
    清空数据库实例： flush db;
    清空所有数据库实例： flushall
    查看所有的配置信息：config get *
    查看某一个信息： config get parameter
    
12. redis支持多种数据结构：5种
    1. key-value
    2. list
    3. hashset
    同类型数据结构：
        字符串
        list列表
        set 是没有顺序的集合，而且不能重复
        pojo: 学生对象：张三（年龄：10， 姓名：张瑞彬）
        zset: 有序的value. city: 1000 beijing, 1500 shanghai, 1299 chongqing 1000 tianjin
        这些都是不能持久化的，
        
13. 命令
    1. key:
        keys pattern: 查找所有符合通配符好的key
            keys *: * 
        
    
    
    

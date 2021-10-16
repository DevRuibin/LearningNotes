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
            keys *: * 匹配零个或者多个字符
            keys k*: 匹配所有k打头的key
            keys ?: ? 匹配1个字符
            keys [abx]: 匹配一个字符，而且必须是中括号中的一个
        判断某个key是否存在 exists key
            存在是1， 不存在是0
        判断多个key是否存在 exists key1, key2, key3
            返回多少个key存在
        移动指定key， 到指定的数据库： move key index
            move hell 1; 将hell移动到 1号数据库
            但是用的不多，因为一个项目一般使用一个库
        ttl 查看指定key剩余剩存时间，
            ttl key:
               -2 key 不存在
               -1 key 是永久的
               正数或者零， key的剩余时间
        设置key的最大时间 expire key xxxx 单位是s
            expire name 30 --> 给key 设置30s
   
        查看指定key的数据类型 type key
   
        修改key 重命名 rename key newkey
            rename name username
        删除key
            del key1, key2
         
14. 字符串
   
      1. 将字符串存入redis中， set key value
         set name zhangsan
         如果在set时候，key已经存在了， 那么会发生覆盖
      2. 从Redis中获取string类型数据
         get name
      3. 追加字符串, 不存在也没事，返回值是字符串的长度
         append key value
      4. 求字符串数据的长度
         strlen key
      5. 字符串数值进行加一运算 如果key不存在，那么先赋值为0， 在加一。如果存在但是是字符串，报错。
         incr age;
      6. decr key 减一运算
      7. 指定加指定的值 incrby key offset
         incrby age 10; 将年龄加10
         不存在创建，复制为零，再便宜
      8. 指定减指定的值 decrby key offset
      9. 获取字符串中的字字符串 getrange key startIndex endIndex
         getrange name 1 3 下标是从零开始，从左到右， 包括最后一个endIndex, 只是获取，但是不会改变数据库中的值
         下表也可以是负数，负数自右至左
      10. setrange key startIndex value 用value覆盖从index开始的字符串， 能覆盖几个字符，就覆盖几个字符
      11. setex 设置字符串的同时，设置字符串的最大哦生命周期 set key seconds value
         1. set phone 20 19001358352
      12. setnx: 如果存在那么就不会覆盖了， 返回0表示失败设置， 1成功
      14. mset k1 v1 k2 v2 k3 v3
      15. mget k1 k2 k3 k4 批量获取
      16. msetnx 批量设置，在存在的时候就所有不会设置了，要不都成功

15. 列表
   
      左边是表头，右边是表尾
      一个key多个value
      每一个元素都有下标，可以是负数
      1. 将一个或多个值存入列表中的表头, 如果不存在，应该首先创建该列表
         lpush list01 1 2 3: 存入后是 3 2 1
      2. 获取指定列表中的元素 lrange list startIndex endIndex
      3. 在表尾存数据 rpush list01 1 2 3
      4. lpop key 移除并返回表头元素
      5. 获取指定元素 lindex key index
      6. 获取列表长度 llen key
      7. rpop 移除表尾的最后一个元素并返回
      8. lrem 移除列表中某一些数据 lrem key value 移除所有value值
         lrem key count value  最多移除cout个value值，是从表头开始的 如何count<0, 代表从右边开始删除个value值
      
      
   
   
    
    
    

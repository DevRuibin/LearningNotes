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
                                                                  
16. set
      元素没有下标
      单key, 多value, value之间没有顺序， 并且不能重复
      1. 将一个或者多个元素添加到集合中, 重复元素会被舍弃掉, 返回成功加入的元素
         sadd key v1 v2 v3                                                         
      2. smembers 获取集合中所有元素 smembers key
      3.  判断元素在集合中是否存在 sismember set value: sismember s1 a
         返回1如果存在，否则返回0                                                        
      4. 获取指定集合的长度： scard key
      5. srem key member [memeber, member]
         删除指定的元素，不存在的会被忽略，返回成功移除的个数
      6. 随机获取指定集合一个元素 srandmember key count
         srandmember set02  2: 随机获取两个元素，而且可能会重复
         srandmember set02 -3： 随机获取三个元素，而却不可能重复
      7. 随机从指定集合中移除一个或者多个元素 spop key [count], 返回成功移除的元素                                                        
         如果count大于元素的总数，那么全部移除 
      8. smove set01 set02 a: 将set01中的a移动到set02                                                            
      9. sdiff key k1 k2 k3: key中有，其他集合中都没有的元素
      10. 求交集 sinter key1 key2 key3...     在key1, key2,key3中都有的元素                                                       
      11. 求并集 sunion key1, k2 k3, k4....                                                           
                                                                  
17. redis中有关hash数据类型
    key: field-vaue,field-value                                                              
    1. 将一个或者多个field－value存入hash table中, 返回成功添加的field-value的数目, 如果本来就存在会覆盖
       hset key field1 value1 field2 value2
       hset stu101 id 101
       hset 和 hmset功能一样                                                           
    2. hget key field: 获取指定key中指定field数据
    3. hmget key field1 f2 f3 f4: 获取指定key中多个field数据                                                            
    4. 获取key中多有field和value: hgetall key                                                              
    5. 从hash table中删除一个或者多个field
       hdel key f1 f2 f3 f4
    6. 统计指定hash表所有field个数
       hlen key                                                           
    7. 指定field在指定的一个key中是否存在
       hexists key field                                                           
    8. 获取指定hast table中所有field
       hkeys key                                                           
    9. 获取指定hash表中所有value
        hvals key. 
    10. 对数值型的值进行加法运算                                                             
        hincrby key field integer                                                          
    11. 对数值型的值进行加法浮点数运算                                                               
        hincrbyfloat key field Float                                                         
    12. hsetnx 查看field是否存在，若果存在就放弃设置，返回0， 否则设置成功                                                              
                                                                  
18. zset
    有序集合， 必须关联一个分数，没有分数不能存入，集合中虽然有顺序但是不能重复                                                              
    redis根据分数给元素进行排序 ，分数可以重复                                                             
    1. 将一个或者多个member及其score加入有序集合， zadd key score memeber score member       
       按照分数的从小到大, 如果member存在会更新score                                                           
    2. 获取指定集合中指定下标区间的元素 zrange key startIndex endIndex [withscores] 是否返回分数
    3. 看member根据分数 zrangebyscore 30 50 withscores                                                            
       zrangebyscore key min max [withscores] min 和max是闭区间                                                           
    4. 删除有序集合中一个或者多个元素 zrem key member [member member]
    5.  zcard key 查看集合的个数
    6. 查看指定元素的排名 zrank key member                                                             
    7. 统计指定分数区间的个数 zcount key min max                                                             
    8. 获取指定元素的分数 zscore key member
    9. 查看指定元素的反向排名 zreverserank key member                                                            
    10.  获取指定集合中指定下标区间的元素, 按照反方向 zreverserange key startIndex endIndex [withscores] 是否返回分数
                                                                  
19. redis的配置文件 在redis根目录下提供redis.conf, 如果不使用配置文件，那么redis会按照默认的参数运行
    1. 网络配置                                                              
       port : 默认6379                                                           
       bind: 默认可以使用redis服务所在主机任何一个ip,通常是一个真实的ip                                                           
       tcp-keepalive : tcp连接保活策略。对于无响应的客户端，会关闭连接，如果设置为0，那么就不会进行保活检测                                                           
    2. 常规配置
        loglevel 日志级别
            # debug (a lot of information, useful for development/testing)
            # verbose (many rarely useful info, but not a mess like the debug level)
            # notice (moderately verbose, what you want in production probably)
            # warning (only very important / critical messages are logged)                                                          
        logfile 指定日志文件  目录文件夹必须存在，但是文件可以自动创建                                                        
        databases 10 默认创建16个数据库                                                         
    3. 安全配置                                                              
       redis可以设置密码 没有账号但是有密码 redis-cli -a pwd
       requirepass:                                                            
       protected-mode=yes时才会启用  
                                                                  
20. redis 持久化
    1. RDB redis database是redis默认持久化方案， 在指定的时间间隔内，执行指定次数的写操作，则会将内存中的数据写入到磁盘中，缺点是最后几个可能不能持久化
      #   * After 3600 seconds (an hour) if at least 1 key changed
      #   * After 300 seconds (5 minutes) if at least 100 keys changed
      #   * After 60 seconds if at least 10000 keys changed
    2. dbfilenam
       # The filename where to dump the DB
         dbfilename dump.rdb
    3. dir redis持久化数据生成文件保存的目录     默认是redis的启动目录                                                         
    4. AOF 采用操作日志记录下来， 但是它输在了效率上                                                    
        appendonly 是否开启                                                          
        appendfilename 文件名   
         # Redis supports three different modes:
         #
         # no: don't fsync, just let the OS flush the data when it wants. Faster.
         # always: fsync after every write to the append only log. Slow, Safest.
         # everysec: fsync only one time every second. Compromise.
         #
         # The default is "everysec", as that's usually the right compromise between
         # speed and data safety. It's up to you to understand if you can relax this to
         # "no" that will let the operating system flush the output buffer when
         # it wants, for better performances (but if you can live with the idea of
         # some data loss consider the default persistence mode that's snapshotting),
         # or on the contrary, use "always" that's very slow but a bit safer than
         # everysec.
         #
         # More details please check the following article:
         # http://antirez.com/post/redis-persistence-demystified.html
         #
         # If unsure, use "everysec".

         # appendfsync always
         appendfsync everysec
         # appendfsync no
                                                                  
21. 事务
    把一组数据库指令放在一起执行，保证数据操作的原子性，要么同时成功，要么同时失败。        
    redis事务，允许把一组redis命令放在一起，把命令进行序列化，然后一起执行                                                              
    1. multi: 标记事务的开启                                                              
    2. exec 执行事务队列所有命令
    3. 如果命令在压入事物队列中报错， 那么本事务中能保证原子性 EXECABORT Transaction discarded because of previous errors.
    4. 执行有有错，那么其他命令照样可以正常执行。 
            ```bash
            127.0.0.1:6379(TX)> set k3 a
            QUEUED
            127.0.0.1:6379(TX)> incr k3
            QUEUED
            127.0.0.1:6379(TX)> set k4 v4
            QUEUED
            127.0.0.1:6379(TX)> exec
            1) OK
            2) (error) ERR value is not an integer or out of range
            3) OK
            127.0.0.1:6379> 
            ```
    5. discard: 清除所有压入队列的命令， 并且结束该事物                                                              
    6. 乐观锁 额外加一个锁字段    
       ```bash
            id balance version
            update table set balance=balance-dept, version=version+1
            where id==xxxx and version=100
         ```
      watch: 监控某一个键，当事务执行过程中，此键值对发生变化，那么放弃执行， 否则正常执行
      unwatch key: 放弃监视某一个键                                                            
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  
                                                                  

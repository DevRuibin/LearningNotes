# Python 类的特殊方法

1. \_\_repr\__ 

   \_\_str\_\_

   自我描述方法， repr 更加倾向于用在详细信息的miaosh

   str一般提供给终端用户显示内容

2. \__del__

   释放对象占用的内存。

3. `__dir__`

   用于列出对象所有属性和方法

4. `__dict__`

   查看对象内部存储的所有属性名和属性值组成的字典

5. `__getattr__`

   访问对象的属性, 而且该属性不存在的时候被调用。

   ```python
   class Rectangel:
       def __init__(self, width, height):
           self.width = width
           self.height = height
           
       def __getattr__(self, name):
           if name == 'size':
               return self.width, self.height
           else:
               raise AttributeError
   ```

6. `__getattribute__(self, name)  `

   访问属性时被调用。

7.  `  __setattr__(self, name, value)`  

   设置属性时候被调用。

   在用户设置属性的时候，可以通过该方法拦截，设置属性值的规则

8. `__delattr__(self, name)`

   删除属性的时候被调用

9. `hasattr(obj, name)`

   obj对象有没有name属性的方法或者属性

10. `getattr(obj, name)`

    obj对象name属性的值

11. `setattr(obj, name:str, value)`

    将obj对象的属性或方法设置值是value

    ```python
    class T:
        def a():
            print("hello")
            
    def b(s):
        print(s)
        
    t = T()
    setattr(t, 'a', b)
    t.a("world")
    # 输出
    # world
    ```

12. `__call__`判断方法或者属性是否能调用

    ```python
    class User:
        a = "name"
        def b(self):
            print(a)
    u = User()
    print(hasattr(u.a, '__call__'))
    print(hasattr(u.b, '__call__'))
            
    ```

    增加调用方法

    ```python
    class User:
        def __init__(self, name):
            self.name = name
        def b(self):
            print(a)
            
        def __call__(self):
            print(self.name)
    u = User('andy')
    u()
    ```

13. `__len__`

    序列的长度

14. `__contains__(self, item)`

    判断是不是有这个元素

    ```python
    b = [1, 2, 3]
    assert b.__contains__(1) is True
    a = {"apple": 12}
    assert a.__contains__("apple") is True
    ```

15. `__setitem__(self, key, value)`

    设置指定索引对应的元素。 key 必须是整数或者slice 对象

    ```python
    a = [1, 2, 3, 4, 5]
    a.__setitem__(3, 10)
    assert a == [1, 2, 3, 10, 5]
    ```

16. `__getitem__(self, key)`

    获取指定索引的值

17. `__delitem__(self, key)`

    删除指定索引的元素

18. 迭代器

    `__iter__`实现迭代器，但是自定义的迭代器，必须有一个`__next__()`方法

    实现Fibonacci sequence

    ```python
    class Fibs:
        def __init__(self, len):
            self.first = 0
            self.sec = 1
            self.__len = len
            
        def __next__(self):
            if self.__len == 0:
                raise StopIteration
                
            self.first, self.sec = self.sec, self.first + self.sec
            self.__len -= 1
            return self.first
        
        def __iter__(self):
            return self
        
    fibs = Fibs(10)
    assert list(fibs) == [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
    ```

19. 生成器

    1. 定义一个包含yield的函数
    2. 调用该函数

    里面有一个send函数可以向函数内部传值，但是第一次传值只能是None

    ```python
    def test():
        temp = 1
        while True:
            temp = yield temp
            
    t = test()
    assert next(t) == 1
    assert t.send(2) == 2
    assert next(t) == None
    
    t = test()
    assert next(t) == 1
    try:
        assert next(t) is  not None
    except AssertionError as e:
        # 因为temp已经被yield一次了
        print("temp is None")
    assert t.send(3) == 3
    ```

20. 数学方法

    1. `__abs__` 绝对值

    2. `__round__`四舍五入取整

    3. `__trunc__` 截断取整 和int 一样

       如果自定义类没有提供`__init__(self)`，但是提供了`__trunc__(self)`，那么int(obj)也可以实现。

    4. `__floor__`向下取整

    5. `__ceil__`向上取整

    6. `__neg__` 单目求反

    7. `__pos__` 单目求正

    8. `__invert__` 单目按位取反
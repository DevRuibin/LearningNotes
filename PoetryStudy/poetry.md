1. poetry init, 创建一个pyproject.toml

   ```javascript
   [tool.poetry]
   name = "p1"
   version = "0.1.0"
   description = ""
   authors = ["andy <zhangruibin021@gmail.com>"]
   
   [tool.poetry.dependencies]
   python = "^3.8"
   
   [tool.poetry.dev-dependencies]
   
   [build-system]
   requires = ["poetry-core>=1.0.0"]
   build-backend = "poetry.core.masonry.api"
   ```

2. poetry new p1, 创建一个名字是p1的项目

   ```
   .
   ├── p2
   │   └── __init__.py
   ├── pyproject.toml
   ├── README.rst
   └── tests
       ├── __init__.py
       └── test_p2.py
   
   
   ```

3. poetry install , 根据pyproject.toml 添加包，但是如果有poetry.lock ，会根据poetry.lock 安装。在新建poetry项目的时候，没有poetry.lock，但是安装一次后，就会有了。

   可以使用poetry lock ,同步pyproject的内容，就可以使用poetry install 安装第三方包了。

   poetry install --no-dev  不要安装开发环境中的包

4. 可以独立安装一个包，使用poetry add pandas. 安装信息会更新到pyproject.toml和poetry.lock

   poetry add 支持git、本地文件安装

5. 移除某个包 poetry remove pandas. 自动更新到pyproject.toml 和poetry.lock

6. poetry show 展示所有安装包 

   1. --tree 树状显示

7. poetry show pandas : 展示pandas包的详细信息包括依赖的包

8. poetry config --list 显示配置信息

9. poetry run python manage.py 在新环境中运行程序

10. poetry shell 进入新环境

11. poetry check 检查包依赖有没有错误

12. poetry search  numpy  搜索所欲numpy版本

13. poetry export -f requirements.txt --output requirements.txt 将内容导出为requirement.txt

14. 使用镜像

    在pyproject.toml中加入

    ```javascript
    [[tool.poetry.source]]
    name = "foo"
    url = "https://foo.bar/simple/"
    secondary = true
    ```

    这样就加入了某个镜像供选择，但是如果只是用这个镜像，将secondary=true 改为 default=true

15. 使用某个python版本 poetry env use /path/to/python

    1. poetry env info 查看环境的详细信息
    2. poetry env list 列出所有环境
    3. poetry env remove name 删除环境

16. 包版本指定

    | REQUIREMENT | VERSIONS ALLOWED |
    | :---------- | :--------------- |
    | ~1.2.3      | >=1.2.3 <1.3.0   |
    | ~1.2        | >=1.2.0 <1.3.0   |
    | ~1          | >=1.0.0 <2.0.0   |

    | REQUIREMENT | VERSIONS ALLOWED |
    | :---------- | :--------------- |
    | *           | >=0.0.0          |
    | 1.*         | >=1.0.0 <2.0.0   |
    | 1.2.*       | >=1.2.0 <1.3.0   |

    
1. install: `pip install pipenv`

2. 切换到工作目录`myproject`

3. 安装requests `pipenv install requests`

   1. 在工作目录下

      .
      ├── Pipfile
      └── Pipfile.lock

      Pipfile和requirements.txt 很相似

      ```javascript
      [[source]]
      url = "https://pypi.org/simple"
      verify_ssl = true
      name = "pypi"
      
      [packages]
      requests = "*"
      
      [dev-packages]
      
      [requires]
      python_version = "3.9"
      
      ```

      Pipfile.lock, 是锁定的python版本，便于以后项目发布，使用固定的包

      它不会自动更新包的版本，比如安装的requests一开始是2.26.0,后来指定的是2.25.1，那么Pipfile会更新，但是Pipenv.lock不会更新，但是如果你又安装了numpy，那么在Pipfile中也会更新的。但是使用pip安装，两个文件都不会更新。

      ```javascript
      {
          "_meta": {
              "hash": {
                  "sha256": "b8c2e1580c53e383cfe4254c1f16560b855d984fde8b2beb3bf6ee8fc2fe5a22"
              },
              "pipfile-spec": 6,
              "requires": {
                  "python_version": "3.9"
              },
              "sources": [
                  {
                      "name": "pypi",
                      "url": "https://pypi.org/simple",
                      "verify_ssl": true
                  }
              ]
          },
          "default": {
              "certifi": {
                  "hashes": [
                      "sha256:2bbf76fd432960138b3ef6dda3dde0544f27cbf8546c458e60baf371917ba9ee",
                      "sha256:50b1e4f8446b06f41be7dd6338db18e0990601dce795c2b1686458aa7e8fa7d8"
                  ],
                  "version": "==2021.5.30"
              },
              "charset-normalizer": {
                  "hashes": [
                      "sha256:0c8911edd15d19223366a194a513099a302055a962bca2cec0f54b8b63175d8b",
                      "sha256:f23667ebe1084be45f6ae0538e4a5a865206544097e4e8bbcacf42cd02a348f3"
                  ],
                  "markers": "python_version >= '3'",
                  "version": "==2.0.4"
              },
              "idna": {
                  "hashes": [
                      "sha256:14475042e284991034cb48e06f6851428fb14c4dc953acd9be9a5e95c7b6dd7a",
                      "sha256:467fbad99067910785144ce333826c71fb0e63a425657295239737f7ecd125f3"
                  ],
                  "markers": "python_version >= '3'",
                  "version": "==3.2"
              },
              "requests": {
                  "hashes": [
                      "sha256:6c1246513ecd5ecd4528a0906f910e8f0f9c6b8ec72030dc9fd154dc1a6efd24",
                      "sha256:b8aa58f8cf793ffd8782d3d8cb19e66ef36f7aba4353eec859e74678b01b07a7"
                  ],
                  "index": "pypi",
                  "version": "==2.26.0"
              },
              "urllib3": {
                  "hashes": [
                      "sha256:39fb8672126159acb139a7718dd10806104dec1e2f0f6c88aab05d17df10c8d4",
                      "sha256:f57b4c16c62fa2760b7e3d97c35b255512fb6b59a259730f36ba32ce9f8e342f"
                  ],
                  "markers": "python_version >= '2.7' and python_version not in '3.0, 3.1, 3.2, 3.3, 3.4' and python_version < '4'",
                  "version": "==1.26.6"
              }
          },
          "develop": {}
      }
      
      ```

      

   2. pytho 环境在`~/.local/share/virtualenvs/myproject-kjlcaje`

4. pip install ，可以指定安装源。只需要在Pipfile，修改

   ```javascript
   [[source]]
   url = "https://pypi.org/simple"
   verify_ssl = true
   name = "pypi"
   
   [[source]]
   url = "http://pypi.home.kennethreitz.org/simple"
   verify_ssl = false
   name = "home"
   
   [dev-packages]
   
   [packages]
   requests = {version="*", index="home"}
   maya = {version="*", index="pypi"}
   records = "*"
   ```

   records='*': 不指定版本，默认最新

5. 不想在生成环境安装，而只是在开发中安装 `pipenv install pytest --dev`

   ```javascript
   [[source]]
   url = "https://pypi.org/simple"
   verify_ssl = true
   name = "pypi"
   
   [packages]
   requests = "==2.25.1"
   numpy = "==1.21.2"
   certifi = "==2021.5.30"
   chardet = "==4.0.0"
   idna = "==2.10"
   urllib3 = "==1.26.6"
   
   [dev-packages]
   pytest = "*"
   
   [requires]
   python_version = "3.9"
   ~                                                                               
   ~                     
   ```

   

6. pipenv shell 进入 新建的环境

7. pipenv run +command `pipenv run ptrhon main.py` 不激活该环境，而使用该环境。

8. 从requerements.txt 安装 `pipenv install -r requirements.txt`

9. 生成requerements.txt  `pipenv lock -r > requirements.txt`

   1. pipenv lock -r --dev  将包含开发环境在安装的包
   2. pipenv lock -r --dev-only 只是包含开发环境中包
   3. 默认是生产环境中的包

10. 如果指定python版本 使用 `pipenv --python=/path/to/python`, 如果还想使用conda已经安装的第三方包 `pipenv --python=/path/to/python --site-packages`

11. pipenv graph:  描绘你安装的包需要安装的第三方依赖

    ```
    (py39) andy@andy:~/myproject$ pipenv graph
    numpy==1.21.2
    requests==2.25.1
      - certifi [required: >=2017.4.17, installed: 2021.5.30]
      - chardet [required: >=3.0.2,<5, installed: 4.0.0]
      - idna [required: >=2.5,<3, installed: 2.10]
      - urllib3 [required: >=1.21.1,<1.27, installed: 1.26.6]
    
    ```

12. pipenv check: 检查包依赖有没有问题等一些安全问题

13. 在生产环境中，我们使用的是稳定的环境

    1. `pipenv lock` 更新Pipfile.lock
    2. `pipenv install --ignore-pipfile ` 使用Pipfile.lock 安装第三方包

14. 如果包含一些密码，但是要提交到github上，我们可以这样使用

    1. 在项目根目录建立`.env`文件

       ```
       PASSWORD='XJFOPWCNALVV'
       ```

    2. 在python中测试

       ```python
       import os
       print(os.environ['PASSWORD'])
       ```

       


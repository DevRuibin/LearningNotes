## git 常用命令

1. git add <file> : 添加到暂存区

2. git commit -m <message> 提交修改

3. git status 查看当前工作区的状态

4. git diff <file> 查看文件的不同之处

5. git reset --hard commit_id 回退到某个版本

   1. HEAD 当前版本
   2. HEAD^ 上一个版本

6. git reflog: 详细日志

7. git restore --staged <file> 撤销添加到暂存区的内容

8. git restore <file>: 工作区的修改将被撤销

9. git rm <file> : 从所有地方删除文件， git将不再追踪file

10. 新建一个仓库

    ```git
    git init
    git add README.MD
    git commit -m 'first commit'
    git remote add origin URL
    git push -u origin master
    ```

11. 将已经存在的仓库和远程关联

    ```git
    git remote add origin URL
    git push -u origin master
    ```

12. git remote -v: 查看远程的详细信息

13. git remote rm origin: 和远程解除绑定

14. git push origin master: 更新远程仓库

15. git switch -c  || git checkout -b dev 新建dev分支

16. git branch : 查看所有分支

17. git branch dev 新建dev

18. git switch dev： 切换到dev

19. git merge dev：merge 分支， fast-forwad模式

20. git log 打印日志

    1. --pretty=oneline 一行一个记录
    2. --graph 有线的记录

21. git merge dev --no-ff -m 'merge with no-ff': 不使用fast forward 模式合并

22. git branch -D dev 强制删除dev

23. git branch -d dev 删除dev

24. git stash: 隐藏目前工作区内容，git status 将是干净的

25. git cherry-pick <commit> : 复制其他修改到本版本

26. git pull --set-upstream-to=origin/dev dev 将远程分支和本地分支关联

27. git checkout -b dev origin/dev 在本地建立一个和远程关联的分支

28. git tag 查看所有tag

29. git tag <tagname> 打标签

30. git tag <tagname> -m 'some info' <commitid> 建立有说明的标签

31. git -d <tagname> 删除标签

32. git push origin <tagname> 将标签推送到远程

33. git push origin --tags 推送所有的标签

34. git tag -d <tagname> / git push origin :refs/tags/<tagname> 删除远程标签

35. 建立git服务器

    1. sudo su
    2. adduser git
    3. 将ssh key 存放到 `/home/git/.ssh/authorized_keys`
    4. git init --bare /sample.git
    5. chown -R git:git /sample.git
    6. 禁用shell登录git用户
   
   
   
## append
   git reset –soft ： 不改变暂存区， 仅仅将Commit回退
   git reset –mixed : 不改变工作区，覆盖暂存区
   git reset –hard : 改变工作区，覆盖暂存区

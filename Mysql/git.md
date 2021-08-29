## Grant
```sql
grant all on db1.* to 'andy'@'%';
grant 'role1', 'role2' to 'andy'@'localhost', 'user2'@'%';
grant select on word.* to 'role3';
```

## create user

`CREATE USER 'test'@'localhost' IDENTIFIED BY 'newpassword'`

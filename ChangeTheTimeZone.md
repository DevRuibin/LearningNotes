# How to change or set the Time Zone in Linux

The system time zone is configured by symlinking the /etc/localtime file to a binary time zone's identifier in the /usr/share/zoneinfo directory

You can view the path the symlink points to using the ls command
`ls -l /etc/localtime`

So change the Time Zone in linux:
```
sudo rm -rf /etc/localtime
sudo ln -s /usr/share/zoneinfo/America/New_York /etc/localtime
```

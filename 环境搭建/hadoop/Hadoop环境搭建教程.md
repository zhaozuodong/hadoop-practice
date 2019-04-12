## Hadoop 集群搭建

### 1、配置ssh免密码登录
```
# cd 
# ssh-keygen -t rsa
# 一直回车
# cd /root/.ssh
# cp id_rsa.pub authorized_keys 把几台机子的公钥都放到这里面
# scp /root/.ssh/authorized_keys root@192.168.1.101:/root/.ssh/
```

将jdk、Hadoop安装包放在/opt文件下

### 2、配置jdk
```
# tar zxvf ./jdk-8u181-linux-x64.tar.gz
# mv ./jdk1.8.0_181 ./jdk1.8
# scp -r /opt/jdk1.8 root@192.168.1.101:/opt/
# vim /etc/profile 
```
```
export JAVA_HOME=/opt/jdk1.8
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
```
```
# scp /etc/profile root@192.168.1.101:/etc/
# source /etc/profile
```

### 3、配置Hosts
```
# vim /etc/hosts
```
```
192.168.1.100 Hadoop100
192.168.1.101 Hadoop101
192.168.1.102 Hadoop102
```
```
# scp /etc/hosts root@192.168.1.101:/etc/
```

### 4、安装Hadoop 
```
# cd /opt
# mkdir hadoop
# cd hadoop
# tar  -xvf   hadoop-2.8.5.tar.gz
```

### 配置参考：
https://blog.csdn.net/pucao_cug/article/details/71698903
https://www.cnblogs.com/cmi-sh-love/p/6759016.html 
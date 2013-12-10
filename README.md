#Steps to run the eMumba Assignment
> by Muhammad Iqbal <br/>

## A) Installing and extracting
Perform the following steps

1) Extract **"jboss-5.0.0.GA.zip"** to some drive.

2) Extract **“jasypt-1.9.1-dist.zip”** to some drive; 

3) Extract **“apache-ant-1.9.2-bin.zip”** to some drive; 

4) Download [MySQL 5.x] (http://dev.mysql.com/downloads/mysql/) version and install. 

5) Copy the source project code “eMumba” to some drive.

## B)	Making environment variable
Make the following env variable  i;e  variable name = variable value

    JBOSS_HOME = D:\jboss-5.0.0.GA
    ANT_HOME= C:\apache-ant-1.9.2
    STRONG_PASSWORD = eMumba
Append the bin directory of the ANT to the “Path” environment variable.

    Path= ;C:\apache-ant-1.9.2\bin

## C) Creating encrypted password using “Jasypt” for MySQL username and password

Online Help for [Jasypt] (http://www.jasypt.org/cli.html)

Open the command prompt and browse to the “Jasypt”  directory.
For example:
```COMMAND
cmd >> C:\jasypt-1.9.1\bin
```


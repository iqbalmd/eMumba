#Steps to run the eMumba Assignment
> by Muhammad Iqbal <br/>
> -- md.iqbalit@gmail.com

## A) Installing and extracting
Perform the following steps

* Download and extract [**"jboss-5.0.0.GA.zip"**] (https://github.com/iqbalmd/eMumba/releases/download/1.0/jboss-5.0.0.GA.zip) to some drive.<br>
* Download and extract [**“jasypt-1.9.1-dist.zip”**] (https://github.com/iqbalmd/eMumba/releases/download/1.0/jasypt-1.9.1-dist.zip) to some drive;<br>
* Download and extract [**“apache-ant-1.9.2-bin.zip”**] (https://github.com/iqbalmd/eMumba/releases/download/1.0/apache-ant-1.9.2-bin.zip) to some drive;<br>
* Download [MySQL 5.x] (http://dev.mysql.com/downloads/mysql/) version and install.<br>
* Copy the source project code “eMumba” to some drive.<br>

## B)	Making environment variable
* Make the following env variable  i;e  variable name = variable value <br>

        JBOSS_HOME = D:\jboss-5.0.0.GA
        ANT_HOME= C:\apache-ant-1.9.2
        STRONG_PASSWORD = eMumba

* Append the bin directory of the ANT to the “Path” environment variable.<br>
```
Path= ;C:\apache-ant-1.9.2\bin
```

## C) Creating encrypted password using “Jasypt” for MySQL username and password

* Online Help for [Jasypt] (http://www.jasypt.org/cli.html)<br>
* Open the command prompt and browse to the “Jasypt”  directory.For example:<br>
```
cmd >> C:\jasypt-1.9.1\bin
```
* Create two encrypted password for MySQL  root username and password type the following<br>
```
encrypt.bat input="This is my message to be encrypted" password=STRONG_PASSWORD
```
* **Note:** Remember value of STRONG_PASSWORD from environment variable.
* For example I want to encrypt “root” & “admin”<br>

        encrypt.bat input="root" password=”eMumba”
        encrypt.bat input="admin" password=”eMumba”

* Copy both of the encrypted value and update **database.properties** file under the following location:<br>
```
eMumba\WebContent\WEB-INF\database.properties
```
* Replace the asterisk with encrypted value respectively.

        jdbc.driverClassName=com.mysql.jdbc.Driver
        jdbc.url=jdbc:mysql://localhost:3306/test
        jdbc.username=ENC(*************)
        jdbc.password=ENC(*************)



## D) Building project with ANT

* Open cmd prompt (Run as Administrative ) <br>
* Browse to the eMamba project.<br>
* Type ant<br>
* It will build the project and put the war file in jboss 5.<br>

## E) Running the Jboss and application
Make sure that the MySQL database contain the “test” DB. If not create it.
```SQL
create database test
```
* Open cmd prompt (Run as Administrative ) <br>
* Browse to Jboss >> bin directory.<br>
* Type the “run.bat” and wait for Jboss to start.<br>
* Now open internet explorer and type the following<br>
* [http://localhost:8080/eMumba/] (http://localhost:8080/eMumba/)
* The user email and password are the following

```
EMAIL = admin@emumba.com
Password=admin
```

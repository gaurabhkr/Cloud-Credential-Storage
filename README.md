<img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExcWd4Mm1pZWkyMmZ1ZDlnd2VzbTlkZDY4azVxNjVhZTNvOGFsNzQ3bSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/E4L3XgtBm2Scz9kAfH/giphy.gif" align="center" height="400" width="1000" /> 

<h1 ><center>
Cloud Credential Storage </center>
</h1>

_Cloud Credential Storage_ is an __SpringBoot__ Application which store User Web Credentials on Cloud .It was developed during learning Spring Security. <br>
<br>


User can store the __Web Information__  _like Webpage Link, about Webpage along with username and password if user account exist_. This Application developed as per my Requirements for my own use ( _I was looking for secure storage that can be used for credential Backup_ ) .

<br>

- It use **JWT** Authentication to assign a Bearer Token on Login<br>
- Bcrypt to **encrypt** the password that get Store on Cloud Storage<br> 
- It features the services of Spring Security<br> 
- This is my first Application on Spring Security( _It may contain some errors_ )<br> 

> It is an API based Application. User had to send API requests to interact with Application


## Technology

<img src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExc29tOW5oOHU4ZWVwdTZoamUwZml6YzFqeHo3MnIzZGUzNjRqNTVrZiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/fNpoSLVgyYwzCtxO2G/giphy.gif" align="right" height="150" width="150" /> 

* _Spring Security_
* _SpringBoot_
* _Spring JPA_
* _JWT Authentication_
* _Encryption Methods like HMACSHA256 , Bcrypt_
* _PostgreSQL_
 
>_I had used local postgreSQL DB instead of Cloud DB. I will change it_

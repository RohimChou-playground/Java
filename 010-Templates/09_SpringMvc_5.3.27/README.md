## Static Resources
http://localhost:8080/spring5/ 
    -> webapp/index.html

http://localhost:8080/spring5/backend/aaa/aaa.html 
    -> <mvc:resources mapping="/aaa/**" location="/WEB-INF/static/"></mvc:resources>
    -> webapp/WEB-INF/static/aaa.html

http://localhost:8080/spring5/backend/bbb/aaa.html
    -> <mvc:resources mapping="/bbb/**" location="classpath:/static/"></mvc:resources>
    -> src/main/resources/static/aaa.html

## Through Controller
http://localhost:8080/spring5/backend/api/users 
    -> UsersController.getUsers() -> String[]

http://localhost:8080/spring5/backend/page/users 
    -> UsersPageController.getUsers() -> webapp/WEB-INF/pages/users.jsp

http://localhost:8080/spring5/backend/page/addUser 
    -> UsersPageController.addUser() -> webapp/WEB-INF/pages/addUser.jsp

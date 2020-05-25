<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
      <head>
      <title>JINSERT Operation</title>
   </head>
   <body>
      <sql:setDataSource var = "details" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://127.0.0.1:9090/coronadb"
         user = "root"  password = "root"/>
         <sql:update dataSource = "${details}" var = "result">
         insert into details(name,email,mobile,remark,s1,s2,s3,s4) values('"+Name+"','"+Email+"','"+Mobile+"','"+Remark+"','"+S1+"','"+S2+"','"+S3+"','"+S4+"',)");
      </sql:update>
 
      <sql:query dataSource = "${details}" var = "result">
         SELECT * from details;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Remark</th>
             <th>s1</th>
             <th>s2</th>
             <th>s3</th>
             <th>s4</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.name}"/></td>
               <td><c:out value = "${row.email}"/></td>
               <td><c:out value = "${row.mobile}"/></td>
               <td><c:out value = "${row.remark}"/></td>
                <td><c:out value = "${row.s1}"/></td>
                 <td><c:out value = "${row.s2}"/></td>
                  <td><c:out value = "${row.s3}"/></td>
                   <td><c:out value = "${row.s4}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>
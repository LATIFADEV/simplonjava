<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>KickIt CTB Quiz App</title>
<style>
body{
   padding:20px;
   text-align: center;
}
.button {
    position: absolute;
    top:50%;
    background-color:#8AF192 ;
}
.button1 {
    position: absolute;
    top:50%;
    background-color:#F9400A ;
}
  
#count{
  margin:20px auto;
  border-radius:50%;
  height: 100px;
  width: 100px;
  padding: 10px;
  font-size:100px;
  font-weight: bold;
  background:blue;
  color:white;
  display:flex;
  justify-content: center;
  align-items: center;
}
#co{
  margin:10px auto;
  border-radius:50%;
  height: 10px;
  width: 10px;
  padding: 10px;
  font-size:10px;
  font-weight: bold;
  background:#8AF192;
  color:white;
  display:flex;
  justify-content: center;
  align-items: center;
}
#coL{
  margin:10px auto;
  border-radius:50%;
  height: 10px;
  width: 10px;
  padding: 10px;
  font-size:10px;
  font-weight: bold;
  background:#F9400A;
  color:white;
  display:flex;
  justify-content: center;
  align-items: center;
}

img{
    height: 50px;
    width: 50px; 
}

#user-info{
    border: 1px solid gray;
    border-radius: 20px;
    padding: 5px;
}
.res{
    border-radius: 20px;
    padding: 5px 10px;
    color: white;
    font-size: medium;
    font-weight: bold;
}
.res.correct{
    background-color: lime;
}
.res.incorrect{
    background-color:  tomato;
}


</style>
</head>
<body>
    <h1>****** KickIt CTB Quiz App ******</h1>
    <hr>
    <div id="user-info">
        <img src="img/avatar.png">
        <h2><%= request.getParameter("name") %></h2>
    </div>
    <p>Number of Question in Our Database is:</p>
    <div id="count">
      <%= request.getParameter("count") %>
    </div>
     <button type="button" class="button"> 
     <div id="co">
      <%= request.getParameter("co") %>
    </div> Correct!</button>
    </div>
  
<form action="adduser.jsp" method="post">  
<table>  
<tr><td>Add New Question</td><td>
<tr><td>Question</td><td><input type="text" name="question"/></td></tr>  
<tr><td>option1:</td><td>  
<input type="text" name="option1"/></td></tr>  
<tr><td>option2</td><td><input type="email" name="option2"/></td></tr>  
<tr><td>option3</td><td><input type="email" name="option3"/></td></tr>  
<tr><td>option4</td><td><input type="email" name="option4"/></td></tr>  
 
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Add Question"/></td></tr>  
</table>  
</form>  
    
</body>

</html>
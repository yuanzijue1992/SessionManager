<html>
<body>
JSESSIONID:<%= session.getId() %>
<br>
Context:<%= session.getSessionContext().getClass().getSimpleName() %>
<br>
Manager:<%= session.getClass().getSimpleName() %>
</body>
</html>

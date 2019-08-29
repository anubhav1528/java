<body>
	<jsp:useBean id="u" class="pack.ValidateBean" scope="request">


		<jsp:setProperty name="u" property="*" />

	</jsp:useBean>
	You entered user name as
	<jsp:getProperty name="u" property="user" />
	<br> You entered user password as
	<jsp:getProperty name="u" property="pass" />
	<br>

	<br> You are a
	<%=u.validate("admin", "admin")%>
	user.
	<br>

	<b>Thank You</b>
</body>
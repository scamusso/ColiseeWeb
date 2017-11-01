<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="
controlleur.*,
modele.*
"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creation Arme</title>
	</head>
	
	<body>
		<%
			Facade contexteXML = (Facade) request.getAttribute("contexteXML");
	    %>
	    
	    <h1>Creation Arme</h1>
	    <form action="ajoutArme" method="post">
	    	<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
	    

		    <div>
		        <label for="nom">Nom :</label>
		        <input type="text" name="nom" required="" />
		    </div>
		    <div>
		        <label for="courriel">Puissance Offensive :</label>
		        <input type="number" name="offensive" min="0"/>
		    </div>
		    <div>
		        <label for="courriel">Puissance Defensive :</label>
		        <input type="number" name="defensive" min="0"/>
		    </div>
		    
		    
		    <div class="button">
		        <button type="submit">Ajouter Arme</button>
		    </div>
		</form>
	
	</body>
</html>
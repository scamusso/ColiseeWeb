<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="
controlleur.*,
modele.*
"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creation Gladiateur</title>
	</head>
	
	<body>
		<%
			Facade contexteXML = (Facade) request.getAttribute("contexteXML");
	    %>
	    
	    <h1>Creation gladiateur</h1>
	    <form action="ajoutGladiateur" method="post">
	    	<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
	    

		    <div>
		        <label for="type">Type :</label>
	        	<select name="type">
				  <option value="Retiaire" selected="selected">Retiaire</option>
				  <option value="Mirmillon">Mirmillon</option>
				</select>
		    </div>
		    <div>
		        <label for="nom">Nom :</label>
		        <input type="text" name="nom" required="" />
		    </div>
		    <div>
		        <label for="courriel">Poids (pour Mirmillon) :</label>
		        <input type="number" name="poids" min="0"/>
		    </div>
		    <div>
		        <label for="courriel">Agilité (pour Retiaire) :</label>
		        <input type="number" name="agilite" min="0"/>
		    </div>
		    
		    <div>
		        <label for="courriel">Armes :</label>
		    </div>
		    
		    <div class="button">
		        <button type="submit">Ajouter Gladiateur</button>
		    </div>
		</form>
	
	</body>
</html>
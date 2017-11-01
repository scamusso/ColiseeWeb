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
			int idArme = (int) request.getAttribute("idArme");
			Arme arme = contexteXML.getArme(idArme);
	    %>
	    
	    <h1>Modification Arme</h1>
	    <form action="modificationArme" method="post">
	    	<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
	    	<input type="hidden" name="idArme" value=<%=idArme%> />

		    <div>
		        <label for="nom">Nom :</label>
		        <input type="text" name="nom" required="" value="<%=arme.getNomArme()%>" />
		    </div>
		    <div>
		        <label for="offensive">Puissance Offensive :</label>
		        <input type="number" name="offensive" min="0" value="<%=arme.getPuissanceOffensive()%>"/>
		    </div>
		    <div>
		        <label for="defensive">Puissance Defensive :</label>
		        <input type="number" name="defensive" min="0" value="<%=arme.getPuissanceDefensive()%>"/>
		    </div>
		    
		    
		    <div class="button">
		        <button type="submit">Modifier Arme</button>
		    </div>
		</form>
	
	</body>
</html>
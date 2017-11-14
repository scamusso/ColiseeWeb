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
			int idGladiateur = (int) request.getAttribute("idGladiateur");
			int poids = 0;
			int agilite = 0;
			
			Gladiateur gladiateur = contexteXML.getGladiateur(idGladiateur);
			
			if (gladiateur.getType().equals("Retiaire"))
			{
				Retiaire retiaire = (Retiaire) gladiateur;
				agilite = retiaire.getAgilite();
				
			} else {
				Mirmillon mirmillon = (Mirmillon) gladiateur;
				poids = mirmillon.getPoids();
			}
	    %>
	    
	    <h1>Creation gladiateur</h1>
	    <form action="modificationGladiateur" method="post">
	    	<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
	  	    <input type="hidden" name="idGladiateur" value=<%=idGladiateur%> />
		    <div>
		        <label for="type">Type :</label>
	        	<select name="type">
					<% if (gladiateur.getType().equals("Retiaire")) 
					{ %>
							
						<option value="Retiaire" selected="" >Retiaire</option>
					    <option value="Mirmillon">Mirmillon</option>
					<% }  else { %>
						<option value="Retiaire" >Retiaire</option>
						<option value="Mirmillon" selected="" >Mirmillon</option>
					<%	
					}
					%> 
				</select>
		    </div>
		    <div>
		        <label for="nom">Nom :</label>
		        <input type="text" name="nom" required="" value="<%=gladiateur.getNom()%>"/>
		    </div>
		    <div>
		        <label for="poids">Poids (pour Mirmillon) :</label>
		        <input type="number" name="poids" min="0" value="<%=poids%>"/>
		    </div>
		    <div>
		        <label for="agilite">Agilité (pour Retiaire) :</label>
		        <input type="number" name="agilite" min="0" value="<%=agilite%>"/>
		    </div>
		    <div class="button">
		        <button type="submit">Modifier Gladiateur</button>
		    </div>
		</form>
		
		<h1>Liste des armes</h1>
		<table border="1" cellpadding="10" width="100%">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Puissance offensive</th>
				<th>Puissance defensive</th>
				<th>Equiper/Desequiper</th>
			</tr>
			<%
			for(Arme arme : contexteXML.listerToutesLesArmes()) { %>
				<tr>
					<td><%=arme.getIdArme()%></td>
					<td><%=arme.getNomArme()%></td>
					<td><%=arme.getPuissanceOffensive()%></td>
					<td><%=arme.getPuissanceDefensive()%></td>
					
					
					<% if (gladiateur.possedeArme(arme.getIdArme())) { %>
						
					<td>
						<form action="assignationArme" method="post">
							<div class="button">
								<input type="hidden" name="idArme" value=<%=arme.getIdArme()%> />
								<input type="hidden" name="idGladiateur" value=<%=idGladiateur%> />
								<input type="hidden" name="action" value="desequiper" />
								<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
								<button  type="submit">Desequiper</button>
							</div>
						</form>
					</td>
					
					<% }  else { %>

					<td>
						<form action="assignationArme" method="post">
							<div class="button">
								<input type="hidden" name="idArme" value=<%=arme.getIdArme()%> />
								<input type="hidden" name="idGladiateur" value=<%=idGladiateur%> />
								<input type="hidden" name="action" value="equiper" />
								<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
								<button  type="submit">Equiper</button>
							</div>
						</form>
					</td>
				<%	
				}
				%>
				
			<%	
			}
			%>
		</table>
	
	</body>
</html>
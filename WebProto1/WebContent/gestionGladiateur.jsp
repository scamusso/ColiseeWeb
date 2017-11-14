<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="
controlleur.*,
modele.*
"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Colisee V2 Gestion XML</title>
</head>
<body>
	<%
		Facade contexteXML = (Facade) request.getAttribute("contexteXML");
    %>
	<h1>Ajouter un element dans le fichier</h1>
	<table border="1" cellpadding="10" width="100%">
		<tr>
			<form action="editionGladiateur" method="post">
				<input type="hidden" name="idGladiateur" value="null" />
				<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
				<th><button type="submit">Ajouter Gladiateur</button></th>
			</form>
		</tr>
		<tr>
			<form action="editionArme" method="post">
				<input type="hidden" name="idArme" value="null" />
				<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
				<th><button type="submit">Ajouter Arme</button></th>
			</form>
		</tr>
		<tr>
			<a href="telechargementFichier" target = "_blank">Telecharger le XML</a>
		</tr>
	</table>
	</br>
	
	</br>
  	<h1>Liste des gladiateurs</h1>
	<table border="1" cellpadding="10" width="100%">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Type</th>
			<th>Vie / Vie Initiale</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
		<%
		for(Gladiateur gladiateur : contexteXML.listerTousLesGladiateurs ()) { %>
			<tr>
				<td><%=gladiateur.getIdGladiateur()%></td>
				<td><%=gladiateur.getNom()%></td>
				<td><%=gladiateur.getType()%></td>
				<td><%=gladiateur.getVie()%> / <%=gladiateur.getCVieInitiale()%></td>
				<td>
					<form action="suppressionGladiateur" method="post">
						<div class="button">
							<input type="hidden" name="idGladiateur" value=<%=gladiateur.getIdGladiateur()%> />
							<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
							<button  type="submit">Supprimer</button>
						</div>
					</form>
				</td>
				<td>
					<form action="editionGladiateur" method="post">
						<div class="button">
							<input type="hidden" name="idGladiateur" value=<%=gladiateur.getIdGladiateur()%> />
							<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
							<button  type="submit">Modifier</button>
						</div>
					</form>
				</td>
			</tr>
		<%	
		}
		%>
	</table>
	</br>
	<h1>Liste des armes</h1>
	<table border="1" cellpadding="10" width="100%">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Puissance offensive</th>
			<th>Puissance defensive</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
		<%
		for(Arme arme : contexteXML.listerToutesLesArmes()) { %>
			<tr>
				<td><%=arme.getIdArme()%></td>
				<td><%=arme.getNomArme()%></td>
				<td><%=arme.getPuissanceOffensive()%></td>
				<td><%=arme.getPuissanceDefensive()%></td>
				<td>
					<form action="suppressionArme" method="post">
						<div class="button">
							<input type="hidden" name="idArme" value=<%=arme.getIdArme()%> />
							<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
							<button  type="submit">Supprimer</button>
						</div>
					</form>
				</td>
				<td>
					<form action="editionArme" method="post">
						<div class="button">
							<input type="hidden" name="idArme" value=<%=arme.getIdArme()%> />
							<input type="hidden" name="contexteXML" value=<%=contexteXML%> />
							<button  type="submit">Modifier</button>
						</div>
					</form>
				</td>
			</tr>
		<%	
		}
		%>
	</table>
	</br>
</body>
</html>
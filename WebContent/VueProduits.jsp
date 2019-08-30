<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script >
function confirmer(url){
	var rep = confirm("Etes vous sure de vouloir supprimer ? ");
	if(rep == true){
		document.location = url ; 
	}
}
</script>

</head>
<body>
  <div>
   <form action="controleur.php" method="post">
     <table class="table1">
      <tr>
       <td> Mot Clé : </td>
       <td><input type="text" name="motCle" value="${moda.motCle}"/></td>
       <td><input type="submit" value="chercher" name="action" /></td>
      </tr>
       
     </table>
   </form>
 </div>
 
 <div>
   <form action="controleur.php" method="post">
     <table class="table1">
      <tr>
       <td> REF : </td>
       <td><input type="text" name="reference" value=" ${moda.produit.reference}"/></td>
             </tr>
             
              <tr>
       <td> Designation : </td>
       <td><input type="text" name="designation"  value=" ${moda.produit.designation}" /></td>
             </tr>
             
              <tr>
       <td> Prix : </td>
       <td><input type="text" name="prix" value=" ${moda.produit.prix}" /></td>
             </tr>
             
              <tr>
       <td> Quantite : </td>
       <td><input type="text" name="quantite" value=" ${moda.produit.quantite}" /></td>
             </tr>
      
      <tr>
       <td><input type="submit" name="action" value="save" /></td>
             </tr> 
     </table>
   </form>
 </div>
 
 <div>
   ${moda.errors}
 </div>
 
 <div>
    <table class="table2">
      <th>REF</th> <th>DES</th> <th>PRIX</th> <th>QUANTITE</th>
     
      <c:forEach items="${moda.produits}" var="p">
         <tr>
           <td>${p.reference}</td>
           <td>${p.designation}</td>
           <td>${p.prix}</td>
           <td>${p.quantite}</td>
           <td><a href="javascript:confirmer('controleur.php?action=delete&ref=${p.reference}')" > <b>Supprimer</b> </a></td>
           <td><a href="controleur.php?action=edit&ref=${p.reference}" > <b>Edit</b> </a></td>
         </tr>
      </c:forEach>
      </table>
 </div>
</body>
</html>
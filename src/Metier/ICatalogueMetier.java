package Metier;

import java.util.List;

public interface ICatalogueMetier {
   public void addProduit(Produit p);
   public List<Produit> listProduits();
   public List<Produit> produitsParMC(String mc);
   public Produit getProduit(String ref) throws Exception; 
   public void updateProduit(Produit p) throws Exception;
   public void deleteProduit(String ref);

}

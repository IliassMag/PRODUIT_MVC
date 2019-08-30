package Metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) throws Exception  {
		
		ICatalogueMetier metier = new CatalogueMetierImp1();
	//	metier.addProduit(new Produit("REF05","AAA", 870, 3));
	//	metier.addProduit(new Produit("REF06","BB", 345.00, 12));
	//	metier.addProduit(new Produit("REF07","CC", 65.00, 2));
//		System.out.println("-----------------------------");
//	   	List<Produit> prods = metier.listProduits();
//		for(Produit p : prods) {
//			System.out.println(p.getDesignation());
//			}
//		System.out.println("-----------------------------");
//		List<Produit> prods2 = metier.produitsParMC("HP");
//		for(Produit p : prods2) {
//			System.out.println(p.getDesignation());
//			}
//		System.out.println("-----------------------------");
//		 Produit p=metier.getProduit("PR09");
//		 System.out.println(p.getDesignation());
//		System.out.println("-----------------------------");
//		Produit p1 = metier.getProduit("PR02");
//		 p1.setPrix(13000.00);
//		System.out.println(p1.toString());
//		metier.updateProduit(p1);
//		
//		Produit p2 = metier.getProduit("PR02");
//		System.out.println(p2.toString());
		
		metier.deleteProduit("REF05");
		
		
	}
}

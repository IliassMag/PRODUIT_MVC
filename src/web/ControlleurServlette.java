package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Metier.CatalogueMetierImp1;
import Metier.ICatalogueMetier;
import Metier.Produit;

public class ControlleurServlette extends HttpServlet {
       private ICatalogueMetier metier;
       
      @Override
    public void init() throws ServletException {
    	metier = new CatalogueMetierImp1();
    }
      
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }
      
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  ProduitModel model = new ProduitModel();
    	  req.setAttribute("moda",model);
    	  String action=req.getParameter("action");
    	  if(action!=null) {
    		  if(action.equals("chercher")) {
    		    	model.setMotCle(req.getParameter("motCle"));
    		    	List<Produit> produits = metier.produitsParMC(model.getMotCle());
    		    	model.setProduits(produits);
    		  
    		  }
    		  else if(action.equals("delete")) {
    			  String ref = req.getParameter("ref");
    			  metier.deleteProduit(ref);
    			  model.setProduits(metier.listProduits());
    			  
    		  }
    		  
    		  else if(action.equals("edit")) {
    			  String ref = req.getParameter("ref");
    			  Produit p=null;
				try {
					p = metier.getProduit(ref);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			  model.setProduit(p);
    		  model.setProduits(metier.listProduits());
    			  
    		  }
    		  
    		  else if(action.equals("save")) {
    			  try {
    			model.getProduit().setReference(req.getParameter("reference"));
    			model.getProduit().setDesignation(req.getParameter("designation"));
    			model.getProduit().setPrix(Double.parseDouble(req.getParameter("prix")));  
    			model.getProduit().setQuantite(Integer.parseInt(req.getParameter("quantite")));
    		    
    			metier.addProduit(model.getProduit());
    			model.setProduits(metier.listProduits());
    			     }catch(Exception e) {
    			    model.setErrors(e.getMessage());
    			     }
    			  
    			  }
    		  
    	  }

    	req.getRequestDispatcher("VueProduits.jsp").forward(req,resp);
    }
}

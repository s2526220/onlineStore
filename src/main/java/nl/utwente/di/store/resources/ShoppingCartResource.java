package nl.utwente.di.store.resources;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.di.store.model.CatalogueItem;
import nl.utwente.di.store.model.ItemOrder;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import nl.utwente.di.store.dao.ShoppingCart;

@Path("cart")
public class ShoppingCartResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCart(List<ItemOrder> input) {
		for (ItemOrder item : input) {
			ShoppingCart.instance.addItem(item.getItem().getItemID(), item.getNumItems());
			System.out.println(item + "\n");
		}
			
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemOrder> getShoppingCart() {
		return ShoppingCart.instance.getModel();
	}
	
	@DELETE
	public void deleShoppingCart() {
		ShoppingCart.instance.getModel().clear();
	}
	
	@Path("costs")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double totalCosts() {
		List<ItemOrder> items = ShoppingCart.instance.getModel();
		double costs = 0;
		for (ItemOrder item : items) {
			costs = costs + ( item.getNumItems()* item.getItem().getCost());
		}
		return costs;
	}
}

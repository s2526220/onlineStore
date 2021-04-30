package nl.utwente.di.store.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.utwente.di.store.model.CatalogueItem;

@Path("tech")
public class TechBooksResource extends CatalogueResource {
	
	static String[] ids = { "hall001", "hall002" };
	
	public TechBooksResource() {
		super(ids, "All-Time Best Computer Books");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CatalogueItem> getTechCatalogueItems() {
		System.out.println("call made");
		return getCatalogueItems();
	}
}

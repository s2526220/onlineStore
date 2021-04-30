package nl.utwente.di.store.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.utwente.di.store.model.CatalogueItem;

@Path("kids")
public class KidsBooksResource extends CatalogueResource {
	
	static String[] ids = { "lewis001", "alexander001", "rowling001" };
	
	public KidsBooksResource() {
		super(ids, "All-Time Best Children's Fantasy Books");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CatalogueItem> getKidsCatalogueItems() {
		return getCatalogueItems();
	}
}

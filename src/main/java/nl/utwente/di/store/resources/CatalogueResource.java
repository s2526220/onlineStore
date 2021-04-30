package nl.utwente.di.store.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.utwente.di.store.model.CatalogueItem;
import nl.utwente.di.store.dao.Catalogue;

@Path("/catalogue")
public class CatalogueResource {
	private String[] itemIDs;
	private String title;

	public CatalogueResource() {

	}

	public CatalogueResource(String[] ids, String title) {
		this.setItemIDs(ids);
		this.setTitle(title);
	}

	public String[] getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public List<CatalogueItem> getCatalogueItems() {
		List<CatalogueItem> items = new ArrayList<CatalogueItem>();
		for (String id : itemIDs)
			items.add(Catalogue.instance.getModel().get(id));
		return items;
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CatalogueItem> getAllCatalogueItems() {
		List<CatalogueItem> items = new ArrayList<CatalogueItem>();
		for (Map.Entry<String, CatalogueItem> es : Catalogue.instance.getModel().entrySet())
			items.add(es.getValue());
		return (items);
	}
	
	@Path("count")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = Catalogue.instance.getModel().size();
		return String.valueOf(count);
	}

	@GET
	@Path("{itemID}")
	@Produces(MediaType.APPLICATION_JSON)
	public CatalogueItem getTodo(@PathParam("itemID") String id) {
		return Catalogue.instance.getModel().get(id);
	}

}

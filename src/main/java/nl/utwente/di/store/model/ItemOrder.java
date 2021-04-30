package nl.utwente.di.store.model;

public class ItemOrder {
	private CatalogueItem item;
	  private int numItems;

	  public ItemOrder() {
	  }
	  
	  public ItemOrder(CatalogueItem item) {
	    setItem(item);
	    setNumItems(1);
	  }

	  public CatalogueItem getItem() {
	    return(item);
	  }

	  protected void setItem(CatalogueItem item) {
	    this.item = item;
	  }

	  public int getNumItems() {
	    return(numItems);
	  }

	  public void setNumItems(int n) {
	    this.numItems = n;
	  }

	  public void incrementNumItems() {
	    setNumItems(getNumItems() + 1);
	  }

	  public void cancelOrder() {
	    setNumItems(0);
	  }

	  public String toString()
	  {
		  return "ItemID = " + this.getItem().getItemID() + " NumItems =  "+ this.getNumItems();
	  }
	}


package nl.utwente.di.store.dao;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.di.store.model.ItemOrder;

public enum ShoppingCart {
	instance;

	private List<ItemOrder> itemsOrdered = new ArrayList<ItemOrder>();

	private ShoppingCart() {
		
	}

	public List<ItemOrder> getModel() {
		return itemsOrdered;
	}
	/**
	 * Looks through cart to see if it already contains an order entry
	 * corresponding to item ID. If it does, increments the number ordered by more. If
	 * not, looks up Item in catalogue and adds an order entry for it.
	 */

	public synchronized void addItem(String itemID, int more) {
		ItemOrder order;
		boolean found = false;
		int i = 0;

		while (!found && i < itemsOrdered.size()) {
			order = itemsOrdered.get(i);
			if (order.getItem().getItemID().equals(itemID)) {
				found = true;
				order.setNumItems(order.getNumItems()+more);
			}
			i++;
		}
		if (!found) {
			ItemOrder newOrder = new ItemOrder(Catalogue.instance.getModel().get(itemID));
			newOrder.setNumItems(more);
			itemsOrdered.add(newOrder);
		}
		return;
	}

	/**
	 * Looks through cart to find order entry corresponding to item ID listed.
	 * If the designated number is positive, sets it. If designated number is 0
	 * (or, negative due to a user input error), deletes item from cart.
	 */

	public synchronized void setNumOrdered(String itemID, int numOrdered) {
		ItemOrder order;
		boolean found = false;
		int i = 0;

		while (!found && i < itemsOrdered.size()) {
			order = itemsOrdered.get(i);
			if (order.getItem().getItemID().equals(itemID)) {
				found = true;
				if (numOrdered <= 0)
					itemsOrdered.remove(i);
				else
					order.setNumItems(numOrdered);
			}
			i++;
		}
		if (!found) {
			ItemOrder newOrder = new ItemOrder(Catalogue.instance.getModel().get(itemID));
			itemsOrdered.add(newOrder);
		}
		return;
	}

}
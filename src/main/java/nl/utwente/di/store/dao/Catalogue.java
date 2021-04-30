package nl.utwente.di.store.dao;

import java.util.HashMap;
import java.util.Map;

import nl.utwente.di.store.model.CatalogueItem;;

public enum Catalogue {
	instance;

	private Map<String, CatalogueItem> items = new HashMap<String, CatalogueItem>();

	private Catalogue() {

		CatalogueItem item = new CatalogueItem("hall001",
				"<I>Core Servlets and JavaServer Pages " + "2nd Edition</I> (Volume 1)"
						+ " by Marty Hall and Larry Brown",
				"The definitive reference on servlets " + "and JSP from Prentice Hall and \n"
						+ "Sun Microsystems Press.<P>Nominated for " + "the Nobel Prize in Literature.",
				39.95);
		items.put("hall001", item);

		item = new CatalogueItem("hall002",
				"<I>Core Web Programming, 2nd Edition</I> " + "by Marty Hall and Larry Brown",
				"One stop shopping for the Web programmer. " + "Topics include \n"
						+ "<UL><LI>Thorough coverage of Java 2; " + "including Threads, Networking, Swing, \n"
						+ "Java 2D, RMI, JDBC, and Collections\n" + "<LI>A fast introduction to HTML 4.01, "
						+ "including frames, style sheets, and layers.\n" + "<LI>A fast introduction to HTTP 1.1, "
						+ "servlets, and JavaServer Pages.\n" + "<LI>A quick overview of JavaScript 1.2\n" + "</UL>",
				49.99);
		items.put("hall002", item);

		item = new CatalogueItem("lewis001", "<I>The Chronicles of Narnia</I> by C.S. Lewis",
				"The classic children's adventure pitting " + "Aslan the Great Lion and his followers\n"
						+ "against the White Witch and the forces " + "of evil. Dragons, magicians, quests, \n"
						+ "and talking animals wound around a deep " + "spiritual allegory. Series includes\n"
						+ "<I>The Magician's Nephew</I>,\n" + "<I>The Lion, the Witch and the Wardrobe</I>,\n"
						+ "<I>The Horse and His Boy</I>,\n" + "<I>Prince Caspian</I>,\n"
						+ "<I>The Voyage of the Dawn Treader</I>,\n" + "<I>The Silver Chair</I>, and \n"
						+ "<I>The Last Battle</I>.",
				19.95);
		items.put("lewis001", item);

		item = new CatalogueItem("alexander001", "<I>The Prydain Series</I> by Lloyd Alexander",
				"Humble pig-keeper Taran joins mighty " + "Lord Gwydion in his battle against\n"
						+ "Arawn the Lord of Annuvin. Joined by " + "his loyal friends the beautiful princess\n"
						+ "Eilonwy, wannabe bard Fflewddur Fflam," + "and furry half-man Gurgi, Taran discovers "
						+ "courage, nobility, and other values along\n" + "the way. Series includes\n"
						+ "<I>The Book of Three</I>,\n" + "<I>The Black Cauldron</I>,\n"
						+ "<I>The Castle of Llyr</I>,\n" + "<I>Taran Wanderer</I>, and\n" + "<I>The High King</I>.",
				19.95);
		items.put("alexander001", item);

		item = new CatalogueItem("rowling001", "<I>The Harry Potter Series</I> by J.K. Rowling",
				"The first five of the popular stories " + "about wizard-in-training Harry Potter\n"
						+ "topped both the adult and children's " + "best-seller lists. Series includes\n"
						+ "<I>Harry Potter and the Sorcerer's Stone</I>,\n"
						+ "<I>Harry Potter and the Chamber of Secrets</I>,\n" + "<I>Harry Potter and the "
						+ "Prisoner of Azkaban</I>,\n" + "<I>Harry Potter and the Goblet of Fire</I>, and\n"
						+ "<I>Harry Potter and the " + "Order of the Phoenix</I>.\n",
				59.95);
		items.put("rowling001", item);

	}

	public Map<String, CatalogueItem> getModel() {
		return items;
	}

}
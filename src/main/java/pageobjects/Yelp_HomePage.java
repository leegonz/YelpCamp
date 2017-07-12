package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import auto.framework.PageBase;
import auto.framework.web.CheckBox;
import auto.framework.web.Element;
import auto.framework.web.Page;
import auto.framework.web.TextBox;

public class Yelp_HomePage extends PageBase {
	
	public static final Yelp_HomeBodyCampgroundsSection yelp_HomeBodyCampgroundsSection = new Yelp_HomeBodyCampgroundsSection();

	public static class Yelp_HomeBodyCampgroundsSection extends Element{

		public final Element batanesOption;
		public final Element editButton;
		
		public Yelp_HomeBodyCampgroundsSection() {
			super("Yelp HomeBody Campgrounds Section", By.xpath("//div[@class='kx-table']"));
			batanesOption = new Element("Batanes Option", By.xpath("//span[contains(.,'Batanes')]/ancestor::div[1]"));
			editButton = new Element("Edit Button", By.xpath("//i[@class='material-icons']"));
			
		}
	
	}
	
	public static final Element batanesOption = new Element("Batanes Option", By.xpath("//span[contains(.,'Batanes')]/ancestor::div[1]"));
	public static final Element editButton = new Element("Edit Button", By.id("edit-campground"));

	
	}

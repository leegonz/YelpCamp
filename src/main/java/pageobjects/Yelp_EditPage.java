package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.CheckBox;
import auto.framework.web.Element;
import auto.framework.web.Page;
import auto.framework.web.TextBox;

public class Yelp_EditPage extends PageBase {
	
	public static final Yelp_EditCampgroundsSection yelp_EditCampgroundsSection = new Yelp_EditCampgroundsSection(null);

	public static class Yelp_EditCampgroundsSection extends Element{

		public final TextBox descriptionField;
		public final Element applyChangesButton;
		
		public Yelp_EditCampgroundsSection(Element parent) {
			super("Yelp Edit Campgrounds Section", By.xpath("//div[@class='base-card mdl-card mdl-shadow--2dp']"));
			descriptionField = new TextBox("Description Field", By.name("campground[description]"), this);
			applyChangesButton = new Element("Apply Changes Button", By.xpath("//button[contains(.,'Apply Changes')]"), this);
		}
	
	}
	
}

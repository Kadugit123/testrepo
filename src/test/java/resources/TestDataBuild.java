package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload()
	{
		AddPlace ap=new AddPlace();
		ap.setAccuracy("50");
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress("29, side layout, cohen 09");
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-IN");
		List<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		ap.setTypes(types);
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		ap.setLocation(loc);
		return ap;
	}
}

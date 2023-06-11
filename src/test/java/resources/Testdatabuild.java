package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_Place;
import pojo.Location;

public class Testdatabuild {
        
	public Add_Place addplacepayload(String name,String language, String address) {
	Add_Place p=new Add_Place(); 
	p.setAccuracy(50);
	p.setName(name);
	p.setPhone_number("(+91) 983 893 3937");
	p.setAddress(address);
	p.setWebsite("http://google.com");
	p.setLanguage(language);
	//creating the list and passing the values to the list
	List <String> list=new ArrayList <String>();
	list.add("shoe park");
	list.add("shop");
	p.setTypes(list);
	//creating location class object and passing the values using by calling the setter method
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	return p;
}
	public String deleteplacepayload(String placeid) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
		
	}
}
  
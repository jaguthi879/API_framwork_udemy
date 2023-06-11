package stepdefinitionfiles;

import java.io.IOException;



import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforescenario() throws IOException {
		
		if(Placevalidation_stepdefinition.placeid==null)
		{
			
		 Placevalidation_stepdefinition s=new Placevalidation_stepdefinition();
		 s.add_place_payload_with("ABC", "Italian", "Downwalk Texas");
		 s.user_calls_using_http_request("AddplaceAPi", "POST");
		 s.verify_palce_id_created_which_maps_to_using("ABC", "getplaceAPi");		
	}
}
}

package resources;


//using enum classes 
public enum Apiresources { 
	
	AddplaceAPi("/maps/api/place/add/json"),
	getplaceAPi("/maps/api/place/get/json"),
	deletepalceAPi("/maps/api/place/delete/json");
	private String resource;
	
	Apiresources(String resource){
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
}

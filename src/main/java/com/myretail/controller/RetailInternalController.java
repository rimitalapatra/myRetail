package com.myretail.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myretail.model.ProductName;
import com.myretail.model.reatilProductName;
import com.myretail.model.url;
import com.myretail.repository.UserRepository;



@RestController

public class RetailInternalController {
	
	@Autowired
	private url employeeProperties;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private  url url;

	@SuppressWarnings("unchecked")
	@GetMapping("/productExternal/{id}")
	public JSONObject callExternalApi(@PathVariable("id") int id) {
		System.out.print("Entered callExternalApi get");
	    RestTemplate restTemplate = new RestTemplate();
	     
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    String url=getURI(id);

	    ProductName result = restTemplate.getForObject(url, ProductName.class, params);
	    
	    JSONObject finalJsonObject=new JSONObject();
	    Optional<reatilProductName> reatilProdNosql= userRepository.findById(id);
	    if(reatilProdNosql.isPresent()) {
	    	reatilProductName retailProd=reatilProdNosql.get();
	    	finalJsonObject.put("value",retailProd.getPrice());
	    	finalJsonObject.put("currency_code",retailProd.getCurrencyCode());
	    }

	    JSONObject jsonObject=new JSONObject();
	    jsonObject.put("name",result.getName());
	    jsonObject.put("id",result.getId());
	    jsonObject.put("current_price",finalJsonObject);
       
		System.out.print("Exited callExternalApi get");

		return jsonObject;
	}

	private  String getURI(int param){
		
		String protocol=employeeProperties.getProtocol();
		StringBuffer myStringBuffer=new StringBuffer();
		String host=employeeProperties.getHost();
        int port=employeeProperties.getPort();
        myStringBuffer.append(protocol);
		myStringBuffer.append("://");
		myStringBuffer.append(host);
		myStringBuffer.append(":");
		myStringBuffer.append(port);
		myStringBuffer.append("/");
		myStringBuffer.append("myretail/product/");
		myStringBuffer.append(param);
		String finalUrl=myStringBuffer.toString();
        //final String uri = "http://localhost:9090/myretail/product/{id}";
		return finalUrl;
		
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping(value="/productExternal/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

	public JSONObject callExternalApiUpdate(@PathVariable("id") int id,@RequestBody reatilProductName reatilProductName) {
		
		System.out.print("Entered callExternalApi put");

	    
	    com.myretail.model.reatilProductName reatilProdNosql= userRepository.save(reatilProductName);
	    JSONObject finalJsonObject=new JSONObject();

	    finalJsonObject.put("value",reatilProdNosql.getPrice());
    	finalJsonObject.put("currency_code",reatilProdNosql.getCurrencyCode());
    	
		System.out.print("Exited callExternalApi put");


         return finalJsonObject;
	       
	
	    
	    
	}
	@SuppressWarnings("unchecked")
	@PostMapping(value="/productExternal/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

	public JSONObject callExternalApiPost(@PathVariable("id") int id,@RequestBody reatilProductName reatilProductName) {
		
	   
	    
	    com.myretail.model.reatilProductName reatilProdNosql= userRepository.save(reatilProductName);
	    JSONObject finalJsonObject=new JSONObject();

	    finalJsonObject.put("value",reatilProdNosql.getPrice());
    	finalJsonObject.put("currency_code",reatilProdNosql.getCurrencyCode());

         return finalJsonObject;
	       
	
	    
	    
	}


	
}

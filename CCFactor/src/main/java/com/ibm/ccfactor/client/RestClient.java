package com.ibm.ccfactor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Convert-Currency")
public interface RestClient {

	@GetMapping("/convertCurrency/{countryCode}/{amount}")
	public String convertCurrency(@PathVariable(value="countryCode") String countryCode , 
			@PathVariable(value="amount") Double amount);
	
}

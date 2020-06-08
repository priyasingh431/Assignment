package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.service.CurrencyService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;

	@ApiOperation("Method to convert currency")
	@GetMapping("/convertCurrency/{countryCode}/{amount}")
	public String convertCurrency(@PathVariable(value="countryCode") String countryCode , 
			@PathVariable(value="amount") Double amount) {
		return currencyService.createConversionfactor(countryCode,amount);
	}
	
}

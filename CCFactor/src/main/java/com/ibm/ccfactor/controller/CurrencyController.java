package com.ibm.ccfactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ccfactor.dto.CurrencyDTO;
import com.ibm.ccfactor.service.CurrencyService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;

	@ApiOperation("Method to create conversion factor")
	@PostMapping("create")
	public ResponseEntity<CurrencyDTO> createConversionfactor(@RequestBody CurrencyDTO currencyDTO) {
		CurrencyDTO currencyDTO1 = currencyService.createConversionfactor(currencyDTO);
		return ResponseEntity.ok().body(currencyDTO1);
	}
	
	@ApiOperation("Method to update conversion factor")
	@PostMapping("update")
	public ResponseEntity<CurrencyDTO> updateConversionfactor(@RequestBody CurrencyDTO currencyDTO) {
		CurrencyDTO currencyDTO1 = currencyService.updateConversionfactor(currencyDTO);
		return ResponseEntity.ok().body(currencyDTO1);
	}
	
	@ApiOperation("Method to fetch conversion factor")
	@GetMapping("currency/{countryCode}")
	public ResponseEntity<CurrencyDTO> getConversionFactor (@PathVariable(value="countryCode") String countryCode) {
		return ResponseEntity.ok().body(currencyService.getConversionFactor(countryCode));
	}
	
	@ApiOperation("Method to convert currency")
	@PostMapping("/convertCurrency/{countryCode}/{amount}")
	public Double convertCurrency(@PathVariable(value="countryCode") String countryCode , 
			@PathVariable(value="amount") Double amount) {
		return currencyService.createConversionfactor(countryCode,amount);
	}
	
}

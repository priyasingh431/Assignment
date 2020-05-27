package com.ibm.ccfactor.dto;

import com.ibm.ccfactor.domain.Currency;

public class CurrencyMapper {

	public CurrencyDTO convertCurrencyToCurrencyDTO(Currency currency){
		CurrencyDTO currencyDTO = new CurrencyDTO();
		currencyDTO.setCountryCode(currency.getCountryCode());
		currencyDTO.setConversionFactor(currency.getConversionFactor());
		return currencyDTO;
	}
	
	public Currency convertCurrencyDTOToCurrency(CurrencyDTO currencyDTO){
		Currency currency = new Currency();
		currency.setCountryCode(currencyDTO.getCountryCode());
		currency.setConversionFactor(currencyDTO.getConversionFactor());
		return currency;
	}
	
	
}

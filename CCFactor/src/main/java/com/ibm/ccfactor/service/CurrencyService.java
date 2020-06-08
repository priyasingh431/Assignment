package com.ibm.ccfactor.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ccfactor.client.RestClient;
import com.ibm.ccfactor.domain.Currency;
import com.ibm.ccfactor.dto.CurrencyDTO;
import com.ibm.ccfactor.dto.CurrencyMapper;
import com.ibm.ccfactor.repository.CurrencyRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyService {
	
	static final Logger log = LoggerFactory.getLogger(CurrencyService.class);
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	final RestClient restClient;

	@Autowired
	public CurrencyService(RestClient restClient) {
		this.restClient=restClient;
	}
	
	public CurrencyDTO createConversionfactor(CurrencyDTO currencyDTO) {
		CurrencyMapper currencyMapper = new CurrencyMapper();
		Currency currency = currencyMapper.convertCurrencyDTOToCurrency(currencyDTO);
		Currency currency1 = currencyRepository.save(currency);
		return currencyMapper.convertCurrencyToCurrencyDTO(currency1);
	}
	
	public CurrencyDTO updateConversionfactor(CurrencyDTO currencyDTO) {
		CurrencyMapper currencyMapper = new CurrencyMapper();
		Currency currency1=new Currency();
		Optional<Currency> currency= currencyRepository.findById(currencyDTO.getCountryCode());
		if(currency.isPresent()) {
			currency.get().setConversionFactor(currencyDTO.getConversionFactor());
			currency1 = currencyRepository.save(currency.get());
		}
		return currencyMapper.convertCurrencyToCurrencyDTO(currency1);
	}	
	
	public CurrencyDTO getConversionFactor(String name) {
		CurrencyMapper currencyMapper = new CurrencyMapper();
		Currency currency = currencyRepository.findByCountryCode(name);
		return currencyMapper.convertCurrencyToCurrencyDTO(currency);
	}

	@HystrixCommand(fallbackMethod="currencyServiceFallback")
	public Double createConversionfactor(String countryCode, Double amount) {
		log.info("calling rest client :: " + countryCode + ":" + amount);
		String convertedAmount= restClient.convertCurrency(countryCode, amount);
		log.info("returning rest client :: " + convertedAmount);
		return Double.valueOf(convertedAmount);
	}
	
	public Double currencyServiceFallback(String countryCode, Double amount) {
		log.info("calling fallback method :: " + countryCode + ":" + amount);
		return (double) 0;
	}

}

package com.ibm.convertcurrency.service;


import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
	
	public String createConversionfactor(String countryCode,Double amount) {
		/*
		 * MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory().
		 * setCurrency(currencyDTO.getCountryCode()).setNumber(1).create();
		 * CurrencyConversion conversionINR= MonetaryConversions.getConversion("INR");
		 * MonetaryAmount convertedAmountINR = monetaryAmount.with(conversionINR);
		 * return convertedAmountINR.toString();
		 */
		/*
		 * final ExchangeRateProvider rateProvider =
		 * MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF); final
		 * CurrencyConversion dollarConversion =
		 * rateProvider.getCurrencyConversion(currencyDTO.getCountryCode()); final
		 * MonetaryAmount inEuro = Money.of(currencyDTO.getConversionFactor(), "INR");
		 * final MonetaryAmount inDollar = inEuro.with(dollarConversion); return
		 * inDollar.toString();
		 */
         
         final MonetaryAmount inEuro = Money.of(amount, countryCode);
         final ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF);
         final CurrencyConversion rupeeConversion = rateProvider.getCurrencyConversion("INR");
         final MonetaryAmount inRupeeConversion = inEuro.with(rupeeConversion);
         return inRupeeConversion.toString();
	}
}

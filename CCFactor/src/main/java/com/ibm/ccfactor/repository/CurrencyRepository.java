package com.ibm.ccfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ccfactor.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String>{

	Currency findByCountryCode(String name);

}

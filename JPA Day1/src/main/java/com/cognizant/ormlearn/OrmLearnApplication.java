package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.Exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest();
		Country country=new Country();
		country.setCode("te");
		country.setName("test");
		addCountryTest(country);
		updateCountryTest("IN");
		deleteCountryTest("te");
		
	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");

		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}
	
	private static void addCountryTest(Country country) {
		LOGGER.info("Start");

		 countryService.addCountry(country);

		LOGGER.info("End");

	}
	private static void updateCountryTest(String code) throws CountryNotFoundException {
		countryService.updateCountry(code);
	}
	private static void deleteCountryTest(String code) {
		countryService.deleteCountry(code);
	}

}

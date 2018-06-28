package soap_ws.utils;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

public class StringUtils {

  public static void printGetCountryResponse(GetCountryResponse response){
    Country country = response.getCountry();
    Currency currency = country.getCurrency();
    System.out.println("name: " + country.getName());
    System.out.println("capital: " + country.getCapital());
    System.out.println("name: " + country.getPopulation());
    System.out.println("currency: " + country.getCurrency());
  }
}

package soap_ws;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap_ws.dao.CountryDao;
import soap_ws.utils.StringUtils;

@Endpoint
public class CountryEndpoint {
  private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

  private CountryDao countryDao;

  @Autowired
  public CountryEndpoint(CountryDao countryDao) {
    this.countryDao = countryDao;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryDao.findCountry(request.getName()));

    System.out.println("RESPONSE");
    StringUtils.printGetCountryResponse(response);

    return response;
  }
}

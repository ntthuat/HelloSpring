package soap_ws;


import org.springframework.context.annotation.Bean;
import soap_ws.dao.CountryDao;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/05/11 02:59:10 $
 * $Log: WebServiceContext.java,v $
 */
public class WebServiceContext {
  private static WebServiceContext messagesContext = null;

  private CountryDao countryDao;

  private WebServiceContext() {
  }

  public static void init() {
    if (messagesContext == null) {
      messagesContext = new WebServiceContext();
    }
  }

  public static WebServiceContext getContext() throws Error {
    if (messagesContext == null) {
      throw new Error("MessagesContext was not initialized -> null");
    } else {
      return messagesContext;
    }
  }

  public CountryDao getCountryDao() {
    return countryDao;
  }

  public void setCountryDao(CountryDao countryDao) {
    this.countryDao = countryDao;
  }
}

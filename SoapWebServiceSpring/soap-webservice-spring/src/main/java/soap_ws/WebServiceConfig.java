package soap_ws;

import org.springframework.context.annotation.ComponentScan;
import soap_ws.dao.CountryDao;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan(basePackages = {"soap_ws"})
public class WebServiceConfig extends WsConfigurerAdapter {
  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    System.out.println("Thuat");
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name = "countries")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("CountriesPort");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
    wsdl11Definition.setSchema(countriesSchema);
    System.out.println("Thuat2");
    return wsdl11Definition;
  }

  @Bean
  public XsdSchema countriesSchema() {
    System.out.println("Thuat3");
    return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
  }

  @Bean
  public WebServiceContext webServiceContext(CountryDao countryDao) {
    System.out.println("Thuat4");
    WebServiceContext.init();
    WebServiceContext.getContext().setCountryDao(countryDao);
    return WebServiceContext.getContext();
  }
}

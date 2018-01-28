package hello;

/*import codix.eu.soa_ws.module.token.TokenProperties;
import codix.eu.soa_ws.service.messages.dao.MessagesDAO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;*/

/**
 * Created by: hvdang
 * $Revision: 1.0 $ $Date: 2017/09/13 03:34:37 $
 * $Log: MessagesConfig.java,v $
 */
/*@Configuration*/
public class MessagesConfig
{
  /*@Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder)
  {
    return builder.build();
  }

  @Bean
  public MessagesContext messagesContext(DataSource dataSource, RestTemplate restTemplate
      , MessagesDAO messagesDAO, TokenProperties tokenProperties, MessagesProperties messagesProperties)
      throws SQLException
  {
    MessagesContext.init(dataSource);
    MessagesContext.getContext().setRestTemplate(restTemplate);
    MessagesContext.getContext().setMessagesDAO(messagesDAO);
    MessagesContext.getContext().setTokenProperties(tokenProperties);
    MessagesContext.getContext().setMessagesProperties(messagesProperties);
    return MessagesContext.getContext();
  }*/
}

package hello;

/*import codix.eu.soa_ws.module.token.TokenProperties;
import codix.eu.soa_ws.service.messages.dao.MessagesDAO;
import imx.ctx.Context;
import imx.ctx.ContextFactory;
import imx.ctx.RuntimeContext;
import imx.util.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;*/

public class MessagesContext
{
  /*private static MessagesContext messagesContext = null;

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;
  private RestTemplate restTemplate;
  private MessagesDAO messagesDAO;
  private TokenProperties tokenProperties;
  private MessagesProperties messagesProperties;

  private MessagesContext()
  {
  }

  public static void init(DataSource dataSource) throws SQLException
  {
    if (messagesContext == null) {
      messagesContext = new MessagesContext();
      messagesContext.dataSource = dataSource;
      messagesContext.jdbcTemplate = new JdbcTemplate(dataSource);

      //setup runtime Context from codix.imxlib.int:bo
      RuntimeContext.setContextFactory(new ContextFactory()
      {
        final Connection conn = messagesContext.getDataSource().getConnection();

        public Context createContext()
        {
          Context ctx = new Context();
          try {
            ctx.setDatabaseConnection(conn);
          }
          catch (Exception e) {
            throw new RuntimeException("failed to open a connection");
          }
          ctx.setRunnerName("ecom_ws");
          return ctx;
        }

        public void disposeContext()
        {
          try {
            conn.rollback();
          }
          catch (SQLException e) {
            e.printStackTrace();
          }
          jdbc.close(conn);
        }
      });
    }
  }

  public static MessagesContext getContext() throws Error
  {
    if (messagesContext == null) {
      throw new Error("MessagesContext was not initialized -> null");
    } else {
      return messagesContext;
    }
  }

  public DataSource getDataSource()
  {
    return dataSource;
  }

  public JdbcTemplate getJdbcTemplate()
  {
    return jdbcTemplate;
  }

  public RestTemplate getRestTemplate()
  {
    return restTemplate;
  }

  public void setRestTemplate(RestTemplate restTemplate)
  {
    this.restTemplate = restTemplate;
  }

  public TokenProperties getTokenProperties()
  {
    return tokenProperties;
  }

  public void setTokenProperties(TokenProperties tokenProperties)
  {
    this.tokenProperties = tokenProperties;
  }

  public MessagesDAO getMessagesDAO()
  {
    return messagesDAO;
  }

  public void setMessagesDAO(MessagesDAO messagesDAO)
  {
    this.messagesDAO = messagesDAO;
  }


  public MessagesProperties getMessagesProperties()
  {
    return messagesProperties;
  }

  public void setMessagesProperties(MessagesProperties messagesProperties)
  {
    this.messagesProperties = messagesProperties;
  }*/
}

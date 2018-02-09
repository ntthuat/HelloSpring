package com.demo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Thuat T Nguyen
 * @version 02/08/2018
 *
 */
@Component
@ConfigurationProperties("db") // prefix db, find db.* property values
public class DBProperties
{
  private String use_wallet;
  private String driver;
  private String user;
  private String password;
  private String url;
  private String testQuery;
  private String tnsEntry;

  @Override
  public String toString() {
    return "DBProperties{" +
        "use_wallet='" + use_wallet + '\'' +
        ", driver='" + driver + '\'' +
        ", user='" + user + '\'' +
        ", password='" + password + '\'' +
        ", url='" + url + '\'' +
        ", testQuery='" + testQuery + '\'' +
        ", tnsEntry='" + tnsEntry + '\'' +
        '}';
  }

  /* getter & setter */
  public String isUse_wallet() {
    return use_wallet;
  }

  public void setUse_wallet(String use_wallet) {
    this.use_wallet = use_wallet;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTestQuery() {
    return testQuery;
  }

  public void setTestQuery(String testQuery) {
    this.testQuery = testQuery;
  }

  public String getTnsEntry() {
    return tnsEntry;
  }

  public void setTnsEntry(String tnsEntry) {
    this.tnsEntry = tnsEntry;
  }
}

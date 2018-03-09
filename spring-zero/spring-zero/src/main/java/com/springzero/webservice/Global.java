package com.springzero.webservice;

/**
 * @author tnthien
 * @version 03/09/2018
 */
public class Global {
;
    private Double total_market_cap_usd;
    private Double total_24h_volume_usd;
    private Double bitcoin_percentage_of_market_cap;
    private Double active_currencies;
    private Double active_assets;
    private Double active_markets;
    private Double last_updated;

    public Double getTotal_market_cap_usd() {
        return total_market_cap_usd;
    }

    public Double getTotal_24h_volume_usd() {
        return total_24h_volume_usd;
    }

    public Double getBitcoin_percentage_of_market_cap() {
        return bitcoin_percentage_of_market_cap;
    }

    public Double getActive_currencies() {
        return active_currencies;
    }

    public Double getActive_assets() {
        return active_assets;
    }

    public Double getActive_markets() {
        return active_markets;
    }

    public Double getLast_updated() {
        return last_updated;
    }

    public void setTotal_market_cap_usd(Double total_market_cap_usd) {
        this.total_market_cap_usd = total_market_cap_usd;
    }

    public void setTotal_24h_volume_usd(Double total_24h_volume_usd) {
        this.total_24h_volume_usd = total_24h_volume_usd;
    }

    public void setBitcoin_percentage_of_market_cap(Double bitcoin_percentage_of_market_cap) {
        this.bitcoin_percentage_of_market_cap = bitcoin_percentage_of_market_cap;
    }

    public void setActive_currencies(Double active_currencies) {
        this.active_currencies = active_currencies;
    }

    public void setActive_assets(Double active_assets) {
        this.active_assets = active_assets;
    }

    public void setActive_markets(Double active_markets) {
        this.active_markets = active_markets;
    }

    public void setLast_updated(Double last_updated) {
        this.last_updated = last_updated;
    }
}

package eu.restcountries;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.dto.Country;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class JsonTest {
    @Test
    public void testCountryJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL countryJsonResponse = JsonTest.class.getClassLoader()
                .getResource("json/country.json");
        Country country = objectMapper.readValue(countryJsonResponse, Country.class);

        Assert.assertEquals("Aruba", country.getName());
        Assert.assertEquals(".aw", country.getTopLevelDomain().get(0));
        Assert.assertEquals("AW", country.getAlpha2Code());
        Assert.assertEquals("ABW", country.getAlpha3Code());
        Assert.assertEquals("297", country.getCallingCodes().get(0));
        Assert.assertEquals("Oranjestad", country.getCapital());
        Assert.assertEquals("AW", country.getAltSpellings().get(0));
        Assert.assertEquals("Americas", country.getRegion());
        Assert.assertEquals("Caribbean", country.getSubregion());
        Assert.assertEquals((Integer) 107394, country.getPopulation());
        Assert.assertEquals(new Double(12.5), country.getLatlng().get(0));
        Assert.assertEquals(new Double(-69.96666666), country.getLatlng().get(1));
        Assert.assertEquals("Aruban", country.getDemonym());
        Assert.assertEquals((Integer) 180, country.getArea());
        Assert.assertNull(country.getGini());
        Assert.assertEquals("UTC-04:00", country.getTimezones().get(0));
        Assert.assertEquals(0, country.getBorders().size());
        Assert.assertEquals("Aruba", country.getNativeName());
        Assert.assertEquals("533", country.getNumericCode());
        Assert.assertEquals("AWG", country.getCurrencies().get(0).getCode());
        Assert.assertEquals("Aruban florin", country.getCurrencies().get(0).getName());
        Assert.assertEquals("ƒ", country.getCurrencies().get(0).getSymbol());
        Assert.assertEquals("pa", country.getLanguages().get(1).getIso639_1());
        Assert.assertEquals("pan", country.getLanguages().get(1).getIso639_2());
        Assert.assertEquals("(Eastern) Punjabi", country.getLanguages().get(1).getName());
        Assert.assertEquals("ਪੰਜਾਬੀ", country.getLanguages().get(1).getNativeName());
        Assert.assertEquals("Aruba", country.getTranslations().getDe());
        Assert.assertEquals("アルバ", country.getTranslations().getJa());
        Assert.assertEquals("https://restcountries.eu/data/est.svg", country.getFlag());
        Assert.assertEquals("European Union", country.getRegionalBlocs().get(0).getName());
        Assert.assertEquals("EST", country.getCioc());
    }
}
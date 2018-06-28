package eu.codix;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatTest {

  @Test
  public void testDecimalFormat() {

    //case 1
    String pattern = "###,###.###";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String format = decimalFormat.format(123456789.123);
    System.out.println(format);
    Assert.assertEquals("123,456,789.123", format);

    //case 2
    String format2 = decimalFormat.format(1234);
    System.out.println(format2);
    Assert.assertEquals("1,234", format2);

    // case 3
    String format3 = decimalFormat.format(1234567891);
    System.out.println(format3);
  }

  @Test
  public void testDecimalFormatWithLocale() {
    /*for (int i = 0; i < Locale.getAvailableLocales().length; i++) {
        System.out.println(Locale.getAvailableLocales()[i]);
    }*/
    //case 1: VN
    Locale localeVN = new Locale("vi","VN");
    String pattern = "###.##";

    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(localeVN);
    decimalFormat.applyPattern(pattern);
    String format = decimalFormat.format(123456789.123);
    System.out.println(format);

    //case 2: Canada
    Locale localeCAN = new Locale("fr", "CA");
    DecimalFormat decimalFormatCAN = (DecimalFormat) NumberFormat.getNumberInstance(localeCAN);
    decimalFormatCAN.applyPattern(pattern);
    String formatCAN = decimalFormatCAN.format(123456789.123);
    System.out.println(formatCAN);

    //case 3: US
    DecimalFormat decimalFormatUS = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
    decimalFormatUS.applyPattern(pattern);
    String formatUS = decimalFormatUS.format(123456789.123);
    System.out.println(formatUS);
  }

  @Test
  public void testLocale() {

    Locale locale = Locale.getDefault();
    System.out.println("Default Locale: " + locale);
    // Getting all available locales from current instance of the JVM
    Locale[] availableLocale = Locale.getAvailableLocales();
    for (Locale aLocale : availableLocale) {
      System.out.println("Name of Locale: " + aLocale.getDisplayName());
      System.out.println("Language Code: " + aLocale.getLanguage() + ", Language Display Name: " + aLocale.getDisplayLanguage());
      System.out.println("Country Code: " + aLocale.getCountry() + ", Country Display Name: " + aLocale.getDisplayCountry());
      if (!aLocale.getScript().equals("")) {
        System.out.println("Script Code: " + aLocale.getScript() + ", Script Display Name: " + aLocale.getDisplayScript());
      }
      if (!aLocale.getVariant().equals("")) {
        System.out.println("Variant Code: " + aLocale.getVariant() + ", Variant Display Name: " + aLocale.getDisplayVariant());
      }
      System.out.println("****************************************************************");
    }

  }
}

package eu.codix;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatSymbolsTest {

  @Test
  public void testCastToString() {
    double d = 123.456789;
    double dAbs = Math.abs(d);
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
    // US locale represents numbers with a . as comma and without any (ten)thousend separators.
    decimalFormatSymbols.setInfinity("INF");
    decimalFormatSymbols.setNaN("NaN");
    DecimalFormat decfmt = new DecimalFormat((dAbs > 1E7 || dAbs < 1E-3) && dAbs > 0.0 ?
            "0.##############E000" : "0.#############", decimalFormatSymbols);

    String s = decfmt.format(d);
    // 1.234E567 => 1.234E+567
    int e = s.indexOf("E");
    if (e > 0 && s.charAt(e + 1) != '-')
      s = s.substring(0, e) + "E+" + s.substring(e + 1);
    System.out.println(s);
  }

  @Test
  public void testMain() {
    customFormat("###,###.###", 123456.789);
    customFormat("###.##", 123456.789);
    customFormat("000000.000", 123.78);
    customFormat("$###,###.###", 12345.67);
    customFormat("\u00a5###,###.###", 12345.67);

    Locale currentLocale = new Locale("en", "US");

    DecimalFormatSymbols unusualSymbols =
            new DecimalFormatSymbols(currentLocale);
    unusualSymbols.setDecimalSeparator('|');
    unusualSymbols.setGroupingSeparator('^');
    String strange = "#,##0.###";
    DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
    weirdFormatter.setGroupingSize(4);
    String bizarre = weirdFormatter.format(12345.678);
    System.out.println(bizarre);

    Locale[] locales = {
            new Locale("en", "US"),
            new Locale("de", "DE"),
            new Locale("fr", "FR")
    };

    for (int i = 0; i < locales.length; i++) {
      localizedFormat("###,###.###", 123456.789, locales[i]);
    }

  }

  public void customFormat(String pattern, double value) {
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String output = myFormatter.format(value);
    System.out.println(value + "  " + pattern + "  " + output);
  }

  public void localizedFormat(String pattern, double value,
                              Locale loc) {
    NumberFormat nf = NumberFormat.getNumberInstance(loc);
    DecimalFormat df = (DecimalFormat) nf;
    df.applyPattern(pattern);
    String output = df.format(value);
    System.out.println(pattern + "  " + output + "  " + loc.toString());
  }
}

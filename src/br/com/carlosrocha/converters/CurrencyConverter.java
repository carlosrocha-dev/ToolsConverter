package br.com.carlosrocha.converters;

import javax.swing.JOptionPane;
import br.com.carlosrocha.utils.APIUtils;

public class CurrencyConverter {

    public static double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        double rate = APIUtils.getConversionRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}

package br.com.carlosrocha.ui;

import javax.swing.JOptionPane;
import br.com.carlosrocha.converters.CurrencyConverter;
import br.com.carlosrocha.converters.TemperatureConverter;

public class Dialogs {

    public static void showMainMenu() {
        String[] options = {"Converter Moeda", "Converter Temperatura", "Sair"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "ToolsConverter Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                showCurrencyMenu();
                break;
            case 1:
                showTemperatureMenu();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    private static void showCurrencyMenu() {
        String[] options = {"Reais a Dólar", "Reais a Euro", "Reais a Libras Esterlinas", "Reais a Peso argentino", "Reais a Peso Chileno", "Voltar"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma conversão:", "Conversão de Moeda",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                convertCurrency("BRL", "USD");
                break;
            case 1:
                convertCurrency("BRL", "EUR");
                break;
            case 2:
                convertCurrency("BRL", "GBP");
                break;
            case 3:
                convertCurrency("BRL", "ARS");
                break;
            case 4:
                convertCurrency("BRL", "CLP");
                break;
            case 5:
                showMainMenu();
                break;
        }
    }

    private static void convertCurrency(String fromCurrency, String toCurrency) {
        String inputValue = JOptionPane.showInputDialog("Informe o valor em " + fromCurrency + ":");
        try {
            double value = Double.parseDouble(inputValue);
            double convertedValue = CurrencyConverter.convert(fromCurrency, toCurrency, value);
            JOptionPane.showMessageDialog(null, value + " " + fromCurrency + " = " + convertedValue + " " + toCurrency);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter moeda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void showTemperatureMenu() {
        String[] options = {"Celsius para Fahrenheit", "Fahrenheit para Celsius", "Voltar"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma conversão:", "Conversão de Temperatura",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                convertTemperature("Celsius", "Fahrenheit");
                break;
            case 1:
                convertTemperature("Fahrenheit", "Celsius");
                break;
            case 2:
                showMainMenu();
                break;
        }
    }

    private static void convertTemperature(String fromUnit, String toUnit) {
        String inputValue = JOptionPane.showInputDialog("Informe o valor em " + fromUnit + ":");
        try {
            double value = Double.parseDouble(inputValue);
            double convertedValue = TemperatureConverter.convert(fromUnit, toUnit, value);
            JOptionPane.showMessageDialog(null, value + "° " + fromUnit + " = " + convertedValue + "° " + toUnit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter temperatura: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}

package ch24.ex23_02;

import java.util.Currency;
import java.util.Locale;

public class CurryCode {
	public static void main(String[] args) {
		Currency[] currencies = {
				Currency.getInstance("CAD"), Currency.getInstance("ITL"), Currency.getInstance("CNY"),
				Currency.getInstance("USD"), Currency.getInstance("TWD"), Currency.getInstance("FRF"),
			};
		Locale[] locales = {
				Locale.CANADA, Locale.ITALY, Locale.CHINA,
				Locale.US, Locale.TAIWAN, Locale.FRANCE,
		};

		for (int i = 0; i < currencies.length; ++i) {
			for (int j = 0; j < locales.length; ++j) {
				System.out.println(currencies[i] + ": " +  currencies[i].getSymbol(locales[j]));
			}
		}
	}
}

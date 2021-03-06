/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.ibanvalidation;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import lt.dovile.ibanvalidationofaccountnumbers.data.CountryChar;
import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 * @version 1.0 for validating IBAN check
 */
public class CheckIbanValidation {

    private static final BigInteger BIG_INTEGER_97 = new BigInteger("97");
    private static final int EXPECTED_MOD_97 = 1;
    private static final int IBANNUMBER_MIN_SIZE = 15;
    private static final int IBANNUMBER_MAX_SIZE = 34;

    /**
     *
     * @param iban
     * @return true or false
     */
    public boolean isValid(Iban iban) {
        iban.setIban(iban.getIban().replaceAll("\\s", "").toUpperCase(Locale.ROOT));
        if (!checkIbanLenght(iban)) {
            return false;
        } else {
            BigInteger integerValue = stringConvertToInteger(iban);
            return integerValue.mod(BIG_INTEGER_97).intValue() == EXPECTED_MOD_97;
        }
    }

    /**
     *
     * @param iban
     * @return new BigInter with value of newIban
     */
    private BigInteger stringConvertToInteger(Iban iban) {
        Iban newIban = new Iban();
        newIban.setIban(iban.getIban().substring(4) + iban.getIban().substring(0, 4));
        return new BigInteger(replaceCountryCharactersWithDigits(newIban));
    }

    /**
     *
     * @param iban Make IBAN no full digits
     * @return digits but in String format
     */
    private String replaceCountryCharactersWithDigits(Iban iban) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iban.getIban().length(); i++) {
            sb.append(Character.digit(iban.getIban().charAt(i), 36));
        }
        return sb.toString();
    }

    /**
     *
     * @param iban Check IBAN length if its correct by some criteria
     * @return true or false
     */
    private boolean checkIbanLenght(Iban iban) {
        Map<String, Integer> CountryCodeDigitSum = new HashMap<>();

        for (String countryChars : new CountryChar().getCOUNTRY_CHARS()) {
            CountryCodeDigitSum.put(countryChars.substring(0, 2), Integer.parseInt(countryChars.substring(2)));
        }
        if (iban.getIban().length() > IBANNUMBER_MAX_SIZE
                || iban.getIban().length() < IBANNUMBER_MIN_SIZE
                || !iban.getIban().matches("[0-9A-Z]+")
                || CountryCodeDigitSum.getOrDefault(iban.getIban().substring(0, 2), 0) != iban.getIban().length()) {
            return false;
        }
        return true;
    }

}

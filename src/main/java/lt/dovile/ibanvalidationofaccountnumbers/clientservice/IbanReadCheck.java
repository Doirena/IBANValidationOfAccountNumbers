/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.clientservice;

import java.util.Scanner;
import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;
import lt.dovile.ibanvalidationofaccountnumbers.ibanvalidation.CheckIbanValidation;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class IbanReadCheck {

    /**
     * 
     * @param consoleText
     * Get String, after action number, next step
     * @return Client Iban number
     */
    public String getStringTxt(String consoleText) {
        String text = null;
        Scanner scant = new Scanner(System.in);
        System.out.println(consoleText);
        text = scant.nextLine();
        return text;
    }

    /**
     * Check IBAN validation
     */
    public void checkIbanValid() {
        Iban iban = new Iban(getStringTxt("Enter IBAN number"));
        System.out.printf("%s %s%n", iban, new CheckIbanValidation().isValid(iban) ? "true" : "false");
    }

}

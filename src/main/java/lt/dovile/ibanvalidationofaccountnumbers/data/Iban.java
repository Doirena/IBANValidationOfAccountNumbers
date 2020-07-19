/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.data;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 * @version 1.0
 */
public class Iban {
    
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Iban{" + "iban=" + iban + '}';
    }
    
}

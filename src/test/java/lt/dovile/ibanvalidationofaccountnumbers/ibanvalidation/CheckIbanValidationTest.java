/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.ibanvalidation;

import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class CheckIbanValidationTest {

    /**
     * Test of isValid method if its true
     */
    @Test
    public void test_iban_isValid_true() {
        CheckIbanValidation c = new CheckIbanValidation();
        assertTrue(c.isValid(new Iban("LT647044001231465456")));
    }

    /**
     * Test of isValid method if its false
     */
    @Test
    public void test_iban_isValid_false() {
        CheckIbanValidation c = new CheckIbanValidation();
        assertFalse(c.isValid(new Iban("CC051245445454552117989")));
    }
}

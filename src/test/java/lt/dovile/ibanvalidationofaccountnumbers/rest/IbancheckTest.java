/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.rest;

import java.util.ArrayList;
import java.util.List;
import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class IbancheckTest {

    /**
     * Test of getTrackInJSON method, of class Ibancheck.
     */
    @Test
    public void testGetTrackInJSON() {
        System.out.println("getTrackInJSON");
        Ibancheck instance = new Ibancheck();
        Iban result = instance.getTrackInJSON();
        assertEquals("LT647044001231465456", result.toString());
    }

    /**
     * Test of validIbanList method, of class Ibancheck.
     */
    @Test
    public void testValidIbanList() {
        System.out.println("validIbanList");
        Iban i1 = new Iban("AA051245445454552117989");
        Iban i2 = new Iban("LT647044001231465456");
        Iban i3 = new Iban("LT517044077788877777");
        Iban i4 = new Iban("LT227044077788877777");
        Iban i5 = new Iban("CC051245445454552117989");
        List<Iban> ibanList = new ArrayList<Iban>();
        ibanList.add(i1);
        ibanList.add(i2);
        ibanList.add(i3);
        ibanList.add(i4);
        ibanList.add(i5);
        Ibancheck instance = new Ibancheck();
        List<Iban> expResult = new ArrayList<Iban>();
        expResult.add(i2);
        expResult.add(i3);
        List<Iban> result = instance.validIbanList(ibanList);
        assertEquals(expResult, result);
    }

}

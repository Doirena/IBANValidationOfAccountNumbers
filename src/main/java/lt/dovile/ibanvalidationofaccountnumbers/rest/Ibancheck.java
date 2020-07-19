/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@Path("/ibanValidation")
public class Ibancheck {
    
    /**
     * 
     * @return iban
     */

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Iban getTrackInJSON() {
        Iban iban = new Iban("LT647044001231465456");
        return iban;

    }
   

}

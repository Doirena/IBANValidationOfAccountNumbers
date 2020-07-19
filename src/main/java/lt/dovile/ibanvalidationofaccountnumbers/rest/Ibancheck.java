/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lt.dovile.ibanvalidationofaccountnumbers.data.Iban;
import lt.dovile.ibanvalidationofaccountnumbers.ibanvalidation.CheckIbanValidation;

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

    /**
     *
     * @param ibanList
     * @return new ibanList which numbers is correct(true)
     */
    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public List<Iban> validIbanList(List<Iban> ibanList) {
        List<Iban> newIbanList = new ArrayList();
        for (int i = 0; i < ibanList.size(); i++) {
            if (new CheckIbanValidation().isValid(ibanList.get(i))) {
                newIbanList.add(ibanList.get(i));
            }
        }
        return newIbanList;
    }

}

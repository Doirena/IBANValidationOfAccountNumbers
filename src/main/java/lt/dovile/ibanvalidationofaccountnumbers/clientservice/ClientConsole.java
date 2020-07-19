/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.clientservice;

import java.util.Scanner;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class ClientConsole {
    /**
     * Print Client service  list
     * @return Client number of action 
     */
     private static String inputTxt() {
        Scanner clientChoose = new Scanner(System.in);
        System.out.println("ACTION");
        System.out.println("------------");
        System.out.println("1. Check separate IBAN validation");
        System.out.println("2. Insert file with list of IBAN numbers and check all validation ");
        System.out.println("3. Exit");
        System.out.println("------------");
        System.out.println("Choose number of action");

      String  chooseNumber = clientChoose.next();
        return chooseNumber;
    }
     
     /**
      * Main method, which execute all actions   
      * @throws ClassNotFoundException 
      */
    public static void chooseClientAction() throws ClassNotFoundException {
        String choose = inputTxt();
        String answer;
        System.out.println("You choose: " + choose);
        try{
        int chooseNumber = Integer.parseInt(choose);
                     
        switch (chooseNumber) {
            case 1:
                System.out.println("iban");
                break;
            case 2:
                System.out.println("File road");
                break;
            case 3:
                return;
            default:
                System.out.println("There isn't the number please choose one more time");
                chooseClientAction();
        }
        
        } catch(NumberFormatException e){
            System.out.println("Bad action number, try again");
            chooseClientAction();
        }
    }
    
}

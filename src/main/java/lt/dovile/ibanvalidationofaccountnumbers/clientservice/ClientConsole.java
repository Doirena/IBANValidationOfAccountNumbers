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

    private static final IbanReadCheck IBAN_READ_CHECK = new IbanReadCheck();

    /**
     * Print Client service list
     *
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

        String chooseNumber = clientChoose.next();
        return chooseNumber;
    }

    /**
     * Main method, which execute all actions
     *
     * @throws ClassNotFoundException, NumberFormatException
     */
    public static void chooseClientAction() throws ClassNotFoundException {
        String choose = inputTxt();
        System.out.println("You choose: " + choose);
        try {
            String nextAction;
            int chooseNumber = Integer.parseInt(choose);

            switch (chooseNumber) {
                case 1:
                    IBAN_READ_CHECK.checkIbanValid();
                    nextAction = IBAN_READ_CHECK.getStringTxt("One more action YES/NO");
                    if (nextAction.toUpperCase().equals("YES")) {
                        chooseClientAction();
                    }
                    System.out.println("Program is close");
                    break;
                case 2:
                    IBAN_READ_CHECK.readAndWriteFileDate();
                    nextAction = IBAN_READ_CHECK.getStringTxt("One more action YES/NO");
                    if (nextAction.toUpperCase().equals("YES")) {
                        chooseClientAction();
                    }
                    System.out.println("Program is close");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("There isn't the number please choose one more time");
                    chooseClientAction();
            }

        } catch (NumberFormatException e) {
            System.out.println("Bad action number, try again");
            chooseClientAction();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.ibanvalidationofaccountnumbers.clientservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
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
     * @param consoleText Get String, after action number, next step
     * @return Client Iban number
     */
    public String getStringTxt(String consoleText) {

        Scanner scant = new Scanner(System.in);
        System.out.println(consoleText);
        String text = scant.nextLine();
        return text;
    }

    /**
     * Check IBAN validation
     */
    public void checkIbanValid() {
        Iban iban = new Iban(getStringTxt("Enter IBAN number"));
        System.out.printf("%s %s%n", iban, new CheckIbanValidation().isValid(iban) ? "true" : "false");
    }

    /**
     * Read, check IBAN validation and write result in the file .out: 
     * 1.check if file exist and can we read 
     * 2.create write file with .out, check if is exist, if not create 
     * 3.read and write file use buffers 
     * 4.read file, check IBAN and write in .out file
     */
    public void readAndWriteFileDate() {
        String inputFilePath = getStringTxt("Please insert the path and file name for example c:\\folder1\\folder2\\test.txt ");
        //1. 
        File file = new File(inputFilePath);
        if (!file.exists() && !file.isDirectory() && !file.canRead()) {
            System.out.println("There is something wrong with Your url address or file isn't exist, please check " + inputFilePath);
            readAndWriteFileDate();
        } else {
            //2. 
            String outFilePath = inputFilePath.substring(0, (inputFilePath.indexOf("."))) + ".out";
            if (!new File(outFilePath).exists()) {
                try {
                    new File(outFilePath).createNewFile();
                } catch (IOException ex) {
                    //ignore
                }
            }
            //3. 
            try {
                FileInputStream fileInputStream = new FileInputStream(inputFilePath);
                Reader r = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferReader = new BufferedReader(r);

                FileOutputStream fileOutputStream = new FileOutputStream(outFilePath);
                Writer w = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bufferWriter = new BufferedWriter(w);
                //4. 
                String ibanNo;
                while ((ibanNo = bufferReader.readLine()) != null) {
                    if (new CheckIbanValidation().isValid(new Iban(ibanNo))) {
                        bufferWriter.write(ibanNo + " true");
                    } else {
                        bufferWriter.write(ibanNo + " false");
                    }
                    bufferWriter.newLine();
                }
                System.out.println("IBANS check is done. Results can be found in " + new File(outFilePath));
                bufferReader.close();
                r.close();
                fileInputStream.close();

                bufferWriter.close();
                w.close();
                fileOutputStream.close();
            } catch (IOException ex) {
                System.out.println("Exception when checking if file could be read with message:" + ex.getMessage());
            }

        }
    }

}

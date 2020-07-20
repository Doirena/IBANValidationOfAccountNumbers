# IBAN validation of account numbers
Simple project for IBAN validation of account numbers.

## Running application
- In console client insert IBAN number and get result true or false.
- In console client insert file path with list of IBAN numbers and get new file with .out extension consisting results of IBAN. 

## Server for check IBAN 
Client enters the list of IBAN and program posts IBAN numbers which are invalid. For test it uses Postman:
http://localhost:8080/IBANValidationOfAccountNumbers/ibanValidation/post

![1 postman](https://user-images.githubusercontent.com/56863735/87912192-9b143a80-ca75-11ea-8b28-3103561f9664.PNG)


## Dependencies:
```
dependencies {
  implementation 'javax:javaee-web-api'
  implementation 'junit:junit'
  implementation 'com.sun.jersey:jersey-server'
  implementation 'com.sun.jersey:jersey-json'
  implementation 'com.sun.jersey:jersey-client'
}
```

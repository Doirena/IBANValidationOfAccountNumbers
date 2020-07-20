# IBAN validation of account numbers
Simple project for IBAN validation of account numbers.

## Running application
- In console client insert IBAN No and get result true or false.
- In console client insert file path with list of IBAN No and get new file.out with result of IBAN. 

## Server for check IBAN 
Client enter the list of IBAN and program post IBAN which are invalid. For test it use Postman:
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

# Project Title

SOAP-TEST

## Description

This project is a simple SOAP web service implemented in Java using the Jakarta EE framework. The service provides a calculator with basic arithmetic operations.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Installing

1. Clone the repository
```bash
git clone https://github.com/sjoe97Github/SOAP-TEST.git
```
2. Navigate to the project directory
```bash
cd SOAP-TEST
```
3. Build the project with Maven
```bash
mvn clean install
```

## Usage

The project includes a `CalculatorWebServiceImpl` service with an `add` operation. This operation takes two integer parameters and returns their sum.

### Using CURL
You can make a SOAP request to the `add` operation like this:

```bash
curl -X POST http://localhost:8080/SOAP_TEST_war_exploded/calculatorWebService \
  -H "Content-Type: text/xml" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tns="http://services.soaptest.scottj.com/">
       <soapenv:Header/>
       <soapenv:Body>
          <tns:add>
             <arg0>10</arg0>
             <arg1>20</arg1>
          </tns:add>
       </soapenv:Body>
     </soapenv:Envelope>'
```

### Using IntelliJ built-in HTTP client
```angular2html
// SOAP Request to CalculatorWebService
POST http://localhost:8080/SOAP_TEST_war_exploded/calculatorWebService
Content-Type: text/xml
Accept: text/xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tns="http://services.soaptest.scottj.com/">
    <soapenv:Header/>
    <soapenv:Body>
        <tns:add>
            <arg0>10</arg0>
            <arg1>20</arg1>
        </tns:add>
    </soapenv:Body>
</soapenv:Envelope>
```
The Response should be:
```angular2html
<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addResponse xmlns:ns2="http://services.soaptest.scottj.com/">
            <return>30</return>
        </ns2:addResponse>
    </S:Body>
</S:Envelope>
```

Replace the URL, SOAP request body, and parameters with your actual values.

The project also includes a simple JSP page that displays "Hello World!" and a link to a servlet.

## Build Notes
### The artifact com.sun.xml.ws:jaxws-ri:4.0.2 was not available in the Maven Central Repository
Despite the fact that I could manually find the artifact in the Maven Central Repository, 
mvn was unable to find and add it to the project's dependencies using build commands such as:
```
mvn clean package
mvn clean package -U
```
Wiping the local maven repository didn't help either.
```angular2html
rm -rf ~/.m2/repository/com/sun/xml/ws
```
I also tried to force a find or download of the artifact using the following commands:
```angular2html
mvn searrch:search -DgroupId=com.sun.xml.ws -Dversion=4.0.2
mvn dependency:get -Dartifact=com.sun.xml.ws:jaxws-ri:4.0.2
```
Neither of these commands worked.  
Finally, I had to download the JAR file from the Maven Central Repository and force an install into my local repository:
(https://mvnrepository.com/artifact/com.sun.xml.ws/rt/4.0.2)
```angular2html
mvn install:install-file -DgroupId=com.sun.xml.ws -DartifactId=jaxws-ri -Dversion=4.0.2 -Dpackaging=jar -Dfile=/Users/scottj/Downloads/rt-4.0.2.jar
mvn clean package -U
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
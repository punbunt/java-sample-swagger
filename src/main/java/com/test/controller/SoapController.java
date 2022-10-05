package com.test.controller;

import com.test.model.MenuCreateRequest;
import com.test.model.MenuCreateResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


@RestController
public class SoapController {

    @PostMapping(value = "/api/v1/sample/soap/string", consumes =  {"*/*"})
    public ResponseEntity<String> convertObjectToString(@RequestBody String envelope) throws SOAPException, IOException {
        return new ResponseEntity<>(envelope, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/sample/soap", produces = MediaType.TEXT_XML_VALUE)
    @ResponseBody
    public ResponseEntity<String> convertStringToObject() throws SOAPException, IOException {

        //sample with string xml
        InputStream is = new ByteArrayInputStream(("<?xml version=\"1.0\"?>\n" +
                "<soap:Envelope\n" +
                "\txmlns:soap=\"http://www.w3.org/2003/05/soap-envelope/\"\n" +
                "soap:encodingStyle=\"http://www.w3.org/2003/05/soap-encoding\">\n" +
                "\t<soap:Body>\n" +
                "\t\t<m:GetPriceResponse\n" +
                "\t\t\txmlns:m=\"https://www.w3schools.com/prices\">\n" +
                "\t\t\t<m:Price>1.90</m:Price>\n" +
                "\t\t</m:GetPriceResponse>\n" +
                "\t</soap:Body>\n" +
                "</soap:Envelope>").getBytes());

        //create SOAP message
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null, is);

        //Revert Soap Message to String
        final StringWriter sw = new StringWriter();
        try {
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(soapMessage.getSOAPPart()),
                    new StreamResult(sw));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

        // Output as String xml with content-type xml
        return new ResponseEntity<>(sw.toString(), HttpStatus.OK);
    }
}

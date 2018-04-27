package parser;

import interfaces.Adapter;
import xess.jess.JessPlugin;
import xml.MachineLearning;
import xml.MeetCI;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Created by Rathinakumar on 7/12/2015.
 */
public class MeetCI_XMLParser {

    public static MeetCI parse(String xmlFile) throws JAXBException {
        File file = new File(xmlFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(MeetCI.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (MeetCI) jaxbUnmarshaller.unmarshal(file);
    }
}

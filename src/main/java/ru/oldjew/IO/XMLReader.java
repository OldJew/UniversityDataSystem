package ru.oldjew.IO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import ru.oldjew.models.XMLModel;

import java.io.File;
import java.util.logging.Logger;

public class XMLReader {
    private static final Logger logger = Logger.getLogger(XMLReader.class.getName());

    public static XMLModel readXMLModelFromFile(File file){
        logger.info("Reading xml started");
        if (!file.isFile()){
            logger.severe("File is invalid");
            return null;
        }

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(XMLModel.class);
        } catch (JAXBException e) {
            logger.severe("Class not found");
            logger.severe(e.getMessage());
        }

        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            logger.severe("Cannot create unmarshaller");
            logger.severe(e.getMessage());
        }

        XMLModel model= null;
        try {
            model = (XMLModel) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            logger.severe("Cannot unmarshall file");
            logger.severe(e.getMessage());
        }

        logger.info("Reading XML file ended");
        return model;
    }
}

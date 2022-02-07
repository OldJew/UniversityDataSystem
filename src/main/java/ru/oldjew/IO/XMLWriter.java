package ru.oldjew.IO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.oldjew.models.XMLModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class XMLWriter {
    private static final Logger logger = Logger.getLogger(XMLWriter.class.getName());

    public static void writeXML(XMLModel xmlModel){
        logger.info("Writing xml file started");
        try {
            Files.createDirectory(Paths.get("XMLs"));
            logger.info("directory created");
        } catch (IOException e) {
            logger.fine("directory already created");
        }
        File file = new File("XMLs/infoXml" + xmlModel.getDateOfCreation().getTime() + ".xml");

        try {
            JAXBContext context = JAXBContext.newInstance(XMLModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(xmlModel, file);
        } catch (JAXBException e) {
            logger.severe("Cannot marshall file");
            logger.severe(e.getMessage());
        }

        logger.info("Writing XML file ended.");
    }
}

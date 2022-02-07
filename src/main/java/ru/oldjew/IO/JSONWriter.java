package ru.oldjew.IO;

import ru.oldjew.models.XMLModel;
import ru.oldjew.utils.JsonUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONWriter {
    private static final Logger logger = Logger.getLogger(JSONWriter.class.getName());

    public static void writeJsonFiles(XMLModel model){
        logger.info("Starting write json files");

        try {
            Files.createDirectory(Paths.get("JSONs"));
            logger.info("Created JSONs directory");
        } catch (IOException e) {
            logger.fine("Directory already created");
        }
        writeStudentsJson(model);
        writeUniversitiesJson(model);
        writeStatisticJson(model);

        logger.info("Json files creating finished");

    }

    public static void writeStudentsJson(XMLModel model){
        String studentsJson = JsonUtils.writeListToJSON(model.getStudentList());
        try (FileOutputStream fos = new FileOutputStream("JSONs/students" + model.getDateOfCreation().getTime()
         + ".json")){
            fos.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Cannot write students", e);
        }
    }

    public static void writeUniversitiesJson(XMLModel model){
        String universitiesJson = JsonUtils.writeListToJSON(model.getUniversitiesList());
        try (FileOutputStream fos = new FileOutputStream("JSONs/universities" + model.getDateOfCreation().getTime()
                + ".json")){
            fos.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Cannot write universities", e);
        }
    }

    public static void writeStatisticJson(XMLModel model){
        String statisticJson = JsonUtils.writeListToJSON(model.getStatisticsList());
        try (FileOutputStream fos = new FileOutputStream("JSONs/statistic" + model.getDateOfCreation().getTime()
                + ".json")){
            fos.write(statisticJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Cannot write statistic", e);
        }
    }
}

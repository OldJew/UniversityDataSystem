package ru.oldjew.IO;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.oldjew.enums.StudyProfile;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class XLSXReader {
    private static final Logger logger = Logger.getLogger(XLSXReader.class.getName());
    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private XSSFSheet studentSheet;
    private XSSFSheet universitySheet;

    private XLSXReader() {

    }


    public static List<Student> readXlsStudent(String filepath) {
        logger.info("Reader for Students started");
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workbook = null;
        XSSFSheet studentSheet = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filepath));
            studentSheet = workbook.getSheet("Студенты");
        } catch (IOException e) {
            logger.severe("File not found. Check filepath");
            return null;
        }
        Iterator<Row> rowIterator = studentSheet.iterator();
        //skip headers row
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = new Student.Builder(
                    row.getCell(1).getStringCellValue(),
                    row.getCell(0).getStringCellValue(),
                    (int) row.getCell(2).getNumericCellValue()).setAvgExamScore((float) row.getCell(3).getNumericCellValue())
                    .build();
            students.add(student);
        }
        logger.info("Reader for Students finished");
        return students;
    }

    public static List<University> readXlsUniversities(String filepath) {
        logger.info("Reader for Universities started");
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workbook = null;
        XSSFSheet universitySheet = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filepath));
            universitySheet = workbook.getSheet("Университеты");
        } catch (IOException e) {
            logger.severe("File not found. Check filepath");
            return null;
        }
        Iterator<Row> rowIterator = universitySheet.iterator();
        //skip headers row
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            University university = new University.Builder(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    (int) row.getCell(3).getNumericCellValue()
            ).setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()))
                    .setShortName(row.getCell(2).getStringCellValue()).build();
            universities.add(university);
        }
        logger.info("Reader for Universities finished");
        return universities;
    }
}

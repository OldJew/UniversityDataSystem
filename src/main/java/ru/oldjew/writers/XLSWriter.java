package ru.oldjew.writers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.oldjew.models.Statistics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XLSWriter {

    public static void generateTable(List<Statistics> statistics, String path) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistic");
        //Creating sheet style

        CreationHelper creationHelper = workbook.getCreationHelper();
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        headerCellStyle.setFont(font);

        //Creating headers rows
        Row headersRow = sheet.createRow(0);
        Cell studyProfileCell = headersRow.createCell(0);
        createHeaderCell(studyProfileCell, "Профиль обучения", headerCellStyle);
        Cell avgExamScoreCell = headersRow.createCell(1);
        createHeaderCell(avgExamScoreCell, "Средний балл за экзамен", headerCellStyle);
        Cell studentsPerProfileCell = headersRow.createCell(2);
        createHeaderCell(studentsPerProfileCell, "Студентов по профилю", headerCellStyle);
        Cell universitiesPerProfileCell = headersRow.createCell(3);
        createHeaderCell(universitiesPerProfileCell, "Университетов по профилю", headerCellStyle);
        Cell universityNameCell = headersRow.createCell(4);
        createHeaderCell(universityNameCell, "Имя университета", headerCellStyle);

        int rowCounter = 1;
        for (Statistics stat : statistics) {
            Row dataRow = sheet.createRow(rowCounter);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(stat.getStudyProfile().getProfileName());
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(stat.getAvgExamScore());
            Cell studentsPerProfCell = dataRow.createCell(2);
            studentsPerProfCell.setCellValue(stat.getStudentsPerProfile());
            Cell universitiesPerProfCell = dataRow.createCell(3);
            universitiesPerProfCell.setCellValue(stat.getUniversitiesPerProfile());
            Cell nameCell = dataRow.createCell(4);
            nameCell.setCellValue(stat.getUniversityName());
            rowCounter++;
        }

        try (FileOutputStream fos = new FileOutputStream(path)) {
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

    private static void createHeaderCell(Cell cell, String cellValue, CellStyle cellStyle) {
        cell.setCellStyle(cellStyle);
        cell.setCellValue(cellValue);
    }
}

package ru.oldjew.utils;

import ru.oldjew.readers.XLSXReader;

public class TestDriveUtil {

    public static void main(String[] args) {
        System.out.println(XLSXReader.readXlsStudent("src/main/resources/universityInfo.xlsx"));
        System.out.println(XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx"));
    }
}

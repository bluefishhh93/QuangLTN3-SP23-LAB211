/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author xuant
 */
public class ZipFileSystem {

    Validation validation = new Validation();

    public ZipFileSystem() {
    }

    public void compressTo() {
        Scanner sc = new Scanner(System.in);

        String pathSrc;
        String fileZipName;
        String pathCompress;
        System.out.println("---------- Compression --------");
        System.out.println("Enter folder");
        pathSrc = validation.inputFilePath();
        System.out.println("Enter name: ");
        fileZipName = sc.nextLine();
        System.out.println("Enter destination folder: ");
        pathCompress = validation.inputFilePath();
        compressTo(pathSrc, fileZipName, pathCompress);
    }

    public boolean compressTo(String pathSrc, String fileZipName, String pathCompress) {
          File folder = new File(pathSrc);
    if (!folder.exists()) {
        System.err.println("This folder is not exist");
        System.out.println("Compress failed");
        return false;
    }

    File zipFile = new File(pathCompress + File.separator + fileZipName + ".zip");

    try {
        FileOutputStream fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);

        byte[] bytes = new byte[1024];
        List<File> fileList = new ArrayList<>();
        getAllFiles(folder, fileList);
        System.out.println("RESULT");
        for (File file : fileList) {
            System.out.println(file.getName());
            FileInputStream fis = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(file.getPath()));
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
            fis.close();
        }

        zos.closeEntry();
        zos.close();
        fos.close();
        System.out.println("Compression successful");
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

public void getAllFiles(File folder, List<File> fileList) {
    File[] files = folder.listFiles();
    for (File file : files) {
        if (file.isDirectory()) {
            getAllFiles(file, fileList);
        } else {
            fileList.add(file);
        }
    }    }

  
    public void extracTo() {
        System.out.println("Enter zip file path:");
        String pathZipFile = validation.inputFilePath();
        System.out.println("Enter extract path: ");
        String pathExtract = validation.inputFilePath();
        extractTo(pathZipFile, pathExtract);
    }

    public boolean extractTo(String pathZipFile, String pathExtract) {

        File zip = new File(pathZipFile);
        if (!zip.exists()) {
            System.err.println("This file zip is not exist");
            System.out.println("Extract failed");
            return false;
        }

        File folder = new File(pathExtract);
        if (!folder.exists()) {
            folder.mkdirs();

        }
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZipFile));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                File newFile = new File(pathExtract + File.separator + zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    new File(newFile.getParent()).mkdirs();

                    FileOutputStream fos = new FileOutputStream(newFile);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = zis.read(bytes)) >= 0) {
                        fos.write(bytes, 0, length);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();
            System.out.println("---------RESULT-------------");
            listFilesForFolder(folder);
            System.out.println("Succesfully");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //ham in ra cac file da extract
    public void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

}

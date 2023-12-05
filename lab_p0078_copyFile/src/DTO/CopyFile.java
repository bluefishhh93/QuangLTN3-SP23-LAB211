/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class CopyFile {

    private static final String FILE_NAME = "config.properties";
    File porpertiesFile;
    FileInputStream input;
    private Properties prop;
    Validation validation;

    public CopyFile() {
        prop = new Properties();
        validation = new Validation();
    }

    public void readFileConfig() {
        Config config = new Config();
        try {
            readFileConfig(config);
        } catch (ExceptionHandle ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Read file config.proprties
    public Config readFileConfig(Config config) throws ExceptionHandle {

        //check if the file is exist
        porpertiesFile = new File(FILE_NAME);
        if (porpertiesFile.exists()) {
            try {
                input = new FileInputStream(FILE_NAME);
                prop.load(input);
                config.setCopyFolder(prop.getProperty("COPY_FOLDER"));
                config.setDataType(prop.getProperty("DATA_TYPE"));
                config.setPath(prop.getProperty("PATH"));
                checkConfig(config);
            } catch (IOException ex) {
                throw new ExceptionHandle("File configure is not found!");
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        throw new ExceptionHandle("Error closing config file!");
                    }
                }
            }
        } else {
            System.out.println("File configure is not found!");
            createFileConfig(config);
            readFileConfig(config);
        }
        return config;
    }

    public void createFileConfig() {
        Config config = new Config();
        String copyFolder = validation.getNonBlankStr("Copy folder :");
        String dataType = validation.getNonBlankStr("Copy folder :");
        String path = validation.getNonBlankStr("Copy folder: ");
        try {
            createFileConfig(config);
        } catch (ExceptionHandle ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Create file config if not existed
    public void createFileConfig(Config config) throws ExceptionHandle {
        System.out.println("-------------Input Configure file-----------");
        prop = new Properties();
        prop.setProperty("COPY_FOLDER", config.getCopyFolder());
        prop.setProperty("DATA_TYPE", config.getDataType());
        prop.setProperty("PATH", config.getPath());
        OutputStream output = null;
        try {
            output = new FileOutputStream(FILE_NAME);
            prop.store(output, null);
        } catch (IOException e) {
            throw new ExceptionHandle("Error creating config file");
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    throw new ExceptionHandle("Error closing config file");
                }
            }
        }

    }

    // Verify file config
    public void checkConfig(Config config) throws ExceptionHandle {
        //list of exceptions
        List<String> errors = new ArrayList<>();
        FileInputStream input = null;
        if (config.getCopyFolder() == null || config.getCopyFolder().isEmpty()) {
            errors.add("Folder source is not input");
        } else {
            File copyFolder = new File(config.getCopyFolder());
            if (!copyFolder.exists() || !copyFolder.isDirectory()) {
                errors.add("Can't find folder source");
            }
        }
        if (config.getDataType() == null || config.getDataType().isEmpty()) {
            errors.add("Data type is not input");
        }
        if (config.getPath() == null || config.getPath().isEmpty()) {
            errors.add("Folder destination is not input");
        } else {
            Path path = Paths.get(config.getPath());
            if (!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    errors.add("Can't make folder Destination");
                }
            }
        }

        if (!errors.isEmpty()) {
            for (String x : errors) {
                System.out.println(x);
               
            }
             throw new ExceptionHandle("Shutting down");
        }
        copyFile(config);

    }

    // Perform copy task if file config is valid
    public List<String> copyFile(Config config) throws ExceptionHandle {
        List<String> copiedFiles = new ArrayList<>();
        File copyFolder = new File(config.getCopyFolder());
        String dataType = config.getDataType().toLowerCase();
        String[] dataTypes = dataType.split(",");
        for (int i = 0; i < dataTypes.length; i++) {
            dataTypes[i] = dataTypes[i].replace("*", "");
        }
        File[] filesToCopy = copyFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(dataTypes[0]) || name.endsWith(dataTypes[1]);
            }
        });

        if (filesToCopy != null) {
            for (File file : filesToCopy) {
                try {
                    Files.copy(file.toPath(), Paths.get(config.getPath(), file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    copiedFiles.add(file.getName());
                } catch (IOException e) {
                    throw new ExceptionHandle("Error copying file: " + file.getName());
                }
            }
        }
        System.out.println("Copy is finished");
        return copiedFiles;
    }
}

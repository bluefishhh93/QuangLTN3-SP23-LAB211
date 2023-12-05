/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class PathAnalysis {
    
    public String checkInputString() {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("Please input Path: ");
        String result = sc.nextLine().trim();
        if (result.length() == 0) {
            System.err.println("Not empty.");
        } else if (!result.matches("^[a-zA-Z]:\\\\(?:[^\\\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\\\/:*?\"<>|\\r\\n]*$")) {
            System.err.println("Invalid path format. Please enter a valid file path.");
        } else {
            return result;
        }
    }
}

    public void showResult(String path){
        System.out.println("Disk: "+getDisk(path));
        System.out.println("Extension: "+getExtension(path));
        System.out.println("File name: "+getFileName(path));
        System.out.println("Path: "+getPath(path));
    }
    
    public String getPath(String path){
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk+1, toNameFile);
    }
    
    public String getFileName(String path){
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom+1, positionTo);
    }
    
    public String getExtension(String path){
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot+1, path.length());
    }
    
    public String getDisk(String path){
        return path.substring(0, 3);
    }
    
    
    public String[] getFolders(String path){
    int positionColon = path.indexOf("\\");
    int positionDot = path.lastIndexOf("\\");
    path = path.substring(positionColon, positionDot);
    String[] splitFile = path.split("\\\\");
    return splitFile;
    }
}

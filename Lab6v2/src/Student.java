/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Student {
    String name="",code="";
    int mark=0;

    public Student() {
    }
    
    public Student(String code, String name, int mark){
        this.code=code.toUpperCase();
        this.name=name.toUpperCase();
        this.mark = (mark > 0 && mark <= 10) ? mark : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.toUpperCase().trim();
        if(name.length()>0)
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if( 0 <= mark && mark <= 10 )
            this.mark=mark;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", code=" + code + ", mark=" + mark + '}';
    }
    
    
}

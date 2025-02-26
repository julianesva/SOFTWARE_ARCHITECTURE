package model;

public class Student {

    private String name;
    private String identificator;

    public Student(String name, String identificator){
        this.name = name;
        this.identificator = identificator;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void setId (String identificator){
        this.identificator = identificator;
    }

    public String getId (){
        return identificator;
    }
    
}

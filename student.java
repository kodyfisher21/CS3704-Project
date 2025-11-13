//store name
//store class info
//match the student to their classes
public class student {
    private String name;
    private String classInfo;   

    public student(String name, String classInfo) {
        this.name = name;
        this.classInfo = classInfo;
    }   

    public String getName() {
        return name;
    }
    public String getClassInfo() {
        return classInfo;
    }
}

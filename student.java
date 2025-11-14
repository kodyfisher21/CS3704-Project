//store name
//store class info
//match the student to their classes
public class student {
    private String name;
    private String classInfo;   
    private String time;

    public student(String name, String classInfo, String time) {
        this.name = name;
        this.classInfo = classInfo;
        this.time = time;
    }   

    public String getName() {
        return name;
    }
    public String getClassInfo() {
        return classInfo;
    }

    public String getTime(){
        return time;
    }

    @Override
    public String toString() {
        return name+ "(" + classInfor+ ","+time+")";
}

public class class_schedule {
    private String course_name;
    private String course_time;

    public class_schedule(String course_name, String course_time){
        this.course_name = course_name;
        this.course_time = course_time;
    }

    public String getCourseName(){
        return course_name;
    }

    public String getCourse_time()
    {
        return course_time;
    }
}

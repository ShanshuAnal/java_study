import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2024/12/4 15:00
 */
public class StudentService {
    public static List<Student> getStudent() {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student("zhangsan", 11, "男");
        Student s2 = new Student("lisi", 21, "男");
        Student s3 = new Student("wangwu", 13, "女");
        Student s4 = new Student("zhaoliu", 13, "男");
        Student s5 = new Student("songqu", 51, "女");
        Student s6 = new Student("songqu", 51, "女");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);

        return studentList;
    }
}

package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String classNo;
    private String name;
    private String enName;
    private Integer age;
    private String sex;
    private Integer totalScore;
}

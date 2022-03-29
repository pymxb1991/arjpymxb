package lambda;

import entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLamdTest {
    public static void main(String[] args) {
        Student a = new Student("1班", "张三", "zs", 18, "男", 299);
        Student b = new Student("1班", "王小明", "xm", 17, "男", 278);
        Student c = new Student("3班", "周大红", "", 18, "女", 255);
        Student d = new Student("1班", "刘老六", "lll", 19, "男", 300);
        Student e = new Student("2班", "李小华", "", 18, "女", 281);
        Student f = new Student("4班", "陈花花", "", 17, "女", 281);
        Student g = new Student("2班", "王老五", "wlw", 20, "男", 229);
        Student h = new Student("3班", "李四", "ls", 16, "男", 267);
        Student i = new Student("2班", "林大庄", "", 17, "男", 297);

        List<Student> list = Arrays.asList(a, b, c, d, e, f, g, h, i);

        //（1）取出所有学生姓名  map()
        List<String> collect = list.stream().map(stu -> (stu.getName())).collect(Collectors.toList());
        List<String> collect2 = list.stream().map(Student::getName).collect(Collectors.toList());
        for (String str: collect2) {
            System.out.println(str);
        }
        //（2）取出年龄大于18的学生 filter()
        List<Student> collectAge = list.stream().filter(student -> student.getAge() > 18).collect(Collectors.toList());
        collectAge.forEach(System.out::println);
        //（3）获取姓王 的学生信息 filter()
        List<Student> collectNames = list.stream().filter(student -> student.getName().startsWith("王")).collect(Collectors.toList());
        collectNames.forEach(System.out::println);
        //（4）取出所有不重复的学生分数列表  distinct()
        List<Integer> collectTotalScores = list.stream().map(Student::getTotalScore).distinct().collect(Collectors.toList());
        collectTotalScores.forEach(System.out::println);
        //（5）所有学生中是否所有人分数都在250分以上（全匹配）
        boolean b1 = list.stream().map(Student::getTotalScore).allMatch(s -> s > 250);
        System.out.println("所有学生中是否所有人分数都在250分以上:"+ b1);
        //（6）所有学生中是否存在年龄大于20岁的（任意匹配） anyMatch()
        boolean b2 = list.stream().map(Student::getAge).anyMatch(n -> n > 20);
        System.out.println("所有学生中是否存在年龄大于20岁的:"+ b2);
        //（7）所有学生中是否所有年龄都不大于20岁（都不匹配）noneMatch()
        boolean b3 = list.stream().map(Student::getAge).noneMatch(n -> n > 20);
        System.out.println("所有学生中是否所有年龄都不大于20岁:"+ b2);
        //（8）按照学生年龄排序（默认升序)  sorted()
        List<Student> studentList = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        studentList.forEach(System.out::println);
        //（9）按照学生年龄降序排序（只要加上.reversed()即可）  reversed()
        List<Student> studentList1 = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        studentList1.forEach(System.out::println);
        //（10） 多条件排序：根据学生年龄降序排序后并按照分数升序排序
        List<Student> collectAgeSorts = list.stream().sorted(Comparator.comparingInt(Student::getAge).reversed().thenComparingInt(Student::getTotalScore)).collect(Collectors.toList());
        collectTotalScores.forEach(System.out::println);
        //（11）根据学生总分数降序，并获取第2页数据，每页3条数据（初始页为1）
        int pageNo = 2;//假设获取第二页数据
        int pageSize = 3;//每页3调数据
        int skip = (pageNo - 1) * pageSize;//初始页从1开始，计算从第几条开始
        List<Student> stuPage = list.stream().sorted(Comparator.comparingInt(Student::getTotalScore).reversed()).skip(skip).limit(pageSize).collect(Collectors.toList());
        stuPage.forEach(System.out::println);
        //（12）根据班级分组
        Map<String, List<Student>> classStus = list.stream().collect(Collectors.groupingBy(Student::getClassNo));
        classStus.forEach((k,v)->{
            System.out.println("k:"+k+",v:"+v.toString());
        });
        //（13） 根据班级分组，组内根据分组降序排序
        Map<String, List<Student>> classSores = list.stream().sorted(Comparator.comparingInt(Student::getTotalScore).reversed())
                .collect(Collectors.groupingBy(Student::getClassNo));
        classSores.forEach((k,v)->{
            System.out.println("k:"+k+",v:"+v.toString());
        });
        //（14）多条件分组（根据班级分组后再对班级内男女生进行分组）
        Map<String, Map<String, List<Student>>> map = list.stream().collect(Collectors.groupingBy(Student::getClassNo, Collectors.groupingBy(Student::getSex)));
        map.forEach((k,v)->{
            System.out.println("k:"+k+",v:"+v.toString());
        });
        //（15）分别求学生分数中的最小值，最大值，所有总分和，平均值
        int min = list.stream().mapToInt(Student::getTotalScore).min().getAsInt();
        //最大值
        int max = list.stream().mapToInt(Student::getTotalScore).max().getAsInt();
        //总分数
        int sum = list.stream().mapToInt(Student::getTotalScore).sum();
        //计量
        long count = list.stream().mapToInt(Student::getTotalScore).count();
        //平均值
        double average = list.stream().mapToInt(Student::getTotalScore).average().getAsDouble();
        //平均值更保险方式：增加orElse() 默认值，防止列表为空
        double average1 = list.stream().mapToInt(Student::getTotalScore).average().orElse(0.0);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("sum: " + sum);
        System.out.println("count: " + count);
        System.out.println("average: " + average);
        System.out.println("average1: " + average1);
        System.out.println("----------------------使用统计收集器-----------------------------");
        // 使用统计收集器
        IntSummaryStatistics statistics = list.stream().mapToInt(Student::getTotalScore).summaryStatistics();
        System.out.println("max: " + statistics.getMax());
        System.out.println("min: " + statistics.getMin());
        System.out.println("sum: " + statistics.getSum());
        System.out.println("count: " + statistics.getCount());
        System.out.println("average: " + statistics.getAverage());

        System.out.println("----------------------字符串拼接-----------------------------");
        //字符串拼接
        String strNames = list.stream().map(Student::getEnName).collect(Collectors.joining(","));
        System.out.println(strNames);

        //集合转换
        //list转set
        System.out.println("----------------------list转set-----------------------------");
        Set<String> classNo = list.stream().map(Student::getClassNo).collect(Collectors.toSet());
        classNo.forEach(System.out::println);
        System.out.println("----------------------list 转map-----------------------------");
        //list 转map(姓名->学生信息)
        Map<String, Student> studentMap = list.stream().collect(Collectors.toMap(Student::getName, u -> u));
        studentMap.forEach((k,v)->{
            System.out.println("k:"+k+",v:"+v);
        });


    }
}

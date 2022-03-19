package arrayList;

public class Demo {

    private String id;

    private String name;

    private String age;

    private String rowIndex;

    public Demo() {
    }

    public Demo(String id, String name, String age, String rowIndex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rowIndex = rowIndex;
    }



    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", rowIndex='" + rowIndex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }
}


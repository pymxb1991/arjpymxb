package entity;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        /*
          注意，当接收参数时，是用Object obj,来接收，而我们传递的是一个person :-->> 此处隐含着一个多态
              Object obj = new person();
              由于我们比较是比较内容，所以需要用到person 的成员变量，
              而多态的一个弊端就是，当使用多态时，不能使用子类的成员变量，及方法
              所以我们可以选择向下转型，强转为person 之后便可以使用进行比较
         */
        /*Person person = (Person)obj;
        boolean b =  person.getName().equals(this.name) && person.getAge() == this.age;
        return super.equals(obj);
*/
        /**
         * 使用以上办法即可为Person 类来成功比对；
         * 但是，如果参数是一个List 时，又该如何来比较呢；
         *   我们可以应用 instanceof 来比较对象引用是否相等，然后再来使用对象进行比较
         *
         * 上面代码我们可以改造为：如下
         *  增加一个判断，转换一类型
         */
        /*if(obj instanceof  Person){
            Person person = (Person)obj;
            boolean b =  person.getName().equals(this.name) && person.getAge() == this.age;
            return super.equals(obj);
        }
        return  false;*/
        /**
         * 再进行优化 ！
         */
        //增加一个判断,传递的参数obj如果是this本身,直接返回true,提高程序的效率
        if(obj==this){
            return true;
        }

        //增加一个判断,传递的参数obj如果是null,直接返回false,提高程序的效率
        if(obj==null){
            return false;
        }
        if(obj instanceof  Person){
            Person person = (Person)obj;
            boolean b =  person.getName().equals(this.name) && person.getAge() == this.age;
            return super.equals(obj);
        }
        return  false;
    }


    /*
        Object类的equals方法,默认比较的是两个对象的地址值,没有意义
        所以我们要重写equals方法,比较两个对象的属性(name,age)
        问题:
            隐含着一个多态
            多态的弊端:无法使用子类特有的内容(属性和方法)
            Object obj = p2 = new Person("古力娜扎",19);
            解决:可以使用向下转型(强转)把obj类型转换为Person
     */
    /*@Override
    public boolean equals(Object obj) {


        //增加一个判断,防止类型转换一次ClassCastException
        if(obj instanceof Person){
            //使用向下转型,把obj转换为Person类型
            Person p = (Person)obj;
            //比较两个对象的属性,一个对象是this(p1),一个对象是p(obj->p2)
            boolean b = this.name.equals(p.name) && this.age==p.age;
            return b;
        }
        //不是Person类型直接返回false
        return false;
    }*/
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass() 使用反射技术,判断o是否是Person类型  等效于 obj instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

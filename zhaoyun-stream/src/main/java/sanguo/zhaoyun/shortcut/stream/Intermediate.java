package sanguo.zhaoyun.shortcut.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intermediate {
    //filter：过滤
    public static void filter() {
        //返回的流中只包含满足断言(predicate)的数据；
        Stream.of(1, 2, 3, 4, 5).filter(e -> e == 1).forEach(System.out::println);
    }

    //distinct:去重
    public static void distinct() {
        // 保证输出的流中包含唯一的元素，它是通过Object.equals(Object)来检查是否包含相同的元素；
        Stream.of(1, 2, 1, 2, 3).distinct().forEach(System.out::println); //1,2,3
    }

    //sorted:排序
    public static void sorted() {
        //顺序
        Stream.of(1, 2, 3, 2, 1).sorted().forEach(System.out::println);
        //逆序
        Stream.of(1, 2, 3, 2, 1).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //自定义顺序
        Stream.of(new Student().setAge(1), new Student().setAge(2), new Student().setAge(3))
                .sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);

        //自定义逆序
        Stream.of(new Student().setAge(1), new Student().setAge(2), new Student().setAge(3))
                .sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
    }

    //limit:指定数量的元素的流。
    public static void limit() {
        Stream.of(1, 2, 3, 4, 5).limit(2).forEach(System.out::println); // 1,2
    }

    //skip:忽略
    public static void skip() {
        //返回丢弃了前n个元素的流，如果流中的元素小于或者等于n，则返回空的流；
        Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println); //3,4,5
    }

    //map:映射

    public static void map() {
        //将流中的元素映射成另外的值，新的值类型可以和原来的元素的类型不同
        Stream.of(1, 2, 3, 4, 5).map(e -> e + 1).forEach(System.out::println);//2,3,4,5,6
        Stream.of(1, 2, 3, 4, 5).map(e -> new Student().setAge(e)).forEach(System.out::println);
        Stream.of(new Student().setName("z"), new Student().setName("c"), new Student().setName("z"))
                .map(Student::getName).collect(Collectors.toList());//.toArray();
    }

    public static class Student {
        private int age;
        private String name;

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        Student setAge(int age) {
            this.age = age;
            return this;
        }

        int getAge() {
            return this.age;
        }
    }
}

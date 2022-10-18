package sanguo.zhaoyun.shortcut.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Intermediate {
    //filter：返回的流中只包含满足断言(predicate)的数据；
    public static void filter() {
        Stream.of(1, 2, 3, 4, 5).filter(e -> e == 1).forEach(System.out::println);
    }

    //保证输出的流中包含唯一的元素，它是通过Object.equals(Object)来检查是否包含相同的元素；
    public static void distinct() {
        Stream.of(1, 2, 1, 2, 3).distinct().forEach(System.out::println); //1,2,3
    }

    //排序
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

    //返回丢弃了前n个元素的流，如果流中的元素小于或者等于n，则返回空的流；
    public static void skip() {
        Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println); //3,4,5
    }

    //将流中的元素映射成另外的值，新的值类型可以和原来的元素的类型不同
    public static void map() {
        Stream.of(1, 2, 3, 4, 5).map(e -> e + 1).forEach(System.out::println);//2,3,4,5,6
        Stream.of(1, 2, 3, 4, 5).map(e -> new Student().setAge(e)).forEach(System.out::println);
    }

    public static class Student {
        private int age;

        Student setAge(int age) {
            this.age = age;
            return this;
        }

        int getAge() {
            return this.age;
        }
    }
}

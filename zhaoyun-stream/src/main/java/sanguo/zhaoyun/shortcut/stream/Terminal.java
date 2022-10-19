package sanguo.zhaoyun.shortcut.stream;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Terminal {
    //遍历流的每一个元素，执行指定的 action；
    public static void forEach() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::print); //在并行流(parallel stream)中，forEach()方法可能不一定遵循顺序
        Stream.of(4, 2, 1, 3, 5).forEachOrdered(System.out::print);//在并行流(parallel stream)中，forEachOrdered()将始终遵循顺序。
    }

    //计算
    public static void calculation() {
        System.out.println(IntStream.of(1, 2, 3, 4, 5).min().getAsInt());
        System.out.println(IntStream.of(1, 2, 3, 4, 5).max().getAsInt());
        System.out.println(Stream.of(1,2,3,4,5).count());
    }

    //匹配
    public static void match() {
        //anyMatch:只有在任意一个元素满足断言时就返回 true，否则 flase；
        System.out.println(Stream.of(1,2,3,4,5).anyMatch(i -> i > 0)); // true
        //noneMatch:只有在所有的元素都不满足断言时才返回 true，否则 false；
        System.out.println(Stream.of(1,2,3,4,5).noneMatch(i -> i > 0)); //false
        //allMatch：只有在所有的元素都满足断言时才返回 true，否则 false，流为空时总是返回 true；
        System.out.println(Stream.of(1,2,3,4,5).allMatch(i -> i > 0)); // true
    }

    //查找
    public static void find() {
        //findAny:返回任意一个元素，如果流为空，返回空的 Optional。
        System.out.println(Stream.of(1,2,3,4,5).findAny());
        //findFirst：返回第一个元素，如果流为空，返回空的 Optional。
        System.out.println(Stream.of(1,2,3,4,5).findFirst());
    }
}

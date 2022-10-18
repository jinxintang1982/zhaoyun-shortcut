package sanguo.zhaoyun.shortcut.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert {
    public static void create(){
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

    public static void convert(){
        Stream stream = Stream.of("a", "b", "c");

        // 1. to Array
        //String[] strArray = (String[]) stream.toArray(String[]::new);

        // 2. to Collection
        //List<String> list = (List<String>) stream.collect(Collectors.toList());
        //System.out.println("list = " + list);

        //3. to Set
        //Set<String> set = (Set<String>) stream.collect(Collectors.toSet());
        //System.out.println("set = " + set);

        // 4 to String
        //String str = stream.collect(Collectors.joining()).toString();
        //System.out.println("str = " + set);
    }
}

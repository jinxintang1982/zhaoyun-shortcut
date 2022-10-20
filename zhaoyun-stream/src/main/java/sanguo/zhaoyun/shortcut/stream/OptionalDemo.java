package sanguo.zhaoyun.shortcut.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void ifPresent() {
        //如果user不为null,打印其姓名
        User.findUserById(0).stream().findAny().ifPresent(u -> System.out.println("Username is: " + u.getUserName()));
    }

    public static void isPresent() {
        System.out.println(User.findUserById(0).stream().findAny().isPresent());//true
    }

    public static void orElse() {
        //如果获取对象为空，则执行orElse
        User user1 = User.findUserById(0).stream().findAny().orElse(null);
        User user2 = User.findUserById(1).stream().findAny().orElse(new User());
    }

    public static void orElseThrow() {
        //如果获取对象为空，则抛出异常
        User user = User.findUserById(0).stream().findAny()
                .orElseThrow(() -> new RuntimeException("user 对象为空"));
        System.out.println("user name = " + user.getUserName());
    }




}

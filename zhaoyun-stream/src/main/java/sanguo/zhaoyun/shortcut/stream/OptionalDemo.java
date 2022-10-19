package sanguo.zhaoyun.shortcut.stream;

import java.util.Optional;

public class OptionalDemo {

    public static void ifPresent() {
        Optional<User> user = Optional.ofNullable(getUserById(1));
        //如果user不为null,打印其姓名
        user.ifPresent(u -> System.out.println("Username is: " + u.userName));
    }

    public static void isPresent() {
        Optional<User> user = Optional.ofNullable(getUserById(1));
        System.out.println(user.isPresent());//true
    }

    public static void orElse() {
        //如果获取对象为空，则执行orElse
        User user = Optional.ofNullable(getUserById(0))
                .orElse(new User());
    }

    public static void orElseThrow() {
        //如果获取对象为空，则抛出异常
        User user = Optional.ofNullable(getUserById(0))
                .orElseThrow(() -> new RuntimeException("user 对象为空"));
        System.out.println("user name = " + user.userName);
    }

    public static class User {
        public String userName;
    }

    private static User getUserById(int id) {
        return id == 1 ? new User() : null;
    }
}

package sanguo.zhaoyun.shortcut.stream;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static List<User> findUserById(int id) {
        return id == 1 ? new ArrayList<>() : null;
    }
    public static List<User> findUsers(){ return new ArrayList<>();}
}

###一、用法
> @Valid/@Validated：可以用在方法、构造函数、方法参数和成员属性（field）上

###二、使用条件
> 在Controller层中，只有将@Valid/@Validated直接放在该模型前，该模型内部的字段才会被校验

###三、引入依赖
```
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.1.Final</version>
        </dependency>
```
> 注:

> 1.@Valid是使用Hibernate validation的时候使用，@Validated是只用Spring Validator校验机制使用

> 2.Spring Validator的包包含在spring-boot-starter-web中，不用单独应用

> 3.java的JSR303声明了@Valid这类接口，在javax包下，而Hibernate-validator对其进行了实现
    
###四、校验普通参数
```aidl
    @RestController
    @RequestMapping(value = "/test")
    @Validated
    public class RestDemoController {
        @GetMapping("/unread/count")
        public String unreadCount(@Max(value=20L) Integer myParam) {
            return "OK";
        }
    }
```
> 注：这种用法只支持@Validated，不支持@Valid

###五、校验对象参数
```aidl
    @RequestMapping(value = "/validObject")
    public String validObject(@Valid RequestParam requestParam ) {
        System.out.println("test");
        return "ok";
    }
```

###六、分组校验
+ 定义校验对象
```aidl
    public class RequestParam {
    
        @NotNull(message = "年龄不能为空")
        public Long age;
    
        @NotNull(message = "姓名不能为空", groups = {ISaveGroup.class})
        public Long nanme;
    }
```
+ 定义分组
```aidl
    public interface ISaveGroup {
    }
```

+ 定义请求
```aidl
    @RequestMapping("/validGroup")
    public String saveUser(@RequestBody @Validated(ISaveGroup.class) RequestParam requestParam) {
        //必须填写name，才能通过
        return "OK";
    }
```
###一、什么是全局异常异常处理
> 全局异常处理指的是通过“切面”，处理controller中出现的一下；
+ 没有使用全局异常处理的controller类：
```aidl
    @RequestMapping(value = "noExceptionHandle")
    public DataResult noExceptionHandle(String param){
        try {
            iBusiService.doBusiness(param);
        } catch (BusinessException e) {
            return DataResult.fail(101, e.getMessage());
        }catch (IllegalArgumentException e) {
            return DataResult.fail(101, e.getMessage());
        } catch (Exception e) {
            return DataResult.fail(102, e.getMessage());
        }
        return DataResult.success();

    }
```
+ 使用了全员异常处理的controller类：
```aidl
    @RequestMapping(value = "/useExceptionHandle")
    public DataResult useExceptionHandle(String param) {
        iBusiService.doBusiness(param);
        return DataResult.success();
    }
```
###二、全局异常处理架构

    BusiController --> BusiService --> Exception
         |                       |  --> IllegalArgumentException
         |                       |  --> BusinessException    -->  ErrCodeEnum
         |                                  |
    ResultAdvice -->  DataResult  -----------        
                            

+ **ResultAdvice：异常处理类**

	通过@RestControllerAdvice注解该类，使其可以拦截任何@RestController所注解类中抛出的指定类型异常，并通过指定函数进行处理；

+ **BusiController：Controller类**

	通过@RestController进行注解，用来响应rest-http请求；

+ **BusiService：业务处理类**

	通过@Service进行注解，用来处理相应业务；
	
+ **BusinessException：业务异常类**

	用来自定义业务异常，继承自RuntimeException类

+ **ErrCodeEnum：异常编码**

	用来定义异常类中的异常类型（通常为数字）
	
+ **DataResult：返回值类型**

    用来返回给rest-http的调用方，通常包含BusinessException中定义的异常信息；
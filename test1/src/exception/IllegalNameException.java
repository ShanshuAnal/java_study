package exception;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: exception
 * @name: IllegalNameException
 * @Date: 2024/9/23 18:29
 * 自定义异常
 *      1. 继承RuntimeException或者Exception
 *      2. 有参 无参
 */
public class IllegalNameException extends Exception{
    public IllegalNameException() {
    }

    public IllegalNameException(String message) {
        super(message);
    }


}

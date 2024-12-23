package exception;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: exception
 * @name: IllegalAgeException
 * @Date: 2024/9/23 18:31
 */
public class IllegalAgeException extends Exception {
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }
}

package exam.a11_7;

public class NotExistIDException extends Exception {
    public NotExistIDException(){}
    public NotExistIDException(String message){
        super(message);
    }
}

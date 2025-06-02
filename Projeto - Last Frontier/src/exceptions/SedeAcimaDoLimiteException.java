package exceptions;

public class SedeAcimaDoLimiteException extends RuntimeException{
    public SedeAcimaDoLimiteException(String mensagem){
        super(mensagem);
    }
}
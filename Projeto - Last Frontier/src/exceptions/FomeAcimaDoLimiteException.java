package exceptions;

public class FomeAcimaDoLimiteException extends RuntimeException{
    public FomeAcimaDoLimiteException(String mensagem){
        super(mensagem);
    }
}
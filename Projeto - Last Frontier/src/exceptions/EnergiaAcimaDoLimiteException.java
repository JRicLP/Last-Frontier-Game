package exceptions;

public class EnergiaAcimaDoLimiteException extends RuntimeException{
    public EnergiaAcimaDoLimiteException(String mensagem){
        super(mensagem);
    }
}

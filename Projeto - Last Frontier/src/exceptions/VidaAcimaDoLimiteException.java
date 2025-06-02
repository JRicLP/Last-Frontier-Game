package exceptions;

public class VidaAcimaDoLimiteException extends RuntimeException{
    public VidaAcimaDoLimiteException(String mensagem){
        super(mensagem);
    }
}

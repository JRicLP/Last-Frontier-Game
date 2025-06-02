package exceptions;

public class SanidadeAcimaDoLimiteException extends RuntimeException{
    public SanidadeAcimaDoLimiteException(String mensagem){
        super(mensagem);
    }
}

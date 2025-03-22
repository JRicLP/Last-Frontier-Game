package personagens;

public class Explorador {
    private String nomeExplorador;
    private int vidaExplorador;
    private int sedeExplorador;
    private int fomeExplorador;
    private int energiaExplorador;
    private int sanidadeExplorador;
    private String inventarioExplorador;
    private String habilidadesExplorador;
    private String localizacaoExplorador;

    public Explorador(String nomeExplorador, int vidaExplorador, int sedeExplorador, int fomeExplorador, int energiaExplorador,
                   int sanidadeExplorador, String inventarioExplorador, String habilidadesExplorador, String localizacaoExplorador ){
        this.nomeExplorador=nomeExplorador;
        this.vidaExplorador=vidaExplorador;
        this.sedeExplorador=sedeExplorador;
        this.fomeExplorador=fomeExplorador;
        this.energiaExplorador=energiaExplorador;
        this.sanidadeExplorador=sanidadeExplorador;
        this.inventarioExplorador=inventarioExplorador;
        this.habilidadesExplorador=habilidadesExplorador;
        this.localizacaoExplorador=localizacaoExplorador;
    }
}

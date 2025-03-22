package personagens;

public class Pirata {
    private String nomePirata;
    private int vidaPirata;
    private int sedePirata;
    private int fomePirata;
    private int energiaPirata;
    private int sanidadePirata;
    private String inventarioPirata;
    private String habilidadesPirata;
    private String localizacaoPirata;

    public Pirata(String nomePirata, int vidaPirata, int sedePirata, int fomePirata, int energiaPirata,
                   int sanidadePirata, String inventarioPirata, String habilidadesPirata, String localizacaoPirata ){
        this.nomePirata="Scarlet Tempest";
        this.vidaPirata=100;
        this.sedePirata=100;
        this.fomePirata=100;
        this.energiaPirata=85;
        this.sanidadePirata=85;
        this.inventarioPirata="espada de sobrevivência, canhão de bordo,gancho de ferro";
        this.habilidadesPirata="Sobrevivente nato";
        this.localizacaoPirata=localizacaoPirata;
    }
}

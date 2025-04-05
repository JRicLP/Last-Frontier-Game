package personagens;

public class Pirata extends Personagem {
    //Atributos da classe:
    private String habilidadePirata;
    //Metodo construtor:
    public Pirata(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                  double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem, String habilidadePirata) {
        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem,
                sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem);
        this.setNomePersonagem("Scarlet Tempest");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(100);
        this.setEnergiaPersonagem(85);
        this.setSanidadePersonagem(85);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.habilidadePirata = habilidadePirata;
    }
    //Metodos acessores:
    public void setHabilidadePirata(String habilidadePirata) {
        this.habilidadePirata = habilidadePirata;
    }
    public String getHabilidadePirata() {
        return habilidadePirata;
    }
}

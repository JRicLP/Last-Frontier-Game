package personagens;

public class Infiltrador extends Personagem {
    //Atributos da classe:
    private String habilidadeInfiltrador;
    //Metodo construtor:
    public Infiltrador(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                       double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem, String habilidadeInfiltrador) {
        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem,
                sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem);
        this.setNomePersonagem("Malik Gohst");
        this.setVidaPersonagem(85);
        this.setFomePersonagem(65);
        this.setSedePersonagem(85);
        this.setEnergiaPersonagem(100);
        this.setSanidadePersonagem(100);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.habilidadeInfiltrador = habilidadeInfiltrador;
    }
    //Metodos acessores:
    public void setHabilidadeInfiltrador(String habilidadeInfiltrador) {
        this.habilidadeInfiltrador = habilidadeInfiltrador;
    }
    public String getHabilidadeInfiltrador() {
        return habilidadeInfiltrador;
    }
}

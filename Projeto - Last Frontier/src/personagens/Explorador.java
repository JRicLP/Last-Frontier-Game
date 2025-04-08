package personagens;

public class Explorador extends Personagem {
    //Atributos da classe:
    private String habilidadeExplorador;
    //Metodo construtor
    public Explorador(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                      double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem, String habilidadeExplorador) {

        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem, sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem);
        this.setNomePersonagem("Virgil Explorer");
        this.setVidaPersonagem(90);
        this.setFomePersonagem(100);
        this.setSedePersonagem(100);
        this.setEnergiaPersonagem(70);
        this.setSanidadePersonagem(75);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.habilidadeExplorador = habilidadeExplorador;
    }
    //Metodos acessores:
    public void setHabilidadeExplorador(String habilidadeExplorador) {
        this.habilidadeExplorador = habilidadeExplorador;
    }
    public String getHabilidadeExplorador() {
        return habilidadeExplorador;
    }
}
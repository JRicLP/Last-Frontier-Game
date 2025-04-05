package personagens;

public class Explorador extends Personagem {
    //Atributos da classe:
    private String habilidadeExplorador;
    //Metodo construtor
    public Explorador(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                      double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem, String habilidadeExplorador) {
        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem,
                sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem);
        //Falta modificar os atributos do explorador!!
        this.setNomePersonagem("");
        this.setVidaPersonagem(0);
        this.setFomePersonagem(0);
        this.setSedePersonagem(0);
        this.setEnergiaPersonagem(0);
        this.setSanidadePersonagem(0);
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
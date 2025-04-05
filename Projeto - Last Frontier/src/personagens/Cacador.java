package personagens;

public class Cacador extends Personagem {
    //Atributos da classe:
    private String habilidadeCacador;
    //Metodo construtor:
    public Cacador(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                   double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem, String habilidadeCacador) {
        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem,
                sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem);
        this.setNomePersonagem("Flynn Tracker");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(65);
        this.setEnergiaPersonagem(85);
        this.setSanidadePersonagem(85);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.habilidadeCacador = habilidadeCacador;
    }
    //Metodos acessores:
    public void setHabilidadeCacador(String habilidadeCacador) {
        this.habilidadeCacador = habilidadeCacador;
    }
    public String getHabilidadeCacador() {
        return habilidadeCacador;
    }
}

package personagens;

public class Nomade extends Personagem {
    //Atributos da classe:
    private String habilidadeNomade;
    //Metodo construtor:
    public Nomade(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                  double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem,boolean contaminacaoPersonagem,int sedeInicialPersonagem,int fomInicialPersonagem, String habilidadeNomade){

        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem, sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem, contaminacaoPersonagem, sedeInicialPersonagem,fomInicialPersonagem);
        this.setNomePersonagem("Jack Nomad");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(65);
        this.setEnergiaPersonagem(65);
        this.setSanidadePersonagem(100);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.habilidadeNomade = habilidadeNomade;
    }
    //Metodos acessores:
    public void setHabilidadeNomade(String habilidadeNomade) {
        this.habilidadeNomade = habilidadeNomade;
    }
    public String getHabilidadeNomade() {
        return habilidadeNomade;
    }
}

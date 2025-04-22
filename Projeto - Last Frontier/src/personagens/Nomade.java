package personagens;

public class Nomade extends Personagem {
    //Atributos da classe:
    private String habilidadeNomade;
    //Metodo construtor:
    public Nomade(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem,
                  double sanidadePersonagem, String inventarioPersonagem, String localizacaoPersonagem,boolean contaminacaoPersonagem,double sedeInicialPersonagem,double fomeInicialPersonagem, String habilidadeNomade){

        super(nomePersonagem, vidaPersonagem, fomePersonagem, sedePersonagem, energiaPersonagem, sanidadePersonagem, inventarioPersonagem, localizacaoPersonagem, contaminacaoPersonagem, sedeInicialPersonagem,fomeInicialPersonagem);
        this.setNomePersonagem("Jack Nomad");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(65);
        this.setEnergiaPersonagem(65);
        this.setSanidadePersonagem(100);
        this.setInventarioPersonagem(" ");
        this.setLocalizacaoPersonagem(" ");
        this.setContaminacaoPersonagem(false);
        this.setSedeInicialPersonagem(65);
        this.setFomeInicialPersonagem(100);
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

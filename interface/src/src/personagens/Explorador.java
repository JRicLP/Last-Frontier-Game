package personagens;

public class Explorador extends Personagem {

    //Atributos da classe:
    private String habilidadeExplorador;

    //Metodo construtor
    public Explorador(String habilidadeExplorador) {

        this.setNomePersonagem("Virgil Explorer - O Explorador Corajoso");
        this.setVidaPersonagem(90);
        this.setFomePersonagem(100);
        this.setSedePersonagem(100);
        this.setEnergiaPersonagem(70);
        this.setSanidadePersonagem(75);
        this.setInventarioPersonagem(getInventarioPersonagem());
        this.setLocalizacaoPersonagem("");
        this.setContaminacaoPersonagem(false);
        this.setSedeInicialPersonagem(100);
        this.setFomeInicialPersonagem(100);
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
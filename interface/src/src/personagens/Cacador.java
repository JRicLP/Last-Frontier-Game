package personagens;

public class Cacador extends Personagem {

    //Atributos da classe:
    private String habilidadeCacador;

    //Metodo construtor:
    public Cacador(String habilidadeCacador) {
        this.setNomePersonagem("Flynn Tracker - O Caçador Destemido");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(65);
        this.setEnergiaPersonagem(85);
        this.setSanidadePersonagem(85);
        this.setInventarioPersonagem(getInventarioPersonagem());
        this.setLocalizacaoPersonagem("");
        this.setContaminacaoPersonagem(false);
        this.setSedeInicialPersonagem(65);
        this.setFomeInicialPersonagem(100);
        this.habilidadeCacador = habilidadeCacador;
        this.setImagemPersonagemNoAmbiente("cacador");
        this.setEnergiaMaximaPersonagem(85);
        this.setSanidadeMaximaPersonagem(85);
        this.setVidaMaximaPersonagem(100);
    }
    //Metodos acessores:
    public void setHabilidadeCacador(String habilidadeCacador) {
        this.habilidadeCacador = habilidadeCacador;
    }
    public String getHabilidadeCacador() {
        return habilidadeCacador;
    }
}
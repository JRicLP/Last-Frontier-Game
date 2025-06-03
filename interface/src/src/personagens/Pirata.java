package personagens;

public class Pirata extends Personagem {
    //Atributos da classe:
    private String habilidadePirata;
    //Metodo construtor:
    public Pirata(String habilidadePirata) {

        this.setNomePersonagem("Scarlet Tempest - O Pirata Infame");
        this.setVidaPersonagem(100);
        this.setFomePersonagem(100);
        this.setSedePersonagem(100);
        this.setEnergiaPersonagem(85);
        this.setSanidadePersonagem(85);
        this.setInventarioPersonagem(getInventarioPersonagem());
        this.setLocalizacaoPersonagem("");
        this.setContaminacaoPersonagem(false);
        this.setSedeInicialPersonagem(100);
        this.setFomeInicialPersonagem(100);
        this.habilidadePirata = habilidadePirata;
        this.setImagemPersonagemNoAmbiente("pirata");
        this.setEnergiaMaximaPersonagem(85);
        this.setSanidadeMaximaPersonagem(85);
        this.setVidaMaximaPersonagem(100);
    }
    //Metodos acessores:
    public void setHabilidadePirata(String habilidadePirata) {
        this.habilidadePirata = habilidadePirata;
    }
    public String getHabilidadePirata() {
        return habilidadePirata;
    }
}
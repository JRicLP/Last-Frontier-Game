package personagens;

public class Personagens { //será uma classe abstrata
    private String nomePersonagens;
    private int sedePersonagens;
    private int fomePersonagens;
    private int vidaPersonagens;
    private int energiaPersonagens;
    private int sanidadePersonagens;
    private String inventarioPersonagens;
    private String habilidadesPersonagens;
    private String localizacaoPersonagens;
//Métodos da superclasse
    public Personagens(String nomePersonagens, int sedePersonagens, int fomePersonagens, int vidaPersonagens,
                       int energiaPersonagens, int sanidadePersonagens, String inventarioPersonagens, String habilidadesPersonagens,
                        String localizacaoPersonagens){
        this.nomePersonagens=nomePersonagens;
        this.sedePersonagens=sedePersonagens;
        this.fomePersonagens=fomePersonagens;
        this.energiaPersonagens=energiaPersonagens;
        this.sanidadePersonagens=sanidadePersonagens;
        this.inventarioPersonagens=inventarioPersonagens;
        this.habilidadesPersonagens=habilidadesPersonagens;
        this.vidaPersonagens=vidaPersonagens;
        this.localizacaoPersonagens=localizacaoPersonagens;

    }
    public void setNomePersonagens(String nomePersonagens){
        this.nomePersonagens=nomePersonagens;
    }
    public String getNomePersonagens(){
        return nomePersonagens;
    }
    public void setSedePersonagens(int sedePersonagens){
        this.sedePersonagens=sedePersonagens;
    }
    public int getSedePersonagens(){
        return sedePersonagens;
    }
    public void setFomePersonagens(int fomePersonagens) {
        this.fomePersonagens = fomePersonagens;
    }
    public int getFomePersonagens() {
        return fomePersonagens;
    }
    public void setEnergiaPersonagens(int energiaPersonagens) {
        this.energiaPersonagens = energiaPersonagens;
    }
    public int getEnergiaPersonagens() {
        return energiaPersonagens;
    }
    public void setSanidadePersonagens(int sanidadePersonagens) {
        this.sanidadePersonagens = sanidadePersonagens;
    }
    public int getSanidadePersonagens() {
        return sanidadePersonagens;
    }
    public void setVidaPersonagens(int vidaPersonagens) {
        this.vidaPersonagens = vidaPersonagens;
    }
    public int getVidaPersonagens() {
        return vidaPersonagens;
    }

    public void setInventarioPersonagens(String inventarioPersonagens) {
        this.inventarioPersonagens = inventarioPersonagens;
    }

    public String getInventarioPersonagens() {
        return inventarioPersonagens;
    }

    public void setHabilidadesPersonagens(String habilidadesPersonagens) {
        this.habilidadesPersonagens = habilidadesPersonagens;
    }

    public String getHabilidadesPersonagens() {
        return habilidadesPersonagens;
    }

    public void setLocalizacaoPersonagens(String localizacaoPersonagens) {
        this.localizacaoPersonagens = localizacaoPersonagens;
    }

    public String getLocalizacaoPersonagens() {
        return localizacaoPersonagens;
    }
}

package personagens;

public class Pirata {
    private String nomePirata;
    private int vidaPirata;
    private int sedePirata;
    private int fomePirata;
    private int energiaPirata;
    private int sanidadePirata;
    private String inventarioPirata;
    private String habilidadesPirata;
    private String localizacaoPirata;

    public Pirata(String nomePirata, int vidaPirata, int sedePirata, int fomePirata, int energiaPirata,
                   int sanidadePirata, String inventarioPirata, String habilidadesPirata, String localizacaoPirata ){
        this.nomePirata="Scarlet Tempest";
        this.vidaPirata=100;
        this.sedePirata=100;
        this.fomePirata=100;
        this.energiaPirata=85;
        this.sanidadePirata=85;
        this.inventarioPirata="espada de sobrevivência, canhão de bordo,gancho de ferro";
        this.habilidadesPirata="Sobrevivente nato";
        this.localizacaoPirata=localizacaoPirata;
    }
     //Métodos getter para acessar os valores dos atributos
    public String getNomePirata() {
        return nomePirata;
    }
    public int getFomePirata() {
        return fomePirata;
    }
    public int getVidaPirata() {
        return vidaPirata;
    }
    public int getSedePirata() {
        return sedePirata;
    }
    public int getSanidadePirata() {
        return sanidadePirata;
    }
    public int getEnergiaCacador() {
        return energiaPirata;
    }
    public String getInventarioPirata() {
        return inventarioPirata;
    }
    public String getHabilidadesPirata() {
        return habilidadesPirata;
    }
    public String getLocalizacaoPirata() {
        return localizacaoPirata;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomePirata);
        System.out.println("Vida: " + vidaPirata);
        System.out.println("Sede: " + sedePirata);
        System.out.println("Fome: "+ fomePirata);
        System.out.println("Energia: "+ energiaPirata);
        System.out.println("Sanidade: "+ sanidadePirata);
        System.out.println(" Inventário: "+ inventarioPirata);
        System.out.println("Localização: "+ localizacaoPirata);
    }
}

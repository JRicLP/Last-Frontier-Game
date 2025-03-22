package personagens;

public class Cientista {
    private String nomeCientista;
    private int vidaCientista;
    private int sedeCientista;
    private int fomeCientista;
    private int energiaCientista;
    private int sanidadeCientista;
    private String inventarioCientista;
    private String habilidadesCientista;
    private String localizacaoCientista;

    public Cientista(String nomeCientista, int vidaCientista, int sedeCientista, int fomeCientista, int energiaCientista,
                  int sanidadeCientista, String inventarioCientista, String habilidadesCientista, String localizacaoCientista ){
        this.nomeCientista="Gearhead Martinez";
        this.vidaCientista=85;
        this.sedeCientista=100;
        this.fomeCientista =85;
        this.energiaCientista=100;
        this.sanidadeCientista=85;
        this.inventarioCientista="Luva de impacto,granadas de óleo,chave inglesa reforçada";
        this.habilidadesCientista="Mecânico";
        this.localizacaoCientista=localizacaoCientista;
    }
    //Métodos getter para acessar os valores dos atributos
    public String getNomeCientista() {
        return nomeCientista;
    }
    public int getFomeCientista() {
        return fomeCientista;
    }
    public int getVidaCientista() {
        return vidaCientista;
    }
    public int getSedeCientista() {
        return sedeCientista;
    }
    public int getSanidadeCientista() {
        return sanidadeCientista;
    }
    public int getEnergiaCientista() {
        return energiaCientista;
    }
    public String getInventarioCientista() {
        return inventarioCientista;
    }
    public String getHabilidadesCientista() {
        return habilidadesCientista;
    }
    public String getLocalizacaoCientista() {
        return localizacaoCientista;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomeCientista);
        System.out.println("Vida: " + vidaCientista);
        System.out.println("Sede: " + sedeCientista);
        System.out.println("Fome: "+ fomeCientista);
        System.out.println("Energia: "+ energiaCientista);
        System.out.println("Sanidade: "+ sanidadeCientista);
        System.out.println(" Inventário: "+ inventarioCientista);
        System.out.println("Localização: "+ localizacaoCientista);
    }
}



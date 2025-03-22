package personagens;

public class Cacador {
    private String nomeCacador;
    private int vidaCacador;
    private int sedeCacador;
    private int fomeCacador;
    private int energiaCacador;
    private int sanidadeCacador;
    private String inventarioCacador;
    private String habilidadesCacador;
    private String localizacaoCacador;

    public Cacador(String nomeCacador, int vidaCacador, int sedeCacador, int fomeCacador, int energiaCacador,
                      int sanidadeCacador, String inventarioCacador, String habilidadesCacador, String localizacaoCacador ){
        this.nomeCacador="Flynn Tracker";
        this.vidaCacador=100;
        this.sedeCacador=65;
        this.fomeCacador=100;
        this.energiaCacador=85;
        this.sanidadeCacador=85;
        this.inventarioCacador="arco e flecha ,revólver,faca de caçador";
        this.habilidadesCacador="Lutador";
        this.localizacaoCacador=localizacaoCacador;
    }
    //Métodos getter para acessar os valores dos atributos
    public String getNomeCacador() {
        return nomeCacador;
    }
    public int getFomeCacador() {
        return fomeCacador;
    }
    public int getVidaCacador() {
        return vidaCacador;
    }
    public int getSedeCacador() {
        return sedeCacador;
    }
    public int getSanidadeCacador() {
        return sanidadeCacador;
    }
    public int getEnergiaCacador() {
        return energiaCacador;
    }
    public String getInventarioCacador() {
        return inventarioCacador;
    }
    public String getHabilidadesCacador() {
        return habilidadesCacador;
    }
    public String getLocalizacaoCacador() {
        return localizacaoCacador;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomeCacador);
        System.out.println("Vida: " + vidaCacador);
        System.out.println("Sede: " + sedeCacador);
        System.out.println("Fome: "+ fomeCacador);
        System.out.println("Energia: "+ energiaCacador);
        System.out.println("Sanidade: "+ sanidadeCacador);
        System.out.println(" Inventário: "+ inventarioCacador);
        System.out.println("Localização: "+ localizacaoCacador);
    }
}

package personagens;

public class Nomade {
    private String nomeNomade;
    private int vidaNomade;
    private int sedeNomade;
    private int fomeNomade;
    private int energiaNomade;
    private int sanidadeNomade;
    private String inventarioNomade;
    private String habilidadesNomade;
    private String localizacaoNomade;

    public Nomade(String nomeNomade, int vidaNoomade, int sedeNomade, int fomeNomade, int energiaNomade,
                     int sanidadeNomade, String inventarioNomade, String habilidadesNomade, String localizacaoNomade ){
        this.nomeNomade="Jack Nomad";
        this.vidaNomade=100;
        this.sedeNomade=65;
        this.fomeNomade =100;
        this.energiaNomade=65;
        this.sanidadeNomade=100;
        this.inventarioNomade="punhal de combate,machado de sobrevivência,lança de caça";
        this.habilidadesNomade="Médico";
        this.localizacaoNomade=localizacaoNomade;
    }
    //Métodos getter para acessar os valores dos atributos
    public String getNomeNomade() {
        return nomeNomade;
    }
    public int getFomeNomade() {
        return fomeNomade;
    }
    public int getVidaNomade() {
        return vidaNomade;
    }
    public int getSedeNomade() {
        return sedeNomade;
    }
    public int getSanidadeNomade() {
        return sanidadeNomade;
    }
    public int getEnergiaNomade() {
        return energiaNomade;
    }
    public String getInventarioNomade() {
        return inventarioNomade;
    }
    public String getHabilidadesNomade() {
        return habilidadesNomade;
    }
    public String getLocalizacaoNomade() {
        return localizacaoNomade;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomeNomade);
        System.out.println("Vida: " + vidaNomade);
        System.out.println("Sede: " + sedeNomade);
        System.out.println("Fome: "+ fomeNomade);
        System.out.println("Energia: "+ energiaNomade);
        System.out.println("Sanidade: "+ sanidadeNomade);
        System.out.println(" Inventário: "+ inventarioNomade);
        System.out.println("Localização: "+ localizacaoNomade);
    }
}

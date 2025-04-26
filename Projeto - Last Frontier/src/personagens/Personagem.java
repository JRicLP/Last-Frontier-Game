package personagens;

import interfaces.CharacterActions;

public  abstract class Personagem implements CharacterActions {
    //Atributos da superclasse:
    private String nomePersonagem;
    private double vidaPersonagem;
    private double fomePersonagem;
    private double sedePersonagem;
    private double energiaPersonagem;
    private double sanidadePersonagem;
    private String inventarioPersonagem;
    private String localizacaoPersonagem;
    private boolean contaminacaoPersonagem=false;
    private double sedeInicialPersonagem;
    private double fomeInicialPersonagem;
    //Metodo construtor:
    public Personagem(String nomePersonagem, double vidaPersonagem, double fomePersonagem, double sedePersonagem, double energiaPersonagem, double sanidadePersonagem,
                      String inventarioPersonagem, String localizacaoPersonagem, boolean contaminacaoPersonagem, double sedeInicialPersonagem, double fomeInicialPersonagem){
        this.nomePersonagem = nomePersonagem;
        this.vidaPersonagem = vidaPersonagem;
        this.fomeInicialPersonagem=fomeInicialPersonagem;
        this.fomePersonagem = fomeInicialPersonagem;
        this.sedeInicialPersonagem=sedeInicialPersonagem;
        this.sedePersonagem = sedeInicialPersonagem;
        this.energiaPersonagem = energiaPersonagem;
        this.sanidadePersonagem = sanidadePersonagem;
        this.inventarioPersonagem = inventarioPersonagem;
        this.localizacaoPersonagem = localizacaoPersonagem;
        this.contaminacaoPersonagem=contaminacaoPersonagem;
    }
    //Metodos acessores:
    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public void setVidaPersonagem(double vidaPersonagem) {
        this.vidaPersonagem = vidaPersonagem;
    }
    public double getVidaPersonagem() {
        return vidaPersonagem;
    }
    public void setFomePersonagem(double fomePersonagem) {
        this.fomePersonagem = fomePersonagem;
    }
    public double getFomePersonagem(){
        return fomePersonagem;
    }
    public void setSedePersonagem(double sedePersonagem) {
        this.sedePersonagem = sedePersonagem;
    }
    public double getSedePersonagem() {
        return sedePersonagem;
    }
    public void setEnergiaPersonagem(double energiaPersonagem) {
        this.energiaPersonagem = energiaPersonagem;
    }
    public double getEnergiaPersonagem() {
        return energiaPersonagem;
    }
    public void setSanidadePersonagem(double sanidadePersonagem) {
        this.sanidadePersonagem = sanidadePersonagem;
    }
    public double getSanidadePersonagem() {
        return sanidadePersonagem;
    }
    public void setInventarioPersonagem(String inventarioPersonagem) {
        this.inventarioPersonagem = inventarioPersonagem;
    }
    public String getInventarioPersonagem() {
        return inventarioPersonagem;
    }
    public void setLocalizacaoPersonagem(String localizacaoPersonagem) {
        this.localizacaoPersonagem = localizacaoPersonagem;
    }
    public String getLocalizacaoPersonagem() {
        return localizacaoPersonagem;
    }
    public void setContaminacaoPersonagem(boolean contaminacaoPersonagem){
        this.contaminacaoPersonagem=contaminacaoPersonagem;
    }
    public boolean getContaminacaoPersonagem(){
        return contaminacaoPersonagem;
    }
    public double getSedeInicialPersonagem() {
        return sedeInicialPersonagem;
    }

    public void setSedeInicialPersonagem(double sedeInicial) {
        this.sedeInicialPersonagem = sedeInicial;
    }

    public double getFomeInicialPersonagem() {
        return fomeInicialPersonagem;
    }

    public void setFomeInicialPersonagem(double fomeInicialPersonagem) {
        this.fomeInicialPersonagem = fomeInicialPersonagem;
    }

    //Metodo implementados:
    @Override
    public void statusPersonagem() {
        System.out.println("Nome: " + getNomePersonagem());
        System.out.println("Vida: " + getVidaPersonagem());
        System.out.println("Fome: " + getFomePersonagem());
        System.out.println("Sede: " + getSedePersonagem());
        System.out.println("Energia: " + getEnergiaPersonagem());
        System.out.println("Sanidade: " + getSanidadePersonagem());
        System.out.println("Inventário: " + getInventarioPersonagem());
        System.out.println("Localização: " + getLocalizacaoPersonagem());
    }
}
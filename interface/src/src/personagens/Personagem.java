package personagens;

import interfaces.AcoesPersonagens;
import inventario.Inventario;

public  abstract class Personagem implements AcoesPersonagens {

    //Atributos da superclasse:
    private String nomePersonagem;
    private int vidaPersonagem;
    private int fomePersonagem;
    private int sedePersonagem;
    private int energiaPersonagem;
    private int sanidadePersonagem;
    private Inventario inventarioPersonagem;
    private String localizacaoPersonagem;
    private boolean contaminacaoPersonagem = false;
    private int sedeInicialPersonagem;
    private int fomeInicialPersonagem;

    //Metodo construtor:
    public Personagem(){
    }

    //Metodos acessores:
    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public void setVidaPersonagem(int vidaPersonagem) {
        this.vidaPersonagem = vidaPersonagem;
    }
    public int getVidaPersonagem() {
        return vidaPersonagem;
    }
    public void setFomePersonagem(int fomePersonagem) {
        this.fomePersonagem = fomePersonagem;
    }
    public int getFomePersonagem(){
        return fomePersonagem;
    }
    public void setSedePersonagem(int sedePersonagem) {
        this.sedePersonagem = sedePersonagem;
    }
    public int getSedePersonagem() {
        return sedePersonagem;
    }
    public void setEnergiaPersonagem(int energiaPersonagem) {
        this.energiaPersonagem = energiaPersonagem;
    }
    public int getEnergiaPersonagem() {
        return energiaPersonagem;
    }
    public void setSanidadePersonagem(int sanidadePersonagem) {
        this.sanidadePersonagem = sanidadePersonagem;
    }
    public int getSanidadePersonagem() {
        return sanidadePersonagem;
    }
    public void setInventarioPersonagem(Inventario inventarioPersonagem) {
        this.inventarioPersonagem = inventarioPersonagem;
    }
    public Inventario getInventarioPersonagem() {
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
    public int getSedeInicialPersonagem() {
        return sedeInicialPersonagem;
    }

    public void setSedeInicialPersonagem(int sedeInicial) {
        this.sedeInicialPersonagem = sedeInicial;
    }

    public int getFomeInicialPersonagem() {
        return fomeInicialPersonagem;
    }

    public void setFomeInicialPersonagem(int fomeInicialPersonagem) {
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
        System.out.println("Localização: " + getLocalizacaoPersonagem());
    }
}

package personagens;

import interfaces.AcoesPersonagens;
import inventario.Inventario;
import itens.Arma;
import itens.Item;
import itens.Remedio;

import java.util.ArrayList;

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
    private String imagemPersonagemNoAmbiente;
    private int vidaMaximaPersonagem;
    private int energiaMaximaPersonagem;
    private int sanidadeMaximaPersonagem;
    private Arma armaEquipada;
    public Personagem() {
        // Cria os itens iniciais
        Remedio vefr = new Remedio("Vefrbind",2,4,"Bandagem", "Tiras de linho consagrado embebidas em seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                " como se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");
        Arma kv = new Arma("Kviðskera", 4, 9, "Arma corpo a corpo", 9, 2);//faca
        ArrayList<Item> listaItens = new ArrayList<>(20);
        this.inventarioPersonagem = new Inventario(listaItens, 45,22);
        this.inventarioPersonagem.adicionarItem(vefr);
        this.inventarioPersonagem.adicionarItem(kv);


    }




//tirei FomeMaxima, para utilizar a fome e sede inicial
    //Metodos acessores:



    public void adicionarItem(Item item) {
        inventarioPersonagem.adicionarItem(item);
    }

    public boolean temItem(String nomeItem) {
        for (Item item : inventarioPersonagem.getListaItens()) {
            if (item.getNomeItem().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public boolean isContaminacaoPersonagem() {
        return contaminacaoPersonagem;
    }

    public int getVidaMaximaPersonagem() {
        return vidaMaximaPersonagem;
    }

    public void setVidaMaximaPersonagem(int vidaMaximaPersonagem) {
        this.vidaMaximaPersonagem = vidaMaximaPersonagem;
    }

    public int getEnergiaMaximaPersonagem() {
        return energiaMaximaPersonagem;
    }

    public void setEnergiaMaximaPersonagem(int energiaMaximaPersonagem) {
        this.energiaMaximaPersonagem = energiaMaximaPersonagem;
    }

    public int getSanidadeMaximaPersonagem() {
        return sanidadeMaximaPersonagem;
    }

    public void setSanidadeMaximaPersonagem(int sanidadeMaximaPersonagem) {
        this.sanidadeMaximaPersonagem = sanidadeMaximaPersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public void setVidaPersonagem(int vidaPersonagem) {
        this.vidaPersonagem = Math.max(vidaPersonagem, Math.min(vidaPersonagem, vidaMaximaPersonagem));
    }
    public int getVidaPersonagem() {
        return vidaPersonagem;
    }
    public void setFomePersonagem(int fomePersonagem) {
        this.fomePersonagem = Math.max(fomePersonagem, Math.min(fomePersonagem, fomeInicialPersonagem));
    }
    public int getFomePersonagem(){
        return fomePersonagem;
    }
    public void setSedePersonagem(int sedePersonagem) {
        this.sedePersonagem = Math.max(sedePersonagem, Math.min(sedePersonagem, sedeInicialPersonagem));
    }
    public int getSedePersonagem() {
        return sedePersonagem;
    }
    public void setEnergiaPersonagem(int energiaPersonagem) {
        this.energiaPersonagem = Math.max(energiaPersonagem, Math.min(energiaPersonagem, energiaMaximaPersonagem));
    }
    public int getEnergiaPersonagem() {
        return energiaPersonagem;
    }
    public void setSanidadePersonagem(int sanidadePersonagem) {
        this.sanidadePersonagem = Math.max(sanidadePersonagem, Math.min(sanidadePersonagem, sanidadeMaximaPersonagem));
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
    public void setImagemPersonagemNoAmbiente(String imagemPersonagemNoAmbiente) {
        this.imagemPersonagemNoAmbiente = imagemPersonagemNoAmbiente;
    }

    public String getImagemPersonagemNoAmbiente() {
        return this.imagemPersonagemNoAmbiente; // Deve retornar algo como "cacador", "explorador", etc.
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
    public boolean estaVivo() {
        return vidaPersonagem > 0 && fomePersonagem > 0 && sedePersonagem > 0 &&
                energiaPersonagem > 0 && sanidadePersonagem > 0;
    }

    public String statusFormatado() {
        return "Nome: " + nomePersonagem +
                "\nVida: " + vidaPersonagem +
                "\nFome: " + fomePersonagem +
                "\nSede: " + sedePersonagem +
                "\nEnergia: " + energiaPersonagem +
                "\nSanidade: " + sanidadePersonagem +
                "\nLocalização: " + localizacaoPersonagem;
    }

    public void descansar() {
        setEnergiaPersonagem(getEnergiaPersonagem() + 20);
        setSanidadePersonagem(getSanidadePersonagem() + 10);
        setFomePersonagem(getFomePersonagem() - 8); // penalidade por passar tempo sem comer
        setSedePersonagem(getSedePersonagem() - 8); // penalidade por passar tempo sem beber
    }
    public void perderVida(int dano) {
        this.vidaPersonagem -= dano;
        if (this.vidaPersonagem < 0) {
            this.vidaPersonagem = 0;
        }
    }





}
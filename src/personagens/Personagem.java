package personagens;

import interfaces.AcoesPersonagens;
import inventario.Inventario;
import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;


public abstract class Personagem implements AcoesPersonagens {

    //Atributos da Superclasse:
    private String nomePersonagem;
    private int vidaPersonagem;
    private int fomePersonagem;
    private int sedePersonagem;
    private int energiaPersonagem;
    private int sanidadePersonagem;

    //Atributos para os valores máximos/iniciais dos status:
    private int vidaInicialPersonagem;
    private int fomeInicialPersonagem;
    private int sedeInicialPersonagem;
    private int energiaInicialPersonagem;
    private int sanidadeInicialPersonagem;

    //Atributos especiais:
    private Inventario inventarioPersonagem;
    private String localizacaoPersonagem;
    private boolean contaminacaoPersonagem;

    //Novo atributo para o sistema de Habilidade Especial:
    private boolean habilidadeEspecialJaUsada;

    //Metodo Construtor:
    public Personagem(String nomePersonagem, int vidaInicial, int fomeInicial, int sedeInicial, int sanidadeInicial, int energiaInicial) {
        this.nomePersonagem = nomePersonagem;

        this.vidaInicialPersonagem = vidaInicial;
        this.vidaPersonagem = vidaInicial;

        this.fomeInicialPersonagem = fomeInicial;
        this.fomePersonagem = fomeInicial;

        this.sedeInicialPersonagem = sedeInicial;
        this.sedePersonagem = sedeInicial;

        this.sanidadeInicialPersonagem = sanidadeInicial;
        this.sanidadePersonagem = sanidadeInicial;

        this.energiaInicialPersonagem = energiaInicial;
        this.energiaPersonagem = energiaInicial;

        this.contaminacaoPersonagem = false;
        this.habilidadeEspecialJaUsada = false;

    }

    //Metodos acessores existentes (getters e setters para os status atuais):
    public String getNomePersonagem() { return nomePersonagem; }
    public void setNomePersonagem(String nomePersonagem) { this.nomePersonagem = nomePersonagem; }

    public int getVidaPersonagem() { return vidaPersonagem; }
    public void setVidaPersonagem(int vidaPersonagem) { this.vidaPersonagem = vidaPersonagem; }

    public int getFomePersonagem() { return fomePersonagem; }
    public void setFomePersonagem(int fomePersonagem) { this.fomePersonagem = fomePersonagem; }

    public int getSedePersonagem() { return sedePersonagem; }
    public void setSedePersonagem(int sedePersonagem) { this.sedePersonagem = sedePersonagem; }

    public int getEnergiaPersonagem() { return energiaPersonagem; }
    public void setEnergiaPersonagem(int energiaPersonagem) { this.energiaPersonagem = energiaPersonagem; }

    public int getSanidadePersonagem() { return sanidadePersonagem; }
    public void setSanidadePersonagem(int sanidadePersonagem) { this.sanidadePersonagem = sanidadePersonagem; }

    public Inventario getInventarioPersonagem() { return inventarioPersonagem; }
    public void setInventarioPersonagem(Inventario inventarioPersonagem) { this.inventarioPersonagem = inventarioPersonagem; }

    public String getLocalizacaoPersonagem() { return localizacaoPersonagem; }
    public void setLocalizacaoPersonagem(String localizacaoPersonagem) { this.localizacaoPersonagem = localizacaoPersonagem; }

    public boolean getContaminacaoPersonagem() { return contaminacaoPersonagem; }
    public void setContaminacaoPersonagem(boolean contaminacaoPersonagem) { this.contaminacaoPersonagem = contaminacaoPersonagem; }

    //Getters para os status Iniciais/Maximos:
    public int getVidaInicialPersonagem() { return vidaInicialPersonagem; }
    public void setVidaInicialPersonagem(int vidaInicialPersonagem) { this.vidaInicialPersonagem = vidaInicialPersonagem; }

    public int getFomeInicialPersonagem() { return fomeInicialPersonagem; }
    public void setFomeInicialPersonagem(int fomeInicialPersonagem) { this.fomeInicialPersonagem = fomeInicialPersonagem; }

    public int getSedeInicialPersonagem() { return sedeInicialPersonagem; }
    public void setSedeInicialPersonagem(int sedeInicialPersonagem) { this.sedeInicialPersonagem = sedeInicialPersonagem; }

    public int getEnergiaInicialPersonagem() { return energiaInicialPersonagem; }
    public void setEnergiaInicialPersonagem(int energiaInicialPersonagem) { this.energiaInicialPersonagem = energiaInicialPersonagem; }

    public int getSanidadeInicialPersonagem() { return sanidadeInicialPersonagem; }
    public void setSanidadeInicialPersonagem(int sanidadeInicialPersonagem) { this.sanidadeInicialPersonagem = sanidadeInicialPersonagem; }

    //Métodos e Atributos relacionados a habilidade especial:
    public boolean isHabilidadeEspecialJaUsada() {
        return habilidadeEspecialJaUsada;
    }
    public void marcarHabilidadeEspecialComoUsada() {
        this.habilidadeEspecialJaUsada = true;
    }
    //Métodos abstratos:
    public abstract String getNomeHabilidadeEspecial();
    public abstract String getDescricaoHabilidadeEspecial();
    public abstract boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem);

    //Métodos Implementados:
    @Override
    public void statusPersonagem() {
        System.out.println("\n--- Status de " + getNomePersonagem() + " ---");
        System.out.println("Vida: " + getVidaPersonagem() + "/" + getVidaInicialPersonagem());
        System.out.println("Fome: " + getFomePersonagem() + "/" + getFomeInicialPersonagem());
        System.out.println("Sede: " + getSedePersonagem() + "/" + getSedeInicialPersonagem());
        System.out.println("Energia: " + getEnergiaPersonagem() + "/" + getEnergiaInicialPersonagem());
        System.out.println("Sanidade: " + getSanidadePersonagem() + "/" + getSanidadeInicialPersonagem());
        System.out.println("Contaminado: " + (getContaminacaoPersonagem() ? "Sim" : "Não"));
        System.out.println("Localização: " + getLocalizacaoPersonagem());
        System.out.println("Habilidade Especial Usada: " + (isHabilidadeEspecialJaUsada() ? "Sim" : "Não"));
        System.out.println("-------------------------");
    }
}
package personagens;

import inventario.Inventario;
import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;

public class Nomade extends Personagem {

    //Atributos da classe:
    private String descricaoHabilidadeClasse;

    //Metodo construtor:
    public Nomade(String descricaoHabilidadeClasseEntrada) {
        super("Jack Nomad - O Nômade Rústico", 100,100,100,80,80);
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasseEntrada;
    }

    //Metodos acessores para a descrição da habilidade da classe:
    public String getDescricaoHabilidadeClasse() {
        return descricaoHabilidadeClasse;
    }

    public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) {
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
    }

    // --- Implementação dos Métodos Abstratos da Habilidade Especial ---
    @Override
    public String getNomeHabilidadeEspecial() {
        return "Bênção da Resiliência";
    }

    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "O Nômade canaliza sua profunda conexão com a sobrevivência, restaurando completamente sua Vida, Fome, Sede e Sanidade, e purificando seu corpo de contaminações.";
    }

    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem) {
        System.out.println(this.getNomePersonagem() + " invoca a " + getNomeHabilidadeEspecial() + "!");
        System.out.println("Uma onda de energia vital percorre seu corpo, vinda da sua incrível adaptabilidade...");
        //Restaura todos os status para o máximo:
        this.setVidaPersonagem(this.getVidaInicialPersonagem());
        this.setFomePersonagem(this.getFomeInicialPersonagem());
        this.setSedePersonagem(this.getSedeInicialPersonagem());
        this.setSanidadePersonagem(this.getSanidadeInicialPersonagem());
        this.setEnergiaPersonagem(this.getEnergiaInicialPersonagem());
        System.out.println("Vida, Fome, Sede, Sanidade e Energia completamente restauradas!");
        if (this.getContaminacaoPersonagem()) {
            this.setContaminacaoPersonagem(false);
            System.out.println("Qualquer traço de contaminação em seu corpo desaparece.");
        }
        return true;
    }
    public String getHabilidadeNomade() {
        return descricaoHabilidadeClasse;
    }
}
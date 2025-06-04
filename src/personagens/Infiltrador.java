package personagens;

import inventario.Inventario;
import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;

public class Infiltrador extends Personagem {

    //Atributos da Classe:
    private String descricaoHabilidadeClasse;

    //Metodo Construtor:
    public Infiltrador(String descricaoHabilidadeClasseEntrada) {
        super("Malik Ghost - O Fantasma da Sombra", 85, 70, 70, 90, 100);
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasseEntrada;
    }

    //Metodos Acessores para a descrição da Habilidade da classe:
    public String getDescricaoHabilidadeClasse() {
        return descricaoHabilidadeClasse;
    }

    public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) {
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
    }

    //Implementação dos Métodos Abstratos da Habilidade Especial:
    @Override
    public String getNomeHabilidadeEspecial() {
        return "Manto Etéreo";
    }
    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "O Infiltrador evoca um manto de sombras e silêncio, tornando-se uno com o ambiente e garantindo uma fuga imediata e segura de qualquer encontro hostil.";
    }
    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem) {
        System.out.println(this.getNomePersonagem() + " ativa o " + getNomeHabilidadeEspecial() + "!");

        if (criaturaAlvo != null && criaturaAlvo.getVidaCriatura() > 0) {
            //Existência da Criatura para tu escapar
            System.out.println("Você se dissolve nas sombras, escapando de " + criaturaAlvo.getNomeEvento() + " sem deixar rastros!");
            return true;
        } else {
            System.out.println("Não há perigo imediato para usar o Manto Etéreo. Você guarda sua energia.");
            return false;
        }
    }
    public String getHabilidadeInfiltrador() {
        return descricaoHabilidadeClasse;
    }
}
package personagens;

import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;
import inventario.Inventario;

public class Cacador extends Personagem {

    //Atributos da Classe:
    private String descricaoHabilidadeClasse;

    //Metodo Construtor:
    public Cacador(String descricaoHabilidadeClasseEntrada) {
        super("Flynn Tracker - A Presa Sombria",100,100,80,75,90);
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
        return "Golpe Certeiro do Predador";
    }

    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "Com instintos aguçados, o Caçador identifica um ponto vital e desfere um ataque de precisão extraordinária, causando dano adicional significativo ao alvo. Só pode ser usado em combate.";
    }

    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo,Ambiente ambienteAtual,GerenciadorDeItem gerenciadorDeItem,Inventario inventarioPersonagem) {
        System.out.println(this.getNomePersonagem() + " ativa o " + getNomeHabilidadeEspecial() + "!");
        if (criaturaAlvo != null && criaturaAlvo.getVidaCriatura() > 0) {
            int danoHabilidade = 35;
            this.setEnergiaPersonagem(this.getEnergiaPersonagem() - 20);
            System.out.println("Você gasta um pouco de sua energia para focar o golpe...");
            System.out.println("Você mira cuidadosamente em " + criaturaAlvo.getNomeEvento() + "...");
            criaturaAlvo.setVidaCriatura(criaturaAlvo.getVidaCriatura() - danoHabilidade);
            System.out.println("GOLPE CERTEIRO! Você causou " + danoHabilidade + " de dano direto em " + criaturaAlvo.getNomeEvento() + "!");
            System.out.println("Vida restante da criatura: " + criaturaAlvo.getVidaCriatura());
            if (criaturaAlvo.getVidaCriatura() <= 0) {
                System.out.println(criaturaAlvo.getNomeEvento() + " não resistiu ao seu ataque preciso!");
            }
            return true;
        } else {
            System.out.println(getNomeHabilidadeEspecial() + " só pode ser usado contra uma criatura viva em combate!");
            return false;
        }
    }
    public String getHabilidadeCacador() {
        return getDescricaoHabilidadeClasse();
    }
}
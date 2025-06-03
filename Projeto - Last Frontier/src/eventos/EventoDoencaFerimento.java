package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

public class EventoDoencaFerimento extends Evento {

    //Atributos da Subclasse:
    private String tipoDoenca;
    private String impactoDoencaFerimento; //Descrição do que acontece
    private boolean curaDisponivel;

    //Metodo Construtor:
    public EventoDoencaFerimento(String nomeEvento, String descricaoEvento, int probabilidadeEvento,
                                 String impactoEvento, boolean condicaoEvento,
                                 String tipoDoenca, String impactoDoencaFerimento, boolean curaDisponivel) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoDoenca = tipoDoenca;
        this.impactoDoencaFerimento = impactoDoencaFerimento;
        this.curaDisponivel = curaDisponivel;
    }
    //Metodos Acessores:
    public String getTipoDoenca() { return tipoDoenca; }
    public void setTipoDoenca(String tipoDoenca) { this.tipoDoenca = tipoDoenca; }
    public String getImpactoDoencaFerimento() { return impactoDoencaFerimento; }
    public void setImpactoDoencaFerimento(String impactoDoencaFerimento) { this.impactoDoencaFerimento = impactoDoencaFerimento; }
    public boolean isCuraDisponivel() { return curaDisponivel; }
    public void setCuraDisponivel(boolean curaDisponivel) { this.curaDisponivel = curaDisponivel; }
    //Metodo Herdado:
    @Override
    public void executar(Personagem personagemAfetado, Ambiente ambienteAtual) {
        if (!this.isCondicaoEvento()) { // Verifica a condição base do evento
            System.out.println("As condições para '" + getNomeEvento() + "' não foram atendidas.");
            return;
        }
        System.out.println("ALERTA! " + personagemAfetado.getNomePersonagem() + " foi afligido por: " + this.getNomeEvento() + "!");
        System.out.println(this.getDescricaoEvento());
        System.out.println("Efeitos observados: " + this.getImpactoDoencaFerimento());

        switch (this.getNomeEvento()) {
            case "Sotnblár": // Mordida da Cobra -> tipoDoenca="Envenenamento", impacto="Cegueira, Perca de Energia"
                System.out.println("O veneno da serpente corre por suas veias, turvando sua visão e drenando suas forças!");
                personagemAfetado.setContaminacaoPersonagem(true); // Pode usar o status de contaminação geral
                personagemAfetado.setEnergiaPersonagem(personagemAfetado.getEnergiaPersonagem() - 15);
                break;

            case "Dróttarskör": // Chifrada do Javali -> tipoDoenca="Corte", impacto="Hemorragia"
                System.out.println("Um ferimento feio não para de sangrar!");
                personagemAfetado.setVidaPersonagem(personagemAfetado.getVidaPersonagem() - 5); // Dano imediato
                System.out.println("Você perdeu 5 de vida devido ao corte.");
                break;

            case "Skuggbrandr": // Contato com a Aranha -> tipoDoenca="Feitiço", impacto="Ilusão"
                System.out.println("Sua mente é invadida por sombras e sussurros após o contato com a criatura!");
                personagemAfetado.setSanidadePersonagem(personagemAfetado.getSanidadePersonagem() - 20);
                break;

            case "Húndraugr": // Arranhão do Lobo -> tipoDoenca="Corte", impacto="Ilusão e Hemorragia"
                System.out.println("O arranhão do lobo espectral infecciona rapidamente e perturba sua mente!");
                personagemAfetado.setVidaPersonagem(personagemAfetado.getVidaPersonagem() - 3); // Dano imediato leve
                personagemAfetado.setSanidadePersonagem(personagemAfetado.getSanidadePersonagem() - 10);
                break;

            case "Aldrgáta": // Olhar do Pássaro -> tipoDoenca="Feitiço", impacto="Ilusão"
                System.out.println("O olhar penetrante do Veðrhrafn deixa você com visões perturbadoras do seu próprio fim!");
                personagemAfetado.setSanidadePersonagem(personagemAfetado.getSanidadePersonagem() - 15);
                break;

            case "Frostseidr": // Toque do Cervo -> tipoDoenca="Corte e Feitiço", impacto="Ilusão e Hemorragia"
                System.out.println("O toque gélido do Hjarnhyrndr congela sua pele e confunde seus sentidos!");
                personagemAfetado.setVidaPersonagem(personagemAfetado.getVidaPersonagem() - 5);
                personagemAfetado.setEnergiaPersonagem(personagemAfetado.getEnergiaPersonagem() - 10);
                personagemAfetado.setSanidadePersonagem(personagemAfetado.getSanidadePersonagem() - 5);
                break;

            default:
                System.out.println("Você foi afetado por '" + this.getNomeEvento() + "', mas os efeitos exatos não são claros...");
                personagemAfetado.setEnergiaPersonagem(personagemAfetado.getEnergiaPersonagem() - 5);
                break;
        }

        //Garantir que os status não fiquem abaixo de 0 (ou acima do máximo, se aplicável)
        if (personagemAfetado.getVidaPersonagem() < 0) personagemAfetado.setVidaPersonagem(0);
        if (personagemAfetado.getFomePersonagem() < 0) personagemAfetado.setFomePersonagem(0);
        if (personagemAfetado.getSedePersonagem() < 0) personagemAfetado.setSedePersonagem(0);
        if (personagemAfetado.getEnergiaPersonagem() < 0) personagemAfetado.setEnergiaPersonagem(0);
        if (personagemAfetado.getSanidadePersonagem() < 0) personagemAfetado.setSanidadePersonagem(0);

        //Se o personagem morreu como resultado direto da doença/ferimento:
        if (personagemAfetado.getVidaPersonagem() <= 0) {
            System.out.println(personagemAfetado.getNomePersonagem() + " sucumbiu a " + this.getNomeEvento() + "!");
            //A flag personagemVivo no Main será tratada no início do próximo turno.
        }
        //A mensagem de "curaDisponivel" pode ser usada pelo jogador para saber se deve procurar um antídoto/remédio
        if (this.isCuraDisponivel()) {
            System.out.println("Parece haver uma cura conhecida para esta aflição...");
        } else {
            System.out.println("Esta é uma condição sinistra, e nenhuma cura é conhecida pelos sábios.");
        }
    }
}
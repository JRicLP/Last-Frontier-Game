package itens;

import exceptions.EnergiaAcimaDoLimiteException;
import exceptions.FomeAcimaDoLimiteException;
import exceptions.SanidadeAcimaDoLimiteException;
import personagens.Personagem;

public class Alimento extends Item {
    //Atributos da Subclasse
    private int valorNutricional;
    private String tipoAlimento;
    private int prazoValidade;

    //Metodo Construtor da Classe:
    public Alimento(String nomeItem, int pesoItem, int durabilidadeItem, int valorNutricional, String tipoAlimento, int prazoValidade) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
        this.prazoValidade = prazoValidade;
    }

    //Metodos acessores:
    public int getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public int getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(int prazoValidade) {
        this.prazoValidade = prazoValidade;
    }


    //Metodo sobrescrito:
    @Override
    public void usar(Item item, Personagem personagem) {
        System.out.println("Você come " + this.getNomeItem() + ".");
        try {
            int fomeAtual = personagem.getFomePersonagem();
            int novaFome = fomeAtual + this.getValorNutricional();

            if (novaFome > personagem.getFomeInicialPersonagem()) {
                throw new FomeAcimaDoLimiteException("A fome não pode ultrapassar o máximo permitido!");
            }

            personagem.setFomePersonagem(novaFome);

            switch (this.tipoAlimento) {
                case "Carne Animal":
                    System.out.println("É uma refeição reforçada! Fome restaurada em " + this.getValorNutricional() + " pontos.");
                    break;
                case "Frutas Variadas":
                    System.out.println("Refrescante! Fome restaurada em " + this.getValorNutricional() + " pontos.");
                    break;
                case "Carne de Peixe":
                    System.out.println("Leve e nutritivo! Fome restaurada em " + this.getValorNutricional() + " pontos.");
                    break;
                case "Carne Apodrecida":
                    System.out.println("Não parecia bom... mas matou a fome em " + this.getValorNutricional() + " pontos.");
                    break;
                case "Pote de Vaelra":
                    System.out.println("Um alimento raro e revigorante! Fome restaurada em " + this.getValorNutricional() + " pontos e sua mente se acalma (+10 Sanidade).");
                    int novaSanidade = (personagem.getSanidadePersonagem() + 10); // Limitar ao máximo se necessário
                    if (novaSanidade > personagem.getSanidadeInicialPersonagem()) {
                        throw new SanidadeAcimaDoLimiteException("A sanidade não pode ultrapassar o valor máximo!");
                    }
                    personagem.setSanidadePersonagem(novaSanidade);
                    break;
                case "Ramos Vegetais":
                    System.out.println("Simples, mas eficaz! Fome restaurada em " + this.getValorNutricional() + " pontos e você sente um pico de energia (+10 Energia).");
                    int novaEnergia = (personagem.getEnergiaPersonagem() + 10); // Limitar ao máximo se necessário
                    if (novaEnergia > personagem.getEnergiaInicialPersonagem()) {
                        throw new EnergiaAcimaDoLimiteException("A energia não pode ultrapassar o valor máximo!");
                    }
                    personagem.setEnergiaPersonagem(novaEnergia);
                    break;
                default:
                    System.out.println("Alimento de tipo desconhecido, mas restaurou " + this.getValorNutricional() + " pontos de fome.");
            }

            if (this.getPrazoValidade() >= 6) {
                System.out.println("Sua fome foi saciada!");
            } else {
                System.out.println("Apesar de saciar a fome, a comida não estava nas melhores condições...");
                personagem.setContaminacaoPersonagem(true);
                System.out.println("Você se sente nauseado. Melhor procurar um antídoto.");
                this.danoPorContaminacao(personagem);
            }
            System.out.println("Nível de Saciedade Atual: " + personagem.getFomePersonagem() + "/" + personagem.getFomeInicialPersonagem());
        } catch (FomeAcimaDoLimiteException e) {
            System.out.println("Aviso: " + e.getMessage());
            personagem.setFomePersonagem(personagem.getFomeInicialPersonagem());
        } catch (SanidadeAcimaDoLimiteException e) {
            System.out.println("Aviso: " + e.getMessage());
            personagem.setSanidadePersonagem(personagem.getSanidadeInicialPersonagem());
        } catch (EnergiaAcimaDoLimiteException e) {
            System.out.println("Aviso: " + e.getMessage());
            personagem.setEnergiaPersonagem(personagem.getEnergiaInicialPersonagem());
        }
    }
    private void danoPorContaminacao(Personagem personagem) {
        System.out.println("CONTAMINAÇÃO: Você sente os efeitos da comida estragada!");
        System.out.println("Você perderá 15 pontos de vida se não tomar um antídoto logo!");

        personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 15);
        System.out.println("Você perdeu 15 de vida devido à intoxicação.");

        if (personagem.getVidaPersonagem() <= 0) {
            System.out.println("Você sucumbiu à intoxicação alimentar!");
        }
    }
}
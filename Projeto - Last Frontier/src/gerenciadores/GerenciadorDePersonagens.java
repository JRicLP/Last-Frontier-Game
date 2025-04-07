package gerenciadores;
import interfaces.ManagerPersonagens;
import personagens.*;

public class GerenciadorDePersonagens implements ManagerPersonagens {
    String escolha;
    private Personagem personagem;
    public GerenciadorDePersonagens(String escolha, String personagem){
        this.escolha=escolha;
    }
    //Métodos acessores
    public void setEscolha(String escolha){
        this.escolha=escolha;
    }
    public String getEscolha(){
        return escolha;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    public Personagem getPersonagem(){
        return personagem;
    }

    @Override
    public void escolherPersonagem() {
        Personagem personagemEscolhido;
        switch(this.getEscolha()){
            case "Nômade":
                this.setPersonagem((new Nomade("Jack Nomad", 100, 100,65,
                        100, 100, "Vazio", "", "Possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas")));
                break;
            case "Pirata":
                this.setPersonagem((new Pirata("Scarlet Tempest ", 100, 100, 100, 85,
                        85, "Vazio ", " ", " Sobrevivente Nato e apto para pescaria ")));
                break;
            case "Infiltrador":
                this.setPersonagem((new Infiltrador( "Malik Ghost", 85, 65, 85,100,100,
                        " Vazio", " ", " Camuflagem, consegue invadir e conseguir comida e armas sem ser pego")));
                break;
            case "Explorador":
                this.setPersonagem((new Explorador("Logan Pathfinder", 85, 85, 65, 100, 85,
                        " Vazio", " ", "Rastreador, consegue achar comida e água mais rápido")));
                break;
            case "Cientista":
                this.setPersonagem((new Cientista(" Gearhead Martinez", 85, 85,100,100,85,
                        "Vazio", " ", "Mecânico, consegue consertar coisas e construir")));
                break;
            case "Caçador":
                this.setPersonagem((new Cacador(" Flynn Tracker", 100,100,65,85,85,
                        " Vazio", " ", "Lutador, consegue se defender muito bem")));
                break;
            default:
                System.out.println("Personagem não reconhecido, tente novamente");
                this.personagem=null;

            }

        }
}

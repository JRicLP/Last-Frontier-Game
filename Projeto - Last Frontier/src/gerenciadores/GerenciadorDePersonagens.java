package gerenciadores;
import interfaces.ManagerCharacters;
import personagens.*;

public class GerenciadorDePersonagens implements ManagerCharacters {
    String escolha;
    private Personagem personagem;
    public GerenciadorDePersonagens(){ //String escolha, String personagem
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
            case "Nômade" :
                this.setPersonagem((new Nomade("Possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas")));
                break;
            case "Pirata":
                this.setPersonagem((new Pirata("Sobrevivente Nato e apto para pescaria ")));
                break;
            case "Infiltrador":
                this.setPersonagem((new Infiltrador( "Camuflagem, consegue invadir e conseguir comida e armas sem ser pego")));
                break;
            case "Explorador":
                this.setPersonagem((new Explorador("Rastreador, consegue achar comida e água mais rápido")));
                break;
            case "Cientista":
                this.setPersonagem((new Cientista("Mecânico, consegue consertar coisas e construir")));
                break;
            case "Caçador":
                this.setPersonagem((new Cacador("Lutador, consegue se defender muito bem")));
                break;
            default:
                System.out.println("Personagem não reconhecido, tente novamente");
                this.personagem=null;

        }
    }

    @Override
    public void mostrarPersonagem() {
        System.out.println("Escolha um Personagem:");
        Nomade nomade = new Nomade("Possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas");
        Pirata pirata = new Pirata("Sobrevivente Nato e apto para pescaria");
        Infiltrador infiltrador = new Infiltrador("Camuflagem, consegue invadir e conseguir comida e armas sem ser pego");
        Explorador explorador = new Explorador("Rastreador, consegue achar comida e água mais rápido");
        Cientista cientista = new Cientista("Mecânico, consegue consertar coisas e construir");
        Cacador cacador = new Cacador("Lutador, consegue se defender muito bem");

        Personagem[] listaPersonagens = {nomade, pirata, infiltrador,explorador, cientista, cacador};

        System.out.println("-----------------------------------------------------------------------------");
        for (int contador = 0; contador < listaPersonagens.length; contador++) {
            System.out.println(listaPersonagens[contador].getNomePersonagem());
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Habilidades:");
        System.out.println("Nômade: " + nomade.getHabilidadeNomade());
        System.out.println("Pirata: " + pirata.getHabilidadePirata());
        System.out.println("Infiltrador: " + infiltrador.getHabilidadeInfiltrador());
        System.out.println("Explorador: " + explorador.getHabilidadeExplorador());
        System.out.println("Cientista: " + cientista.getHabilidadeCientista());
        System.out.println("Caçador: " + cacador.getHabilidadeCacador());
        System.out.println("-----------------------------------------------------------------------------");
    }
}
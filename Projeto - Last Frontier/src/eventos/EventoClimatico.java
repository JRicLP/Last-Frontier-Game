package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

public class EventoClimatico extends Evento {

    //Atributos da subclasse:
    private String tipoClima; //É necessário revisar a utilidade desse atributo
    private int duracaoClima; //Baseado no número de turnos
    private String efeitoClima; //É necessário revisar como esse atributo irá funcionar
    //Atributos de Impacto do Clima:
    private int impactoVida;
    private int impactoFome;
    private int impactoSede;
    private int impactoEnergia;
    private int impactoSanidade;
    //Construtor da Subclasse:
    public EventoClimatico(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento,
                           String tipoClima, int duracaoClima, String efeitoClima, int impactoVida, int impactoFome, int impactoSede, int impactoEnergia, int impactoSanidade) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoClima = tipoClima;
        this.duracaoClima = duracaoClima;
        this.efeitoClima = efeitoClima;
        this.impactoVida = impactoVida;
        this.impactoFome = impactoFome;
        this.impactoSede = impactoSede;
        this.impactoEnergia = impactoEnergia;
        this.impactoSanidade = impactoSanidade;
    }
    //Metodos Acessores da Classe:
    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }
    public String getTipoClima() {
        return tipoClima;
    }
    public void setDuracaoClima(int duracaoClima){
        this.duracaoClima = duracaoClima;
    }
    public int getDuracaoClima(){
        return duracaoClima;
    }
    public void setEfeitoClima(String efeitoClima){
        this.efeitoClima = efeitoClima;
    }
    public String getEfeitoClima(){
        return efeitoClima;
    }
    public void setImpactoVida(int impactoVida) {
        this.impactoVida = impactoVida;
    }
    public int getImpactoVida() {
        return impactoVida;
    }
    public void setImpactoFome(int impactoFome) {
        this.impactoFome = impactoFome;
    }
    public int getImpactoFome() {
        return impactoFome;
    }
    public void setImpactoSede(int impactoSede) {
        this.impactoSede = impactoSede;
    }
    public int getImpactoSede() {
        return impactoSede;
    }
    public void setImpactoEnergia(int impactoEnergia) {
        this.impactoEnergia = impactoEnergia;
    }
    public int getImpactoEnergia() {
        return impactoEnergia;
    }
    public void setImpactoSanidade(int impactoSanidade) {
        this.impactoSanidade = impactoSanidade;
    }
    public int getImpactoSanidade() {
        return impactoSanidade;
    }
    //Metodo Especial para Aplicação do Efeito Climático:
    public void aplicarImpactoDireto(Personagem personagem) {
        System.out.println(">> Efeitos do Clima: " + getNomeEvento() + " <<");

        boolean algumEfeitoAplicado = false;

        if (this.impactoVida != 0) {
            int vidaOriginal = personagem.getVidaPersonagem();
            personagem.setVidaPersonagem(vidaOriginal + this.impactoVida);
            // Garantir limites (0 e máximo)
            if (personagem.getVidaPersonagem() < 0) personagem.setVidaPersonagem(0);
            if (personagem.getVidaPersonagem() > personagem.getVidaInicialPersonagem()) personagem.setVidaPersonagem(personagem.getVidaInicialPersonagem());
            if (this.impactoVida < 0) System.out.println("O clima severo afeta sua saúde! Vida: " + this.impactoVida);
            else if (this.impactoVida > 0) System.out.println("Uma brisa revigorante! Vida: +" + this.impactoVida);
            algumEfeitoAplicado = true;
        }
        if (this.impactoFome != 0) {
            int fomeOriginal = personagem.getFomePersonagem();
            personagem.setFomePersonagem(fomeOriginal + this.impactoFome);
            if (personagem.getFomePersonagem() < 0) personagem.setFomePersonagem(0);
            if (personagem.getFomePersonagem() > personagem.getFomeInicialPersonagem()) personagem.setFomePersonagem(personagem.getFomeInicialPersonagem());
            if (this.impactoFome < 0) System.out.println("Você sente sua fome aumentar... Fome (Saciedade): " + this.impactoFome);
            else if (this.impactoFome > 0) System.out.println("O ar fresco abre seu apetite de forma agradável! Fome (Saciedade): +" + this.impactoFome);
            algumEfeitoAplicado = true;
        }
        if (this.impactoSede != 0) {
            int sedeOriginal = personagem.getSedePersonagem();
            personagem.setSedePersonagem(sedeOriginal + this.impactoSede);
            if (personagem.getSedePersonagem() < 0) personagem.setSedePersonagem(0);
            if (personagem.getSedePersonagem() > personagem.getSedeInicialPersonagem()) personagem.setSedePersonagem(personagem.getSedeInicialPersonagem());
            if (this.impactoSede < 0) System.out.println("O ar seco aumenta sua sede... Sede (Hidratação): " + this.impactoSede);
            else if (this.impactoSede > 0) System.out.println("Uma chuva fina alivia sua sede! Sede (Hidratação): +" + this.impactoSede);
            algumEfeitoAplicado = true;
        }
        if (this.impactoEnergia != 0) {
            int energiaOriginal = personagem.getEnergiaPersonagem();
            personagem.setEnergiaPersonagem(energiaOriginal + this.impactoEnergia);
            if (personagem.getEnergiaPersonagem() < 0) personagem.setEnergiaPersonagem(0);
            if (personagem.getEnergiaPersonagem() > personagem.getEnergiaInicialPersonagem()) personagem.setEnergiaPersonagem(personagem.getEnergiaInicialPersonagem());
            if (this.impactoEnergia < 0) System.out.println("O clima desgastante drena sua energia... Energia: " + this.impactoEnergia);
            else if (this.impactoEnergia > 0) System.out.println("Você se sente energizado pelo ambiente! Energia: +" + this.impactoEnergia);
            algumEfeitoAplicado = true;
        }
        if (this.impactoSanidade != 0) {
            int sanidadeOriginal = personagem.getSanidadePersonagem();
            personagem.setSanidadePersonagem(sanidadeOriginal + this.impactoSanidade);
            if (personagem.getSanidadePersonagem() < 0) personagem.setSanidadePersonagem(0);
            if (personagem.getSanidadePersonagem() > personagem.getSanidadeInicialPersonagem()) personagem.setSanidadePersonagem(personagem.getSanidadeInicialPersonagem());
            if (this.impactoSanidade < 0) System.out.println("A atmosfera opressora afeta sua mente... Sanidade: " + this.impactoSanidade);
            else if (this.impactoSanidade > 0) System.out.println("A beleza austera do local acalma seus nervos! Sanidade: +" + this.impactoSanidade);
            algumEfeitoAplicado = true;
        }

        if (!algumEfeitoAplicado) {
            System.out.println("O clima atual não parece ter um efeito notável em você neste momento.");
        }
    }

    @Override
    public void executar(Personagem personagemAfetado, Ambiente ambienteNoQualOcorre) {
        if (!this.isCondicaoEvento()) {
            return;
        }
        System.out.println("CLIMA: " + this.getNomeEvento() + " se manifesta em " + ambienteNoQualOcorre.getNomeAmbiente() + "!");
        System.out.println(this.getDescricaoEvento());

        aplicarImpactoDireto(personagemAfetado); // Passa apenas o personagem
    }
}

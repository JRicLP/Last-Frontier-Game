package itens;

import eventos.EventoCriatura;
import interfaces.AcoesArmas;
import personagens.Personagem;

import javax.swing.JOptionPane;

public class Arma extends Item implements AcoesArmas {

    private String tipoArma;
    private int danoArma;
    private int alcanceArma;

    public Arma(String nomeItem, int pesoItem, int durabilidadeItem, String tipoArma, int danoArma, int alcanceArma) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoArma = tipoArma;
        this.danoArma = danoArma;
        this.alcanceArma = alcanceArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setDanoArma(int danoArma) {
        this.danoArma = danoArma;
    }

    public int getDanoArma() {
        return danoArma;
    }

    public void setAlcanceArma(int alcanceArma) {
        this.alcanceArma = alcanceArma;
    }

    public int getAlcanceArma() {
        return alcanceArma;
    }

    @Override
    public void atacar(Personagem personagemEscolhido, EventoCriatura criaturaAtacada) {
        if (criaturaAtacada.getDistanciaCriatura() > this.getAlcanceArma()) {
            JOptionPane.showMessageDialog(null, "Essa criatura está fora do alcance!");
            return;
        }

        int dano = this.getDanoArma();
        criaturaAtacada.setVidaCriatura(criaturaAtacada.getVidaCriatura() - dano);
        personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 3);
        personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 3);
        personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 3);
        this.setDurabilidadeItem(this.getDurabilidadeItem() - 2);

        JOptionPane.showMessageDialog(null, String.format("""
                Você atacou a criatura: %s
                Dano causado: %d
                Vida restante da criatura: %d
                Sua vida: %d
                Durabilidade da arma: %d
                """,
                criaturaAtacada.getTipoCriatura(),
                dano,
                criaturaAtacada.getVidaCriatura(),
                personagemEscolhido.getVidaPersonagem(),
                this.getDurabilidadeItem()
        ));
    }
}

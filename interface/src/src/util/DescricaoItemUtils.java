package util;

import itens.*;

public class DescricaoItemUtils {

    public String gerarTextoCompleto(Item item) {
        StringBuilder sb = new StringBuilder();

        if (item instanceof Arma a) {
            sb.append("Dano: ").append(a.getDanoArma())
                    .append("\nDurabilidade: ").append(a.getDurabilidadeItem())
                    .append("\nTipo: ").append(a.getTipoArma())
                    .append("\nPeso: ").append(a.getPesoItem())
                    .append("\nAlcance: ").append(a.getAlcanceArma());
        } else if (item instanceof Ferramenta f) {
            sb.append("Durabilidade: ").append(f.getDurabilidadeItem())
                    .append("\nTipo: ").append(f.getTipoFerramenta())
                    .append("\nEficiência: ").append(f.getEficienciaFerramenta())
                    .append("\nPeso: ").append(f.getPesoItem());
        } else if (item instanceof Remedio r) {
            sb.append("Efeito: ").append(r.getEfeitoRemedio())
                    .append("\nTipo: ").append(r.getTipoRemedio())
                    .append("\nPeso: ").append(r.getPesoItem())
                    .append("\nDurabilidade: ").append(r.getDurabilidadeItem());
        } else if (item instanceof Alimento al) {
            sb.append("Tipo: ").append(al.getTipoAlimento())
                    .append("\nValor Nutricional: ").append(al.getValorNutricional())
                    .append("\nPeso: ").append(al.getPesoItem())
                    .append("\nValidade: ").append(al.getPrazoValidade());
        } else if (item instanceof Agua ag) {
            sb.append("Volume: ").append(ag.getVolumeAgua())
                    .append("\nPureza: ").append(ag.getPurezaAgua())
                    .append("\nPeso: ").append(ag.getPesoItem())
                    .append("\nDurabilidade: ").append(ag.getDurabilidadeItem());
        } else if (item instanceof Material m) {
            sb.append("Tipo: ").append(m.getTipoMaterial())
                    .append("\nResistência: ").append(m.getResistenciaMaterial())
                    .append("\nPeso: ").append(m.getPesoItem())
                    .append("\nDurabilidade: ").append(m.getDurabilidadeItem());
        }

        return sb.toString();
    }
}

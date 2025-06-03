package util;

import eventos.Evento;

public class DescricaoEventoUtils {
    public String gerarTextoCompletoEventos(Evento evento) {
        if (evento == null) return "Evento desconhecido.";
        return evento.getDescricaoEvento();
    }

}

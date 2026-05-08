package streamingmusica;

import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio;

    public PlaylistAutomatica(String nome, String descricao, String criterio) {
        super(nome, descricao);
        this.criterio = criterio;
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        musicas.clear();

        for (Musica musica : todasMusicas) {
            if (criterio.equalsIgnoreCase("top")) {
                if (musica.getReproducoes() >= 0) {
                    musicas.add(musica);
                }
            } else if (criterio.equalsIgnoreCase("recentes")) {
                musicas.add(musica);
            } else if (criterio.equalsIgnoreCase("rock")) {
                if (musica.getGenero().equalsIgnoreCase("rock")) {
                    musicas.add(musica);
                }
            }
        }
    }

    @Override
    public void reproduzir() {
        System.out.println("\n🤖 Playlist Automática: " + nome);
        System.out.println("📊 Critério: " + criterio);
        super.reproduzir();
    }

    public String getCriterio() {
        return criterio;
    }
}
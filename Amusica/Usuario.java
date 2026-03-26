import java.util.ArrayList;

public class Usuario {
    String nome;
    ArrayList<Playlist> playlists = new ArrayList<>();

    void criarPlaylist(String nome) {
        Playlist p = new Playlist();
        p.nome = nome;
        this.playlists.add(p);
    }

    Playlist getPlaylist(int indice) {
        if (indice >= 0 && indice < this.playlists.size()) {
            return this.playlists.get(indice);
        }
        return null;
    }

    void listarPlaylists() {
        if (this.playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
            return;
        }

        for (int i = 0; i < this.playlists.size(); i++) {
            System.out.println("[" + i + "] " + this.playlists.get(i).nome);
        }
    }
}
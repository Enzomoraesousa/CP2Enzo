import java.util.ArrayList;

public class Playlist {
    String nome;
    ArrayList<Musica> musicas = new ArrayList<>();

    void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    void removerMusica(int indice) {
        if (indice >= 0 && indice < this.musicas.size()) {
            this.musicas.remove(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    void listarMusicas() {
        if (this.musicas.isEmpty()) {
            System.out.println("Playlist vazia.");
            return;
        }

        for (int i = 0; i < this.musicas.size(); i++) {
            System.out.println("[" + i + "]");
            this.musicas.get(i).exibir();
        }
    }

    int getDuracaoTotal() {
        int total = 0;
        for (Musica m : this.musicas) {
            total += m.duracaoSegundos;
        }
        return total;
    }

    int getQuantidadeMusicas() {
        return this.musicas.size();
    }

    void exibirDetalhes() {
        System.out.println("Playlist: " + this.nome);
        System.out.println("Quantidade: " + getQuantidadeMusicas());

        int total = getDuracaoTotal();
        int min = total / 60;
        int seg = total % 60;

        System.out.println("Duração total: " + String.format("%02d:%02d", min, seg));
        listarMusicas();
    }
}
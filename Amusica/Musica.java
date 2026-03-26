public class Musica {
    String titulo;
    String artista;
    int duracaoSegundos;
    String genero;

    void exibir() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Duração: " + getDuracaoFormatada());
        System.out.println("Gênero: " + this.genero);
        System.out.println("---------------------------");
    }

    String getDuracaoFormatada() {
        int minutos = this.duracaoSegundos / 60;
        int segundos = this.duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    boolean contemTitulo(String busca) {
        return this.titulo.toLowerCase().contains(busca.toLowerCase());
    }

    boolean contemArtista(String busca) {
        return this.artista.toLowerCase().contains(busca.toLowerCase());
    }
}

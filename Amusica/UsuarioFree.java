public class UsuarioFree extends Usuario {

    
    private static final int MAX_PLAYLISTS = 3;
    private int contadorReproducoes;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
        this.contadorReproducoes = 0;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;

        if (contadorReproducoes % 3 == 0) {
            exibirAnuncio();
        }

        super.reproduzirMusica(musica);
    }

    @Override
    public void criarPlaylist(String nome) {
        if (playlists.size() >= MAX_PLAYLISTS) {
            System.out.println("❌ Limite atingido!");
            return;
        }

        super.criarPlaylist(nome);
    }

    private void exibirAnuncio() {
        System.out.println("\n📢 ANÚNCIO: Assine Premium!\n");
    }
}

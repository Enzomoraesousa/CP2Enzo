import java.util.*;

public class Streaming {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuario = new Usuario();

    public static void main(String[] args) {
        usuario.nome = "Usuário";

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING DE MÚSICA ===");
            System.out.println("1. Cadastrar música");
            System.out.println("2. Listar músicas");
            System.out.println("3. Buscar música");
            System.out.println("4. Criar playlist");
            System.out.println("5. Gerenciar playlists");
            System.out.println("0. Sair");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite um número válido!");
                sc.nextLine();
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> cadastrarMusica();
                case 2 -> listarMusicas();
                case 3 -> buscarMusica();
                case 4 -> criarPlaylist();
                case 5 -> gerenciarPlaylists();
            }

        } while (opcao != 0);
    }

    static void cadastrarMusica() {
        Musica m = new Musica();

        System.out.print("Título: ");
        m.titulo = sc.nextLine();

        System.out.print("Artista: ");
        m.artista = sc.nextLine();

        System.out.print("Duração (segundos): ");
        m.duracaoSegundos = sc.nextInt();
        sc.nextLine();

        System.out.print("Gênero: ");
        m.genero = sc.nextLine();

        musicas.add(m);
        System.out.println("Música cadastrada com sucesso!");
    }

    static void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println("[" + i + "]");
            musicas.get(i).exibir();
        }
    }

    static void buscarMusica() {
        System.out.print("Buscar: ");
        String busca = sc.nextLine();

        boolean encontrou = false;

        for (Musica m : musicas) {
            if (m.contemTitulo(busca) || m.contemArtista(busca)) {
                m.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }

    static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = sc.nextLine();
        usuario.criarPlaylist(nome);
        System.out.println("Playlist criada!");
    }

    static void gerenciarPlaylists() {
        int op;

        do {
            System.out.println("\n=== PLAYLISTS ===");
            System.out.println("1. Listar playlists");
            System.out.println("2. Adicionar música");
            System.out.println("3. Remover música");
            System.out.println("4. Detalhes");
            System.out.println("0. Voltar");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite um número válido!");
                sc.nextLine();
                op = -1;
            }

            switch (op) {
                case 1 -> usuario.listarPlaylists();

                case 2 -> {
                    usuario.listarPlaylists();
                    System.out.print("Escolha playlist: ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    Playlist pl = usuario.getPlaylist(p);

                    if (pl == null) {
                        System.out.println("Playlist inválida!");
                        break;
                    }

                    listarMusicas();
                    System.out.print("Escolha música: ");
                    int m = sc.nextInt();
                    sc.nextLine();

                    if (m >= 0 && m < musicas.size()) {
                        pl.adicionarMusica(musicas.get(m));
                        System.out.println("Música adicionada!");
                    } else {
                        System.out.println("Música inválida!");
                    }
                }

                case 3 -> {
                    usuario.listarPlaylists();
                    System.out.print("Playlist: ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    Playlist pl = usuario.getPlaylist(p);

                    if (pl == null) {
                        System.out.println("Playlist inválida!");
                        break;
                    }

                    pl.listarMusicas();
                    System.out.print("Índice: ");
                    int i = sc.nextInt();
                    sc.nextLine();

                    pl.removerMusica(i);
                }

                case 4 -> {
                    usuario.listarPlaylists();
                    System.out.print("Playlist: ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    Playlist pl = usuario.getPlaylist(p);

                    if (pl == null) {
                        System.out.println("Playlist inválida!");
                        break;
                    }

                    pl.exibirDetalhes();
                }
            }

        } while (op != 0);
    }
}
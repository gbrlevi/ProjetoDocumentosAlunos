import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //caso inicial
        Directory matriculas = new Directory("matriculas");
        Directory m10101515 = new Directory("10101515");
        matriculas.addChild(m10101515);
        m10101515.addChild(new SingleFile("Certidao_de_Nascimento.jpg"));
        m10101515.addChild(new SingleFile("Historico.pdf"));
        Directory ano2015 = new Directory("2015");
        m10101515.addChild(ano2015);
        ano2015.addChild(new SingleFile("Mapa_de_Notas.pdf"));

        boolean loop = true;

        while (loop) {
            System.out.println("Insira 1 para aluno veterano, 2 para aluno novato ou 0 para encerrar o processo");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Insira a matrícula que deseja visualizar");
                scanner.nextLine();
                String matricula = scanner.nextLine();
                Directory directory = searchDirectory(matriculas, matricula);
                if (directory != null) {
                    listarConteudo(directory, "");
                } else {
                    System.out.println("Matrícula não encontrada");
                }
            } else if (choice == 2) {
                System.out.println("Insira a matrícula do novo aluno");
                scanner.nextLine();
                String novaMatricula = scanner.nextLine();
                Directory novoAluno = new Directory(novaMatricula);
                matriculas.addChild(novoAluno);
                System.out.println("Nova matrícula " + novaMatricula + " adicionada com sucesso");
            }
            else if (choice == 0){
                loop = false;
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }
    //método para encontrar e verificar a pasta inserida
    public static Directory searchDirectory(Directory parent, String name) {
        for (File file : parent.getChild()) {
            if (file.isDirectory() && file.getName().equals(name)) {
                return (Directory) file;
            }
        }
        return null;
    }

    //método para apresentar o conteudo da pasta
    public static void listarConteudo(Directory dir, String prefix) {
        System.out.println(prefix + dir.getName());
        for (File file : dir.getChild()) {
            if (file.isFile()) {
                System.out.println(prefix + "  " + file.getName());
            } else if (file.isDirectory()) {
                listarConteudo((Directory) file, prefix + "  ");
            }
        }
    }
}

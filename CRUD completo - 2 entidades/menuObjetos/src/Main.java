import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Main {

    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n==== Secretaria ====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        System.out.println("3 - Sair");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                menuAlunos();
                break;
            case "2":
                menuTurmas();
                break;
            case "3":
                System.out.println("Até breve...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuPrincipal();
        }
    }

    private static void menuTurmas() {
        System.out.println("\n==== Turmas ====");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turma");
        System.out.println("3 - Atualizar Turma");
        System.out.println("4 - Excluir Turma");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarTurmas();
                menuTurmas();
                break;
            case "2":
                cadastrarTurma();
                menuTurmas();
                break;
            case "3":
                atualizarTurma();
                menuTurmas();
                break;
            case "4":
                excluirTurma();
                menuTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuTurmas();
        }
    }

    private static void menuAlunos() {
        System.out.println("\n==== Alunos ====");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Atualizar Aluno");
        System.out.println("4 - Excluir Aluno");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarAlunos();
                menuAlunos();
                break;
            case "2":
                cadastrarAluno();
                menuAlunos();
                break;
            case "3":
                atualizarAluno();
                menuAlunos();
                break;
            case "4":
                excluirAluno();
                menuAlunos();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuAlunos();
        }
    }

    // --- MÉTODOS DA TURMA ---

    private static void cadastrarTurma() {
        Periodo periodo = validarPeriodo();
        String curso = validarCurso();
        String sigla = validarSigla();

        Turma turma = new Turma(curso, sigla, periodo);
        listaTurmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    private static void listarTurmas() {
        if(isVazio(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }
        System.out.println("\nLista de Turmas:");
        for(Turma t : listaTurmas){
            if (t.isAtivo())
                System.out.println(t);
        }
    }

    private static void atualizarTurma() {
        if(isVazio(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();
        int idAtualizar = validaIdTurma();

        System.out.printf("O período atual é: %s", listaTurmas.get(idAtualizar).getPeriodo());
        atualizarParcial("período", idAtualizar);

        System.out.printf("O curso atual é: %s", listaTurmas.get(idAtualizar).getCurso());
        atualizarParcial("curso", idAtualizar);

        System.out.printf("A sigla atual é: %s", listaTurmas.get(idAtualizar).getSigla());
        atualizarParcial("sigla", idAtualizar);
    }

    private static void excluirTurma() {
        if(isVazio(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();
        int idExcluir = validaIdTurma();

        if (confirmaExclusao()){
            listaTurmas.get(idExcluir).setAtivo(false);
            System.out.println("Turma excluída com sucesso!");
        }
    }

    private static void atualizarParcial(String atributo, int idAtualizar){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcao = Leitura.dados("\nDeseja modificar "+ atributo +" ? (S/N): ").toUpperCase();
            switch (opcao) {
                case "S":
                    switch (atributo){
                        case "período":
                            Periodo periodo = validarPeriodo();
                            listaTurmas.get(idAtualizar).setPeriodo(periodo);
                            break;
                        case "curso":
                            String curso = validarCurso();
                            listaTurmas.get(idAtualizar).setCurso(curso);
                            break;
                        case "sigla":
                            String sigla = validarSigla();
                            listaTurmas.get(idAtualizar).setSigla(sigla);
                            break;
                    }
                    System.out.println(atributo + " atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
            }
        }
    }

    private static boolean isVazio(ArrayList<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) return true;
        for (Turma turma : listaTurmas){
            if (turma.isAtivo()) return false;
        }
        return true;
    }

    private static int validarItemLista(String opcao) {
        if (opcao.isBlank()) return -1;
        int opcaoNumero = -1;
        try{
            opcaoNumero = Integer.parseInt(opcao);
        } catch (NumberFormatException e) {
            return -1;
        }
        int indiceLista = opcaoNumero-1;
        return indiceLista >= 0 && listaTurmas.size() > indiceLista ? indiceLista : -1;
    }

    private static void listarTurmasIndiceSigla() {
        System.out.println("\nLista das Turmas:");
        for (int i=0;i<listaTurmas.size();i++){
            if (listaTurmas.get(i).isAtivo())
                System.out.printf("%d - %s\n",i+1, listaTurmas.get(i).getSigla());
        }
    }

    private static int validaIdTurma() {
        String opcao = Leitura.dados("\nDigite o número da turma desejada: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida==-1){
            opcaoUsuario = validarItemLista(opcao);
            if (opcaoUsuario==-1) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = Leitura.dados("Digite o número da turma desejada: ");
            } else {
                opcaoValida = opcaoUsuario;
            }
        }
        return opcaoValida;
    }

    private static String validarSigla() {
        String sigla = Leitura.dados("Digite a sigla: ");
        while(!validarSigla(sigla)){
            System.out.println("Sigla inválida! Precisa conter texto e não pode ser repetida");
            sigla = Leitura.dados("Digite a sigla: ");
        }
        return sigla;
    }

    private static boolean validarSigla(String sigla) {
        if (sigla.isBlank()) return false;
        for (Turma turma : listaTurmas){
            if (turma.getSigla().equals(sigla)){
                return false;
            }
        }
        return true;
    }

    private static String validarCurso() {
        String curso = Leitura.dados("Digite o curso: ");
        while(!isCharacter(curso)) {
            System.out.println("Nome de curso inválido! Não use números ou caracteres especiais, por favor");
            curso = Leitura.dados("Digite o curso: ");
        }
        return curso;
    }

    private static boolean isCharacter(String texto) {
        String textoSemNumeros = texto.replaceAll("\\d", "");
        return !texto.isBlank() && texto.equals(textoSemNumeros);
    }

    private static Periodo validarPeriodo() {
        String opcaoPeriodo = Leitura.dados("""
                Digite o número do período escolhido:
                1 - Matutino
                2 - Vespertino
                3 - Noturno
                4 - Integral""");
        switch (opcaoPeriodo){
            case "1": return Periodo.MATUTINO;
            case "2": return Periodo.VESPERTINO;
            case "3": return Periodo.NOTURNO;
            case "4": return Periodo.INTEGRAL;
            default:
                System.out.println("Opção inválida, digite novamente");
                return validarPeriodo();
        }
    }

    private static boolean confirmaExclusao() {
        while (true) {
            String confirma = Leitura.dados("Você tem certeza? (S/N): ").toUpperCase();
            switch (confirma) {
                case "S": return true;
                case "N": return false;
                default: System.out.println("Opção inválida, digite S para sim ou N para não!");
            }
        }
    }


    // --- MÉTODOS DO ALUNO ---

    private static void cadastrarAluno() {
        System.out.println("\n-- Cadastro de Aluno --");
        Turma turma = selecionarTurmaParaAluno();

        // Interrompe o cadastro se não existir turma disponível
        if (turma == null) return;

        String nome = validarNomeAluno();
        LocalDate dataNascimento = validarDataNascimento();

        Aluno novoAluno = new Aluno(nome, dataNascimento, turma);
        listaAlunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        if (isVazioAlunos(listaAlunos)) {
            System.out.println("Não há alunos cadastrados ou ativos.");
            return;
        }
        System.out.println("\nLista de Alunos:");
        for (Aluno a : listaAlunos) {
            if (a.isAtivo()) {
                System.out.println(a);
            }
        }
    }

    private static void atualizarAluno() {
        if (isVazioAlunos(listaAlunos)) {
            System.out.println("Não há alunos cadastrados para atualizar.");
            return;
        }

        listarAlunosIndiceNome();
        int idAtualizar = validaIdAluno();
        Aluno aluno = listaAlunos.get(idAtualizar);

        System.out.println("Atualizando os dados de: " + aluno.getNome());

        String atualizarNome = Leitura.dados("Deseja modificar o nome? (S/N): ").toUpperCase();
        if (atualizarNome.equals("S")) {
            aluno.setNome(validarNomeAluno());
        }

        String atualizarData = Leitura.dados("Deseja modificar a data de nascimento? (S/N): ").toUpperCase();
        if (atualizarData.equals("S")) {
            aluno.setDataNascimento(validarDataNascimento());
        }

        String atualizarTurma = Leitura.dados("Deseja transferir de turma? (S/N): ").toUpperCase();
        if (atualizarTurma.equals("S")) {
            Turma novaTurma = selecionarTurmaParaAluno();
            if(novaTurma != null) aluno.setTurma(novaTurma);
        }

        System.out.println("Dados do aluno atualizados com sucesso!");
    }

    private static void excluirAluno() {
        if (isVazioAlunos(listaAlunos)) {
            System.out.println("Não há alunos cadastrados para excluir.");
            return;
        }

        listarAlunosIndiceNome();
        int idExcluir = validaIdAluno();

        if (confirmaExclusao()) {
            listaAlunos.get(idExcluir).setAtivo(false);
            System.out.println("Aluno excluído (remoção lógica) com sucesso!");
        }
    }

    private static String validarNomeAluno() {
        while (true) {
            String nome = Leitura.dados("Digite o nome completo do aluno: ");

            if (nome.isBlank()) {
                System.out.println("Erro: O nome não pode ser vazio ou conter apenas espaços.");
                continue;
            }

            if (!nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
                System.out.println("Erro: O nome não pode conter números ou caracteres especiais.");
                continue;
            }

            return nome;
        }
    }

    private static LocalDate validarDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String dataStr = Leitura.dados("Digite a data de nascimento (dd/mm/aaaa): ");
            try {
                LocalDate dataNascimento = LocalDate.parse(dataStr, formatter);
                long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());

                if (idade < 14) {
                    System.out.println("Erro: O aluno precisa ter pelo menos 14 anos.");
                } else if (idade > 130) {
                    System.out.println("Erro: O aluno não pode ter mais de 130 anos.");
                } else {
                    return dataNascimento;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Erro: Data inválida! Use estritamente o formato dd/mm/aaaa.");
            }
        }
    }

    private static Turma selecionarTurmaParaAluno() {
        if (isVazio(listaTurmas)) {
            System.out.println("Não há turmas ativas cadastradas. Cadastre uma turma primeiro!");
            return null;
        }

        listarTurmasIndiceSigla();
        while (true) {
            int idTurma = validaIdTurma();
            Turma turmaSelecionada = listaTurmas.get(idTurma);

            if (!turmaSelecionada.isAtivo()) {
                System.out.println("Erro: Esta turma não está ativa. Escolha uma turma válida.");
            } else {
                return turmaSelecionada;
            }
        }
    }

    private static boolean isVazioAlunos(ArrayList<Aluno> lista) {
        if (lista.isEmpty()) return true;
        for (Aluno aluno : lista) {
            if (aluno.isAtivo()) return false;
        }
        return true;
    }

    private static void listarAlunosIndiceNome() {
        System.out.println("\nSelecione o Aluno:");
        for (int i = 0; i < listaAlunos.size(); i++) {
            if (listaAlunos.get(i).isAtivo()) {
                System.out.printf("%d - %s (Turma: %s)\n", i + 1, listaAlunos.get(i).getNome(), listaAlunos.get(i).getTurma().getSigla());
            }
        }
    }

    private static int validaIdAluno() {
        String opcao = Leitura.dados("\nDigite o número correspondente ao aluno: ");
        int opcaoValida = -1;
        while (opcaoValida == -1) {
            int opcaoNumero = -1;
            try {
                opcaoNumero = Integer.parseInt(opcao);
            } catch (NumberFormatException e) {
                // ignora e trata no if abaixo
            }

            int indice = opcaoNumero - 1;

            if (indice >= 0 && indice < listaAlunos.size() && listaAlunos.get(indice).isAtivo()) {
                opcaoValida = indice;
            } else {
                System.out.println("Opção inválida! Digite novamente.");
                opcao = Leitura.dados("Digite o número correspondente ao aluno: ");
            }
        }
        return opcaoValida;
    }
}
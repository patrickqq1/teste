import java.util.ArrayList;

abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void FazerAniversario() {
        this.idade++;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Idade: " + this.idade;
    }
}

class Disciplina {
    private String codigo;
    private String nome;
    private int semestre;

    public Disciplina(String codigo, String nome, int semestre) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Visitante extends Pessoa {
    public Visitante(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
    }

}

class Aluno extends Pessoa {
    private String matricula;
    private Disciplina disciplina;

    public Aluno(String nome, String cpf, int idade){
        super(nome, cpf, idade);
        this.matricula = "";
        this.disciplina = null;
    }

// Suggested code may be subject to a license. Learn more: ~LicenseLog:4159122988.
    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno(String nome, String cpf, int idade, String matricula, Disciplina disciplina) {
        super(nome, cpf, idade);
        this.matricula = matricula;
        this.disciplina = disciplina;
    }

    public void pagarMensalidade() {
        System.out.println("Aluno " + this.getNome() + " pagou a mensalidade da disciplina " + this.disciplina.getNome() + ".");
    }
}

class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, String cpf, int idade, String especialidade) {
        super(nome, cpf, idade);
        this.especialidade = especialidade;
    }

    public void darAula() {
        System.out.println("Professor " + this.getNome() + " dar aula na disciplina " + this.especialidade + ".");
    }
}

class Bolsista extends Aluno {
    private Disciplina disciplina;

    public Bolsista(String nome, String cpf, int idade, String matricula, Disciplina disciplina) {
        super(nome, cpf, idade, matricula, disciplina);
        this.disciplina = disciplina;
    }

    @Override
    public void pagarMensalidade(){
        System.out.println("Bolsista " + this.getNome() + " pagou a mensalidade da disciplina " + this.disciplina.getNome() + ".");
    }
}

class Regular extends Aluno {
    private Disciplina disciplina;

    public Regular(String nome, String cpf, int idade, String matricula, Disciplina disciplina) {
        super(nome, cpf, idade, matricula, disciplina);
        this.disciplina = disciplina;
    }

    @Override
    public void pagarMensalidade(){
        System.out.println("Aluno " + this.getNome() + " pagou a mensalidade da disciplina " + this.disciplina.getNome() + ".");
    }
}

class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<Aluno>();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public Professor getProfessor() {
        return this.professor;
    }

// Suggested code may be subject to a license. Learn more: ~LicenseLog:2167523536.
    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    public void listarAlunos() {
        System.out.println("Alunos da turma " + this.codigo + ":");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Instanciando disciplinas
        Disciplina matematica = new Disciplina("001", "Matematica", 4);
        Disciplina portugues = new Disciplina("002", "Portugues", 4);

        // Instanciando alunos
        Aluno regular1 = new Regular("João", "12345678901", 18, "12345", matematica);
        Aluno regular2 = new Regular("Maria", "98765432101", 19, "54321", portugues);
        Aluno bolsista1 = new Bolsista("Pedro", "45678901234", 20, "67890", matematica);

        // Instanciando professores
        Professor professor1 = new Professor("Carlos", "11111111111", 40, "Matematica");
        Professor professor2 = new Professor("Ana", "22222222222", 35, "Portugues");

        // Instanciando visitantes
        Visitante visitante1 = new Visitante("Visitante 1", "33333333333", 25);

        // Instanciando turmas
        Turma turma1 = new Turma("A", matematica, professor1);
        Turma turma2 = new Turma("B", portugues, professor2);

        // Adicionando alunos à turmas
        turma1.adicionarAluno(regular1);
        turma1.adicionarAluno(regular2);
        turma2.adicionarAluno(bolsista1);

        // Listando alunos da turma A
        turma1.listarAlunos();

        // Pagando mensalidades dos alunos da turma A
        for (Aluno aluno : turma1.getAlunos()) {
            aluno.pagarMensalidade();
        }

        // Dar aula ao professor
        professor1.darAula();
    }
}

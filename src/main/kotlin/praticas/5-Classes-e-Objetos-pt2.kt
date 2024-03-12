open class Funcionario(val nome: String, val idade: Int){
    init {
        println("Novo funcionário cadastrado! Bem-vindo ${this.nome} e seus ${this.idade} de experiência de vida")
    }

    open fun apresentar(){
        println("Olá meu nome é ${this.nome} e tenho ${this.idade}")
    }
}

// Classe Gerente herda de Funcionario e adiciona a propriedade setor
class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade){
    override fun apresentar(){
        println("Olá meu nome é ${this.nome} e tenho ${this.idade} e sou ${this.setor}")
    }
}

// Classe Desenvolvedor herda de Funcionario e adiciona a propriedade linguagem
class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade){
    override fun apresentar(){
        println("Olá meu nome é ${this.nome} e tenho ${this.idade} e sou ${this.linguagem}")
    }
}

// Classe Analista herda de Funcionario e adiciona a propriedade area
class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade){
    override fun apresentar(){
        println("Olá meu nome é ${this.nome} e tenho ${this.idade} e sou ${this.area}")
    }
}

fun main() {
    val listaDeFuncionarios: MutableList<Funcionario> = mutableListOf()
    val gerente =   Gerente("Márcio",21,"Gerência")
    val desenvolvedor = Desenvolvedor("Caio",23, "Java")
    val analista = Analista("Allan", 19, "Desenvolvimento")
    listaDeFuncionarios.add(gerente)
    listaDeFuncionarios.add(desenvolvedor)
    listaDeFuncionarios.add(analista)
    listaDeFuncionarios.forEach { println(it.nome) }

    listaDeFuncionarios.forEach{it.apresentar()}


    for (funcionario in listaDeFuncionarios) {
        // Verifica o tipo do funcionário usando 'is'
        if (funcionario is Gerente) {
            val gerente: Gerente? = funcionario as? Gerente
            gerente?.let {
                val setor: String? = it.setor
                println("O gerente ${it.nome} trabalha no setor $setor")
                println(gerente.javaClass)
            }
        } else if (funcionario is Desenvolvedor) {
            val desenvolvedor: Desenvolvedor? = funcionario as? Desenvolvedor
            desenvolvedor?.let {
                val linguagem: String? = it.linguagem
                println("O desenvolvedor ${it.nome} trabalha com $linguagem")
                println(desenvolvedor.javaClass)
            }
        } else if (funcionario is Analista) {
            val analista: Analista? = funcionario as? Analista
            analista?.let {
                val area: String? = it.area
                println("O analista ${it.nome} trabalha na área $area")
                println(analista.javaClass)
            }
        }
    }
}

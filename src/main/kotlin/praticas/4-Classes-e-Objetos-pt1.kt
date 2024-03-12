// Questão 1
class Produto (var nome: String = "Produto", var preco: Double = 0.0) {

    // Implemente os construtores conforme especificado na questão
}

//fun main() {
//
//}

// Questão 2
class Cliente {
    public var nome: String = ""
    private var idade: Int = 30

    fun mostrarIdade():Int{
        return idade
    }

}

//fun main() {
//
//}

// Questão 3
abstract class Personagem {
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        println("Guerreiro está atacando com a espada")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        println("Mago está lançando um feitiço")
    }
}

//fun main() {
//
//    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
//}

// Questão 4
interface FormaGeometrica {
    fun calcularArea():Double
    // Declare um método abstrato calcularArea() conforme especificado na questão
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        return largura * altura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        return 3.14 * raio * raio
    }
}

//fun main() {
//
//}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""
        get() = field.capitalize()
    var saldo: Double = 0.0
        set(value) {
            if(value < 0){
                field = 0.0
            }else{
                field = value
            }
        }
}

fun main() {
    //questão 1

    val produto1 = Produto() // sem argumentos
    val produto2 = Produto("MousePad")
    val produto3 = Produto("Teclado",100.00)

    println("${produto3.nome}  ${produto3.preco}")
    println("${produto2.nome}  ${produto2.preco}")
    println("${produto1.nome}  ${produto1.preco}")
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    // </questão 1>

    // <questão 2>
    var cliente = Cliente()
    cliente.nome = "Márcio"

    println(cliente.mostrarIdade())
    // </questão 2>


    //<questão 3>
    var guerreiro = Guerreiro()
    var mago = Mago()

    mago.atacar()
    guerreiro.atacar()
    // </questão 3>


    //  <questão 4>
    var circulo = Circulo(2.0)
    println(circulo.calcularArea())
    var retangulo = Retangulo(5.0,3.0)
    println(retangulo.calcularArea())
    // </questão 4>

// </questão 5>
    var contaBancaria = ContaBancaria()
    contaBancaria.nomeTitular = "marcio"
    contaBancaria.numeroConta = "40028922"
    contaBancaria.saldo = -1.0
// </questão 5>
    println("Número da conta: ${contaBancaria.numeroConta}, Nome do titular: ${contaBancaria.nomeTitular}, Saldo: ${contaBancaria.saldo}")
}

/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}


/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * 
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia: String) {
    if (!materiasENotas.containsKey(materia)) {
        println("Matéria $materia não encontrada")
    } else {
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            var soma = 0.0
            for (nota in listaNotas) {
                println("Nota $cont: $nota")
                soma += nota
                cont++
            }
            val media = soma / listaNotas.size
            println("Média: $media")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia")
        }
        println()
    }
}

fun mostrarNotasDisciplina(materia: String) {
    println("Notas da disciplina $materia:")
    mostrarNotas(materia)
}


/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(materia: String): Double? {
    val notasDaMateria = materiasENotas[materia]

    return notasDaMateria?.let { notas ->
        if (notas.isNotEmpty()) {
            val soma = notas.sum()
            soma / notas.size
        } else {
            null
        }
    }
}
/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg notas: Double) {
    for (nota in notas) {
        adicionarNota(materia, nota)
    }
}


fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    val notasMatematica = mutableListOf(8.00)
    adicionarDisciplina("Matemática", notasMatematica)
    
    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia="Português", notas=notasMatematica)
    
    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("História")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 8.5)
    adicionarNota("Matemática", 9.0)
    adicionarNota("Matemática", 7.5)

    adicionarNota("Português", 7.0)
    adicionarNota("Português", 6.5)
    adicionarNota("Português", 8.0)

    adicionarNota("História", 9.2)
    adicionarNota("História", 8.0)
    adicionarNota("História", 7.5)
    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("Português")
    mostrarNotas("História")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Física")
    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Física", 7.5, 8.0, 9.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Física")
    
    // Bônus: (Não vai ganhar nada, ou melhor vai ganhar mais conhecimento >:O)
    // 11: calcularMedia -> Implemente a função calcularMedia()
    // 12: calcularMedia -> calcule a media de 2 disciplinas
    calcularMedia("Física")
    calcularMedia("Português")
    
    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    // 14: mostrarNotas -> mostre as notas de 1 disciplina 
    mostrarNotasDisciplina("Matemática")
}

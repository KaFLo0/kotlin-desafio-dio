enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)  // Adicionamos um atributo 'nome' à classe Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    // Adicionamos informações adicionais, como descrição e tópicos
    var descricao: String = ""
    var topicos: List<String> = listOf()
}

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Adiciona o usuário à lista de inscritos
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    // Método para adicionar conteúdos à formação
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome.")
    }
}

fun main() {
    // Criação de objetos
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90)

    val formacao = Formacao("Desenvolvimento Kotlin", mutableListOf(conteudo1, conteudo2))

    // Operações
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Exibição de informações
    println("Formação: ${formacao.nome}")
    println("Conteúdos: ${formacao.conteudos}")
    println("Inscritos: ${formacao.inscritos}")
}
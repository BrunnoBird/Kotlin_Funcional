//Variavel de tipo função
fun main(args: Array<String>) {
    testaFuncaoReferencia()
    testaFuncaoClasse()
    testaFuncaoLambda()
    testaFuncaoAnonima()
}

private fun testaFuncaoLambda() {
    //Não conseguimos reutilizar a lógica com lambda e anonima
    val minhaFuncaoLambda: () -> Unit = {
        println("executa como lambda")
    }
    println(minhaFuncaoLambda())
}

private fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima: () -> Unit = fun() {
        println("executa como anonima")
    }
    println(minhaFuncaoAnonima())
}

private fun testaFuncaoClasse() {
    val minhaFuncaoClasse: () -> Unit = Teste()
    val testeClasse2: () -> Unit = Teste2()
    val testeClasse2Value = Teste2()

    println(minhaFuncaoClasse())
    testeClasse2Value(10)
    testeClasse2()
}

private fun testaFuncaoReferencia() {
    //:: = referencia da função e não sua execução
    val minhaFuncaoReferencia: () -> Unit = ::teste

    println(minhaFuncaoReferencia())
}

fun teste() {
    println("executa teste variavel")
}

class Teste : () -> Unit {
    override fun invoke(): Unit = println("executa invoke do teste classe")
}

class Teste2 : () -> Unit {

    operator fun invoke(valor: Int){
        println(valor)
    }

    override fun invoke() {
        println("executa invoke do Teste2")
    }
}
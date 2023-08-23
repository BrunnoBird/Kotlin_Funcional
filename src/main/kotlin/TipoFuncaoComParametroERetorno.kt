fun main(args: Array<String>) {
    testaFuncaoReferencia()
    testaFuncaoClasse()
    testaFuncaoLambda()
    testaFuncaoAnonima()
    testaFuncaoLambdaRetornoMultiplo()
    testaFuncaoAnonimaRetornoMultiplo()
}

private fun testaFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()

    println(minhaFuncaoClasse(5, 10))
}

private fun testaFuncaoReferencia() {
    //:: = referencia da função e não sua execução
    val minhaFuncaoReferencia: (Int, Int) -> Int = ::soma

    println(minhaFuncaoReferencia(3, 5))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}

// Maior uso, do que anonima pois predomina
private fun testaFuncaoLambda() {
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        a + b
    }

    val minhaFuncaoLambdaInferida = { a: Int, b: Int ->
        a + b
    }

    println(minhaFuncaoLambda(10, 20))
}


//Situacoes nas quais queremos deixar claro oque queremos colocar como parametro, retorno e qual é o escopo de execucao do código (mais explicita de uma expressao lambda)
private fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        return a + b
    }

    val minhaFuncaoAnonimaInferida = fun(a: Int, b: Int): Int {
        return a + b
    }

    println(minhaFuncaoAnonima(30, 10))
}

private fun testaFuncaoLambdaRetornoMultiplo() {
    //Colocando labels para identificar onde ele vai fazer o return
    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50
        }

        //Implicito (sempre retorna ultima instrucao)
        salario + 100.0

        //  Explicito
        //  return@lambda it + 100.0
    }

    println(calculaBonificacao(1000.0))
}

private fun testaFuncaoAnonimaRetornoMultiplo() {
    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario: Double) : Double {
        if (salario > 1000.0) {
            return salario + 50
        }

        return salario + 100.0
    }

    println(calculaBonificacaoAnonima(2000.0))
}

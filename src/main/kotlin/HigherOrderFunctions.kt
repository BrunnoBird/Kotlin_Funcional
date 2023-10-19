import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun main(args: Array<String>) {

    testaHOF()

//    val endereco = Endereco(logradouro = "rua vergueiro", 3132)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

//    Endereco(logradouro = "rua vergueiro", 3132).let { endereco ->
//        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//        //Pegando o retorno do maiusculo e mandando para o println referenciado.
//    }.let(::println)


//    listOf<Endereco>(
//        Endereco(complemento = "casa"),
//        Endereco(),
//        Endereco(complemento = "apartamento")
//    )
//        .filter { enderecoFiltrado -> enderecoFiltrado.complemento.isNotEmpty() }
//        .let(::println)
}

fun testaHOF() {
    soma(1, 5, (::println))
    soma(1, 5, { valor -> println(valor) })

    somaReceiver(1, 5, (::println))
    somaReceiver(1, 5, { println(this) })
    somaReceiver(1, 5, resultado = {
        println(this)
    })

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int): Boolean = this.senha == senha
    }
    val sistema = SistemaInterno()
    sistema.entraReceiver(autenticavel, 1234, autenticado = {
        pagamento()
    })
}


//  Introdução

//fun main() {
//    testeFirstClass {}
//
//    testeFirstClassSemLambda({}, 1)
//}

//  Higher Order Function = Função que recebe outra função ou devolve outra função.
//fun testeFirstClass(bloco: () -> Unit) {}

//  Para conseguirmos usar lambda a função deve-se estar como ultimo valor.
//fun testeFirstClassSemLambda(bloco: () -> Unit, valor: Int) {}


fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    resultado(a + b)
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    val total = a + b
    //Ou mandar como uma extensão deste modo:
    total.resultado()
    //podemos fazer assim: resultado(a + b)
}
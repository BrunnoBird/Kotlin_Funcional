fun main(args: Array<String>) {
//    val endereco = Endereco(logradouro = "rua vergueiro", 3132)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    Endereco(logradouro = "rua vergueiro", 3132).let { endereco ->
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        //Pegando o retorno do maiusculo e mandando para o println referenciado.
    }.let(::println)




    listOf<Endereco>(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    )
        .filter { enderecoFiltrado -> enderecoFiltrado.complemento.isNotEmpty() }
        .let(::println)
}

class Endereco(var logradouro: String? = null, var numero: Int? = null, var complemento: String = "")




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
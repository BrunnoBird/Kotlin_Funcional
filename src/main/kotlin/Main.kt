import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco

fun main(args: Array<String>) {

}

private fun testaComRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12

    val contaPoupanca = ContaPoupanca(Cliente("Alex", cpf = "111.111.111-11", senha = 1234), 1000)
    contaPoupanca.run {
        deposita(1000.0).also { println(saldo) }
        saldo * taxaMensal
    }.let { rendimentoMensal -> println("rendimento mensal: $rendimentoMensal") }

    run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo.also { println("rendimento anual: $saldo") }
    }
}

fun testaComWith() {
    with(Endereco()) {
        logradouro = "rua vergueiro"
        numero = 3132
        bairro = "Vila mariana"
        cidade = "São paulo"
        estado = "SP"
        cep = "312323-31"
        complemento = "Apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}
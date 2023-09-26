fun main(args: Array<String>) {


    soma(1, 5) { valor ->
        println(valor)
    }

    soma(2, 5, resultado = { valor ->
        println(valor)
    })

    soma(5, 5, resultado = (::println))
}

//Semelhante aos Listeners do Android.
fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("Soma sendo efetuada")
    resultado(a + b)
}
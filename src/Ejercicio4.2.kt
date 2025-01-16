import kotlin.math.pow

class Persona(var peso: Double, var altura: Double) {
    var nombre: String = ""
    val imc: Double
        get() = peso / altura.pow(2)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', peso=$peso, altura=$altura, imc=$imc)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return peso == other.peso && altura == other.altura && nombre == other.nombre
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + peso.hashCode()
        result = 31 * result + altura.hashCode()
        return result
    }
}

fun main() {
    val persona1 = Persona(70.5, 1.75)
    val persona2 = Persona("Ana", 65.0, 1.68)
    val persona3 = Persona("Carlos", 80.0, 1.82)

    println("Personas creadas:")
    println(persona1)
    println(persona2)
    println(persona3)

    println("\nModificando nombre de persona1:")
    do {
        print("Introduce un nombre para persona1 (no puede ser nulo o vacío): ")
        val nuevoNombre = readLine()
        if (!nuevoNombre.isNullOrEmpty()) {
            persona1.nombre = nuevoNombre
            break
        }
    } while (true)

    println("\nDatos de persona1:")
    println("Nombre: ${persona1.nombre}, Peso: ${persona1.peso}, Altura: ${persona1.altura}")

    println("\nDatos de persona3:")
    println("Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${persona3.imc}")

    persona3.altura = 1.80
    println("\nDatos actualizados de persona3:")
    println("Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${persona3.imc}")

    persona2.altura = persona3.altura
    println("\nPersona2 y Persona3 después de igualar alturas:")
    println(persona2)
    println(persona3)

    println("\n¿Son persona2 y persona3 iguales? ${persona2 == persona3}")
}
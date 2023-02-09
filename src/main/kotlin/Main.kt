import org.jetbrains.kotlinx.spark.api.dsOf
import org.jetbrains.kotlinx.spark.api.reduceK
import org.jetbrains.kotlinx.spark.api.withSpark
import java.io.Serializable
import java.math.BigDecimal
import java.math.RoundingMode.HALF_EVEN
import kotlin.random.Random

fun main(args: Array<String>) {
    withSpark(appName = "Example Spark-Kotlin-Gradle project") {
        println("Staring example Kotlin-Spark project")
        println("Program arguments: ${args.joinToString()}")
        val randomPrices = (0..args.first().toInt())
            .map { Price(randomBigDecimal()) }
            .toTypedArray()
        spark
            .dsOf(*randomPrices)
            .reduceK { price, price2 -> Price(price.priceInDollars + price2.priceInDollars) }
            .let { println("Sum of random prices: ${it.priceInDollars.setScale(2, HALF_EVEN)}$") }
    }
}

private fun randomBigDecimal() = Random.nextDouble(0.0, 99.99).toBigDecimal()

data class Price(val priceInDollars: BigDecimal): Serializable {
    operator fun plus(secondSummand: Price): Price {
        return Price(this.priceInDollars + secondSummand.priceInDollars)
    }
}

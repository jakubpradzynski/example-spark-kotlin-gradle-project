import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PriceTest : ShouldSpec({
    should("sum two prices") {
        // GIVEN
        val firstPriceInBigDecimal = BigDecimal.ONE
        val secondPriceInBigDecimal = BigDecimal.TEN
        val firstPrice = Price(firstPriceInBigDecimal)
        val secondPrice = Price(secondPriceInBigDecimal)

        // WHEN
        val priceSum = firstPrice + secondPrice

        // THEN
        priceSum.priceInDollars shouldBe (firstPriceInBigDecimal + secondPriceInBigDecimal)
    }
})

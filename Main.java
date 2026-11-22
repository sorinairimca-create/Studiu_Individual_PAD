import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        MathContext mc = new MathContext(40, RoundingMode.HALF_UP);

        BigDecimal depunere = new BigDecimal("500");
        BigDecimal rataAnuala = new BigDecimal("0.07");
        BigDecimal rataLunara = rataAnuala.divide(
            new BigDecimal("12"), mc);

        int luni = 20 * 12;

        BigDecimal factor = BigDecimal.ONE.add(rataLunara)
                .pow(luni, mc);

        BigDecimal suma = depunere.multiply(
            factor.subtract(BigDecimal.ONE)
            .divide(rataLunara, mc));

        BigDecimal totalDepus = depunere.multiply(
            new BigDecimal(luni));

        suma = suma.setScale(2, RoundingMode.HALF_UP);
        totalDepus = totalDepus.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Suma acumulata: " + suma + " lei");
        System.out.println("Total depus: " + totalDepus + " lei");
    }
}

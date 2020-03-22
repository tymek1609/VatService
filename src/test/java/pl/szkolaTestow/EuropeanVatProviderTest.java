package pl.szkolaTestow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.szkolaTestow.Product.Type;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class EuropeanVatProviderTest {

    @Test
    void shouldReturn5PercentageForBooksInPoland() {
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();

        //when
        BigDecimal polishBooksVat = vatProvider.getVatFor("Poland", Type.BOOK);

        //then
        assertThat(polishBooksVat).isEqualTo(new BigDecimal("0.05"));
    }

    @Test
    void shouldReturnExceptionWhenChooseUnexistingCountry(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //then
        Assertions.assertThrows(CountryNotSupportedException.class, () ->{
            vatProvider.getVatFor("Spain", Type.BOOK);
        });
    }

    @Test
    void shouldReturnSetWhichContainsOneValueForAllDanishProducts(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //when
        Set<BigDecimal> set = new HashSet<BigDecimal>(){{
            add(vatProvider.getVatFor("Denmark", Type.BOOK));
            add(vatProvider.getVatFor("Denmark", Type.BABY));
            add(vatProvider.getVatFor("Denmark", Type.FOOD));
            add(vatProvider.getVatFor("Denmark", Type.CLOTHES));
            add(vatProvider.getVatFor("Denmark", Type.GAMES));
            add(vatProvider.getVatFor("Denmark", Type.GAMES));
            add(vatProvider.getVatFor("Denmark", Type.SHOES));
        }};
        //then
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    void shouldReturn8PercentageForGermanClothes(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //when
        BigDecimal germanVatForClothes = vatProvider.getVatFor("Germany", Type.CLOTHES);
        //then
        assertThat(germanVatForClothes).isEqualTo("0.10");
    }

    @Test
    void shouldReturn4PercentageForGermanFood(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //when
        BigDecimal germanVatForClothes = vatProvider.getVatFor("Germany", Type.FOOD);
        //then
        assertThat(germanVatForClothes).isEqualTo("0.04");
    }

    @Test
    void shouldReturn21PercentageForGermanGames(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //when
        BigDecimal germanVatForClothes = vatProvider.getVatFor("Germany", Type.GAMES);
        //then
        assertThat(germanVatForClothes).isEqualTo("0.21");
    }
    @Test
    void shouldReturn23PercentageForPolishGames(){
        //given
        EuropeanVatProvider vatProvider = new EuropeanVatProvider();
        //when
        BigDecimal germanVatForClothes = vatProvider.getVatFor("Poland", Type.GAMES);
        //then
        assertThat(germanVatForClothes).isEqualTo("0.23");
    }
}
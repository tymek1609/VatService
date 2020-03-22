package Vat;

import Product.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VatRepositoryTest {

    @Test
    void shouldThrowExceptionWhenCountryIsIncorrect() {
        //given
        VatRepository repositoryToTest = new VatRepository();

        //when
        Exception exception = assertThrows(VatNotFoundException.class,
                () -> repositoryToTest.getVatFor("Poland111", Type.BOOK));

        //then
        assertThat(exception.getMessage()).isEqualTo("Vat for country Poland111 and product type BOOK was not found");
    }
    
	@Test
	void shouldReturnTheSameSizeOfSetWhenAddExistingObj(){
		//given
		VatRepository repositoryToTest = new VatRepository();
		
		//when
		int sizeBefore = repositoryToTest.vatValues.size();
		repositoryToTest.addVatValue( "Poland", Type.BOOK, new BigDecimal( "0.05" ) );
		int sizeAfter = repositoryToTest.vatValues.size();
		//then
		assertThat( sizeAfter - sizeBefore ).isEqualTo( 0 );
		
	}
}
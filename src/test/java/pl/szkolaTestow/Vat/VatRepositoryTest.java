package pl.szkolaTestow.Vat;

import pl.szkolaTestow.Product.Type;
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
	void shouldAddNewPositionInFakeRepo() throws VatNotFoundException
    {
	    //given
	    VatRepository repositoryToTest = new VatRepository();
	    
	    //when
	    int sizeBefore = repositoryToTest.vatValues.size();
	    repositoryToTest.addVatValue( "Germany", Type.BOOK, new BigDecimal( "0.04" ) );
	    int sizeAfter = repositoryToTest.vatValues.size();
	    //then
	    assertThat( repositoryToTest.getVatFor( "Germany",  Type.BOOK) );
	    assertThat( sizeAfter - sizeBefore ).isEqualTo( 1 );
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
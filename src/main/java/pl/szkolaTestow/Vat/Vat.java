package pl.szkolaTestow.Vat;

import pl.szkolaTestow.Product.Type;

import java.math.BigDecimal;
import java.util.Objects;

public class Vat {
    String country;
    Type productType;
    BigDecimal amount;

    public Vat(String country, Type productType, BigDecimal amount) {
        this.country = country;
        this.productType = productType;
        this.amount = amount;
    }
	
	@Override
	public boolean equals( Object o )
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Vat vat = (Vat) o;
		return country.equals( vat.country ) &&
		       productType == vat.productType &&
		       amount.equals( vat.amount );
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash( country, productType, amount );
	}
}

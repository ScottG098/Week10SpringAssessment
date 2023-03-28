package Week10.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Mar 28, 2023
 */
@Data
@NoArgsConstructor
@Entity
public class House {
	@Id
	@GeneratedValue
	private long id;
	private String address;
	private int numOfBeds;
	private int numOfBaths;
	private boolean forSale;
	
}

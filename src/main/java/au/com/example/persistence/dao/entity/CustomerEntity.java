package au.com.example.persistence.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class CustomerEntity implements Cloneable {
	
	private Long id;
	private String firstName;
	private String lastName;
	
	public CustomerEntity() {
		this(null, null, null);
	}
	
	public CustomerEntity(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(generator = "CustomerSeq")
	@SequenceGenerator(name = "CustomerSeq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name = "customer_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	
	// ====== Cloneable Override =========

	@Override
	public CustomerEntity clone() {
		return new CustomerEntity(id, firstName, lastName);
	}

	// ====== Overrides ========


    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
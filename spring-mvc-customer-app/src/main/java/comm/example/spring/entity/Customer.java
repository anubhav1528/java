package comm.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@NonNull
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	//@Range(min = 5, max = 10)
	private String firstName;
	//@Range(min = 5, max = 10)
	@Column(name = "last_name")
	private String lastName;
	//@javax.validation.constraints.Email
	@Column(name = "email")
	private String email;
	
	
	public Customer() {
		super();
	}


	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

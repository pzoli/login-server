package hu.infokristaly.loginserver.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Cacheable(value=true)
@Table(name="client", indexes= {@Index(name="idx_name",columnList="name")})
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
    
    private static final long serialVersionUID = 8642042154423794249L;

    private Long id;
	private String name;

	public Client() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false)
	@Basic
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return Objects.equals(id, client.id) && Objects.equals(name, client.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
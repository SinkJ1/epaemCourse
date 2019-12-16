package by.senla.practics.model;

import by.senla.practics.enums.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

	private static final long serialVersionUID = -6482454008708191446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "user_name")
	private String name;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n" + "User [id=" + id + ", name=" + name + "]" + "\n";
	}

}

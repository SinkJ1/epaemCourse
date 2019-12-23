package by.task4.practics.entity;

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
	
	@Column(name = "user_login")
	private String login;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_role")
	private Role role;

	/*@OneToMany(fetch = FetchType.LAZY mappedBy = "user")
	private Set<Order> order;*/
	
	public User() {
	}
	
	public User(Integer id, String name, String login, String password, Role role) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}

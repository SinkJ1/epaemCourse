package by.task4.practics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.task4.practics.entity.User;
import by.task4.practics.enums.Role;
import by.task4.practics.services.UserService;
import by.task4.practics.services.UserServiceImpl;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractController<User> {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "index";
	}

	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> login(@RequestBody User user) {
		User bdUser = userService.findByLogin(user);
		if (bdUser != null) {
			return ResponseEntity.ok(findPage(bdUser));
		}
		return ResponseEntity.ok("");
	}

	@PostMapping(value = "/registration", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<String>> registration(@RequestBody User user) {
		List<String> returnPage = new ArrayList<>();
		returnPage.add("test.jsp");
		return ResponseEntity.ok(returnPage);
	}

	private String findPage(User user) {

		Map<Role, String> pages = new HashMap<Role, String>();
		pages.put(Role.USER, "UserPage.jsp");
		pages.put(Role.ADMIN, "UserPage.jsp");
		return pages.get(user.getRole());
	}

}

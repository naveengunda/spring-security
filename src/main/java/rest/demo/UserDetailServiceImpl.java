package rest.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import rest.demo.model.User;
import rest.demo.service.UserService;

/**
 * naveengunda59
 */
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = service.getUserDetail(username);

		if (user == null ) {
			throw new UsernameNotFoundException("User Not found");
		}
		Set<SimpleGrantedAuthority> authories = new HashSet<>();
		authories.add(new SimpleGrantedAuthority("ADMIN"));
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authories);
	}

}

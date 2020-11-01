package com.vargas.DockerComposePractica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vargas.DockerComposePractica.models.User;
import com.vargas.DockerComposePractica.models.UserAuthDetails;
import com.vargas.DockerComposePractica.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
    	user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		List<String> roles = Arrays.stream(user.get().getRoles().split(",")).map(String::new)
                .collect(Collectors.toList());
		return new UserAuthDetails(user.get(), roles);
	}
}

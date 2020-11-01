package com.vargas.DockerComposePractica.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

public class UserAuthDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
	
	public UserAuthDetails(User user, List<String> roles) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active   = user.isActive();
        
        String rolesToString= StringUtils.collectionToCommaDelimitedString(roles);  
        this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(rolesToString);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}

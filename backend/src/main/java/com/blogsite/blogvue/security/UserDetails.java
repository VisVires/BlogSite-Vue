package com.blogsite.blogvue.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetails {
	 UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

package com.bolsaideas.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
/*seguridad[5]*/
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

/*se inyecta la implementacion de UsuarioService*/
    @Autowired
    private UserDetailsService usuarioService;

    @Bean/*envriptar contraseña*/
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /*reglas de seguridad de las rutas, de los metodos Http por el lado de spring*/
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()/*cualquier peticion requiere autenticacion*/
                .and()
                .csrf().disable()/*se dehabilita porque se usara el token en vez de las sesiones de spring*/
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}

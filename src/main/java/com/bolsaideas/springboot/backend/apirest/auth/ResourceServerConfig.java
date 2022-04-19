package com.bolsaideas.springboot.backend.apirest.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/*seguridad[8]*/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /*reglas de seguridad de las rutas, de los metodos Http por el lado de oath*/

    @Override/*hasta aca probar en postman*/
    public void configure(HttpSecurity http) throws Exception {                                     /*cualquiera podra ver las fotos*/
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/clientes","/api/clientes/page/**","/api/uploads/img/**", "/images/**").permitAll()
/*los mismos permisos para clientes/{id} y clietnes/uplaod porque al detalle se accede medientras el id del cliente*/
                .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")/*ruta de upload(subir iamgen)*/
                .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")/*hasRole un rol*/
                .antMatchers("/api/clientes/**").hasRole("ADMIN")/*lo que queda del crud put y delete son para ADMIN*/
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource());


    }
    @Bean
    /*importar de import org.springframework.web.cors.CorsConfigurationSource;*/
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));/*cabeceraS*/

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    /*crear filtro y le pasamos la configuracion del metodo  CorsConfigurationSource*/
    @Bean                      /*import org.springframework.web.filter.CorsFilter;*/
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}

package be.vdab.cultuurhuis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USERS_BY_USERNAME =
            "select gebruikersnaam as username, paswoord as password, actief as enabled" +
                    " from klanten where gebruikersnaam = ?";

    @Bean
    JdbcDaoImpl jdbcDaoImpl(DataSource dataSource) {
        JdbcDaoImpl impl = new JdbcDaoImpl();
        impl.setDataSource(dataSource);
        impl.setUsersByUsernameQuery(USERS_BY_USERNAME);
        return impl;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .mvcMatchers("/images/**")
                .mvcMatchers("/css/**")
                .mvcMatchers("/js/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login").defaultSuccessUrl("/")
                .and().authorizeRequests()
                .mvcMatchers("/**", "/login").permitAll()
                .mvcMatchers("/**").authenticated();
    }

}

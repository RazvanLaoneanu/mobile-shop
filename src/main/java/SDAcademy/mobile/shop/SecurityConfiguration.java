//package SDAcademy.mobile.shop;
//
//import SDAcademy.mobile.shop.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .formLogin().defaultSuccessUrl("/")
////                .loginPage("/login").failureUrl("/login?error")
////                .permitAll().and().logout()
////                .logoutSuccessUrl("/login?logout").logoutUrl("/logout")
////                .permitAll().and().authorizeRequests().antMatchers("/")
////                .permitAll().anyRequest().authenticated().and();
////
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return  NoOpPasswordEncoder.getInstance();
//    }
//}
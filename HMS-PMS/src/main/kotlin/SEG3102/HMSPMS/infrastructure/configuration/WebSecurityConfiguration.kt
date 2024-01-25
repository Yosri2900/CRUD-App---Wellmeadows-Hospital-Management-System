package SEG3102.HMSPMS.infrastructure.configuration

import SEG3102.HMSPMS.infrastructure.security.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(private val userDetailsService: UserDetailsServiceImpl) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }
            .formLogin {formLogin -> formLogin.loginPage("/login").permitAll().
            defaultSuccessUrl("/", true) }
            .logout { logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()}

        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring()
                .requestMatchers("/resources/**",  "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**") }
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
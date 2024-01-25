package SEG3102.HMSPMS.infrastructure.security

import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val username: String,
    val email: String,
    @field:JsonIgnore private val password: String,
    private val enabled: Boolean,
    private val authorities: Collection<GrantedAuthority>): UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }


    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

}

fun build(user: StaffAccountDocument): UserDetailsImpl {
    val authorities = ArrayList<GrantedAuthority>()
    authorities.add(SimpleGrantedAuthority(user.jobTitle))
    return UserDetailsImpl(
        user.username,
        user.email,
        user.password,
        user.enabled,
        authorities)
}
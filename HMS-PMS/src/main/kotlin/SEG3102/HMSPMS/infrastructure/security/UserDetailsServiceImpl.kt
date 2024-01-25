package SEG3102.HMSPMS.infrastructure.security

import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import SEG3102.HMSPMS.infrastructure.mongodb.repos.AccountsMongoRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.StaffMongoRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(val accountsMongoRepository: AccountsMongoRepository): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user: StaffAccountDocument = accountsMongoRepository.findByUsername(username) ?:
        throw  UsernameNotFoundException("User username: $username not found")
        return build(user)
    }
}
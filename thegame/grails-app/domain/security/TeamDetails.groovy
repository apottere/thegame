package security

import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 */
class TeamDetails extends Team {

    String teamName
    static mapWith="mongo"

//    TeamDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
 //           Collection<GrantedAuthority> authorities, long id, String teamName) {
 //
 //       super(username, password, enabled, accountNonExpired,
 //               credentialsNonExpired, accountNonLocked, authorities, id)

 //       this.teamName = teamName
 //   }
}

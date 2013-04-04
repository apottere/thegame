package security

import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 */
class TeamDetails extends Team {

    String teamName
    //static mapWith="mongo"

    int status

    //Map<BigDecimal, Date> checkpointsCleared

    public int currentStatus() {
        return checkpointsCleared.keySet().max()
    }
}

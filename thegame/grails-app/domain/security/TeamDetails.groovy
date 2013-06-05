package security

import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 */
class TeamDetails extends Team {

    //String teamName
    static mapWith="mongo"

    Map<String, Date> checkpointsCleared

    public int currentStatus() {

        if (!checkpointsCleared) {
            checkpointsCleared = ["1": new Date()]
            this.save()
        }
        return checkpointsCleared.keySet().max() as int
    }

    def beforeUpdate(){
        if(TeamDetails.get(id).password != password){
            encodePassword()
        }
    }

}

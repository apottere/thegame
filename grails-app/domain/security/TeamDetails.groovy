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
        return checkpointsCleared.keySet().collect{it as int}.max()//because keys are strings, max() has to be done on their integer forms
    }

    def beforeUpdate(){
        if(TeamDetails.get(id).password != password){
            encodePassword()
        }
    }

}

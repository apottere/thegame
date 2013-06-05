package thegame

import security.TeamDetails

class IndexController {

    def springSecurityService

    def index() {
        def team = springSecurityService.currentUser
        //[team : team]
        def allTeams = TeamDetails.getAll()
        [team: team, allTeams : allTeams]
        //render(view: "index", model: [team: team])


    }
}

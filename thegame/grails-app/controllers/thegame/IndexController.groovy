package thegame

import security.TeamDetails

class IndexController {

    def index() {
        def team = security.TeamDetails.get(1)
        //[team : team]
        def allTeams = TeamDetails.getAll()
        [team: team, allTeams : allTeams]
        //render(view: "index", model: [team: team])


    }
}

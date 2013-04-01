package thegame

class IndexController {

    def index() {
        def team = security.TeamDetails.get(1)
        render(view: "index", model: [team: team])


    }
}

package thegame

class hudController {

    def springSecurityService
    def pageService

    def index() {
        render("Webpage!")
    }

    def viewPage() {
        int pageNumber = params.page as Integer ?: (springSecurityService.currentUser).currentStatus()
        Map model = [
            displayPage: pageService.readPage(pageNumber)
        ]

        render(view: "story", model: model)
    }
}

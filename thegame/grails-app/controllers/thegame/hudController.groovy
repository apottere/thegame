package thegame

class hudController {

    def springSecurityService
    def pageService

    def index() {
        render("Webpage!")
    }

    def viewPage() {
        int pageNumber = params.page ?: (springSecurityService.currentUser).currentStatus()
        Map model = [displayPage: pageService.readPage(pageNumber)]

        return model
    }
}

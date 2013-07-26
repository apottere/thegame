package thegame

class hudController {

    def springSecurityService
    def pageService
    def puzzleService

    def index() {
        render("Webpage!")
    }

    def viewPage() {
        int pageNumber = params.page as Integer ?: (springSecurityService.currentUser).currentStatus()
        Map model = [
            displayPage: pageService.readPage(pageNumber),
            wrong: params.wrong
        ]

        render(template: "story", model: model)
    }

    def answerPuzzle() {
        int pageNumber = params.pageNumber as int
        if (puzzleService.submitAnswer(params.code, pageNumber)) {
            redirect(controller: "/", params: [page: pageNumber+1])
        } else {
            redirect(controller: "/", params: [page: pageNumber, wrong: true])
        }
    }
}

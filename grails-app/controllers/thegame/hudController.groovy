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

        render(view: "story", model: model)
    }

    def answerPuzzle() {
        int pageNumber = params.pageNumber as int
        if (puzzleService.submitAnswer(params.code, pageNumber)) {
            redirect(action: "viewPage", params: [page: pageNumber++])
        } else {
            redirect(action: "viewPage", params: [page: pageNumber, wrong: true])
        }
    }
}

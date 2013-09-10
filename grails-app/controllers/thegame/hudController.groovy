package thegame

class hudController {

    def springSecurityService
    def pageService
    def puzzleService

    def index() {
        render("Webpage!")
    }

    def chapter() {
        int pageNumber = params.page as Integer ?: (springSecurityService.currentUser).currentStatus()
        DisplayPage displayPage = pageService.readPage(pageNumber)
        Map model = [
            displayPage: displayPage,
            wrong: params.wrong,
            isFinalPage: displayPage.pageNumber == StoryPage.count()
        ]

        render(template: "story", model: model)
    }

    def answerPuzzle() {
        int pageNumber = params.pageNumber as Integer
        if (puzzleService.submitAnswer((String)params.answer, pageNumber)) {
            flash.success = true
            redirect(uri: "/")
        } else {
            redirect(controller: "/", fragment: "answer", params: [wrong: true])
        }
    }
}

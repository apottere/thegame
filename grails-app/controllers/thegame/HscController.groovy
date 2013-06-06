package thegame

class HscController{

    def addSolution(){
        Solution solution = new Solution()
        solution.pageNumber = params.getInt("pageNumber")
        solution.code = params.code
        solution.save()
        render("Saved pageNumber ${solution.pageNumber}, code ${solution.code}")
    }

    def puzzleService
    def testSolution(){
        def result = puzzleService.submitAnswer(params.testCode, params.getInt("pageNumber"), params.teamName)

        render("Result $result")
    }
}

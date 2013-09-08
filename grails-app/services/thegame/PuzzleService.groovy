package thegame

import security.TeamDetails

class PuzzleService {

    def springSecurityService
    public StoryPage readPage(int pageNumber, String teamId) {
        return new StoryPage(
                pageNumber: 0,
                title: "Access Denied",
                intro: "Stop trying to look ahead"
        )
    }

    public boolean submitAnswer(String answer, int pageNumber) {
        TeamDetails team = springSecurityService.currentUser

        if(!team?.checkpointsCleared?.containsKey(Integer.toString(pageNumber))){
            return false
        }

        List<Solution> solution = Solution.findAllByPageNumber(pageNumber)
        boolean correct = solution.any{it.code.equalsIgnoreCase(answer)} //if any solution matches the answer
        if (correct) {
            String checkpoint = (pageNumber + 1).toString()
            team.checkpointsCleared = team.checkpointsCleared ?: [:]
            if(!team.checkpointsCleared.containsKey(checkpoint)){
                team.checkpointsCleared.put(checkpoint, new Date())
                team.save(flush:true)
            }
        }
        return correct
    }
}

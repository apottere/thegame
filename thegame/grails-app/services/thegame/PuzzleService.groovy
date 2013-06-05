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

    public boolean submitAnswer(String code, int pageNumber, String teamName) {
        def team = springSecurityService.currentUser

        TeamDetails teamDetails = TeamDetails.findByTeamName(teamName)
        String key = pageNumber.toString()
        if(teamDetails.id != team?.id){
            return false
        }
        if(![0,1].contains(pageNumber) && !teamDetails?.checkpointsCleared?.containsKey(Integer.toString(pageNumber - 1))){
            return false
        }

        Solution solution = Solution.findByPageNumber(pageNumber)
        boolean correct = solution.code.equalsIgnoreCase(code)
        if (correct) {
            teamDetails.checkpointsCleared = teamDetails.checkpointsCleared ?: [:]
            if(!teamDetails.checkpointsCleared.containsKey(key)){
                teamDetails.checkpointsCleared.put(key, new Date())
                teamDetails.save(flush:true)
            }

        }
        return correct
    }
}

package thegame

import security.TeamDetails

class PuzzleService {

    public StoryPage readPage(int pageNumber, String teamId) {
        return new StoryPage(
                pageNumber: 0,
                title: "Access Denied",
                intro: "Stop trying to look ahead"
        )
    }

    public boolean submitAnswer(String code, int pageNumber, String teamName) {

        TeamDetails teamDetails = TeamDetails.findByTeamName(teamName)
        if(![0,1].contains(pageNumber) && !teamDetails?.checkpointsCleared?.containsKey(pageNumber - 1)){
            return false
        }

        Solution solution = Solution.findByPageNumber(pageNumber)
        boolean correct = solution.code.equalsIgnoreCase(code)
        if (correct) {
            teamDetails.checkpointsCleared = teamDetails.checkpointsCleared ?: [:]
            teamDetails.checkpointsCleared.put(pageNumber.toString(), new Date())

            teamDetails.save(flush:true)

        }
        return correct
    }
}

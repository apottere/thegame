package thegame

class PuzzleService {

    public StoryPage readPage(int pageNumber, String teamId) {
        return new StoryPage(
                pageNumber: 0,
                title: "Access Denied",
                intro: "Stop trying to look ahead"
        )
    }

    public boolean submitAnswer(String code, int pageNumber, String teamName) {
        boolean correct = Solution.findByPageNumberAndCode(pageNumber, code)
        if (correct) {
            Team team = Team.findByName(teamName)
            team.checkpointsCleared.put([(pageNumber): new Date()])
        }
        return correct
    }
}

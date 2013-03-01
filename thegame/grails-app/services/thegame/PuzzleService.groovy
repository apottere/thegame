package thegame

class PuzzleService {

    public StoryPage readPage(int pageNumber, String teamId) {
        return new StoryPage(
                pageNumber: 0,
                title: "Access Denied",
                intro: "Stop trying to look ahead"
        )
    }

    public boolean submitAnswer(String code, int status, String teamId) {
        return true
    }
}

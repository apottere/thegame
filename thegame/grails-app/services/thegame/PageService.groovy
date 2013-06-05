package thegame

import security.TeamDetails

class PageService {

    def springSecurityService

    DisplayPage readPage(int pageNumber) {

        TeamDetails team = springSecurityService.currentUser
        DisplayPage page = new DisplayPage(
                pageNumber: pageNumber,
                maxPage: team.currentStatus()
        )

        if (pageNumber <= page.maxPage) {
            StoryPage storyPage = StoryPage.findByPageNumber(pageNumber)
            page.title = storyPage.title
            page.revealedText = [storyPage.intro]
            long start = team.checkpointsCleared.get(pageNumber).time
            long end
            if (pageNumber < page.maxPage) {
                end = team.checkpointsCleared.get(pageNumber+1).time
            } else {
                end = new Date().time
                long next = storyPage.timelockedText.keySet().find{it > end}
                if (next) {
                    page.nextReveal = new Date(next)
                }
            }
            page.revealedText.addAll(timelockedText(start, end, storyPage))
        } else {
            page.title = 'Access Denied'
            page.revealedText = ['Your attempts to look into the future are of no avail.']
        }

        return page
    }

    private List<String> timelockedText(long start, long end, StoryPage storyPage) {
        List<String> text = []
        for (entry in storyPage.timelockedText) {
            if (start + entry.key < end) {
                text.add(entry.value)
            }
        }
        return text
    }
}

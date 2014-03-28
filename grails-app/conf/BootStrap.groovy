import security.TeamDetails
import thegame.StoryPage
import thegame.Solution

class BootStrap {

    def init = { servletContext ->

        //def admin = {
            if (!TeamDetails.count()) {
                new TeamDetails(username:"team1", password:"team1", teamName:"Mama Loves Her Little Alien", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team2", password:"team2", teamName:"Tastes Like Chicken", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team3", password:"team3", teamName:"Alien Armageddon", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team4", password:"team4", teamName:"Team Cheats a Lot", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team5", password:"team5", teamName:"Aliens Love Chicken", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team6", password:"team6", teamName:"Just Have to Outrun the Aliens", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new TeamDetails(username:"team7", password:"team7", teamName:"Earthlings for America", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
            }
        // }


        if (!StoryPage.count()) {
            new StoryPage(pageNumber: 1,
                title: "Staring into Space",
                intro: "<p>It was just another routine day for your team of new recruits in the Deepspace Detection Corps. "
                    +"There was chatter from Ceti Alpha V about the crowning of their new Kahn. Tensions were on the rise again between "
                    +"the twin planets of Binar. Some asteroid miner was under arrest for defacing the rings of Zetan. Routine stuff really.</p>"
                    +"<h3>*PING*</h3><p>That's odd. There's another signal you don't recognize. It's a language you've never seen before, perhaps some "
                    +"sort of code. And it looks like it's coming from ... earth orbit?! There aren't any ships scheduled.  You need to get this to "
                    +"the Head of Alien Reconnaissance on the double!</p>",
                timelockedText: [
                        "0":"Sadly you don't actually know your way around that well, yet. You should stop by the Information Desk.",
                        "60000":"Your past determines your future. Watch your step.",
                        "90000":"Final path revealed here."
                ]
            ).save(flush:true, status: 0)

            new Solution(
                pageNumber: 1,
                code: "neptunium"
            ).save(flush:true, status: 0)

            new StoryPage(pageNumber: 2,
                title: "Missing Management",
                intro: "<p>Ninety-three En Pee? 93-NP! It's an element, neptunium! But why? It has to be connected to the director's disappearance somehow.</p>"
                    +"<p>*You pop open your Elemental Radiometric Positioner*</p>"
                    +"<p>There it is! There's a large concentration of neptunium down at the Waterfront.  It's time to take the team off site and investigate.</p>",
                timelockedText: [
                    "0": "Puzzle 2 Description!",
                    "60000": "First Puzzle 2 Hint!",
                    "90000": "Second Puzzle 2 Hint!"
                ]
            ).save(flush: true, status: 0)

            new Solution(
                pageNumber: 2,
                code: "answer"
            ).save(flush:true, status: 0)
        }






        //def admin=security.TeamDetails.findByUsername("admin")?:
         //   new security.TeamDetails(username:"team1", password:"team1", teamName:"Mama Loves Her Little Alien", enabled:true,
         //                   accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true)
       // if(admin.hasErrors()){
       //     admin.errors.each{println it}
       // }
    }

    def destroy = {
    }
}

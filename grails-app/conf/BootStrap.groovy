import security.TeamDetails

class BootStrap {

    def init = { servletContext ->

       //def admin = {
            if (!TeamDetails.count()) {
                new security.TeamDetails(username:"team1", password:"team1", teamName:"Mama Loves Her Little Alien", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team2", password:"team2", teamName:"Tastes Like Chicken", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team3", password:"team3", teamName:"Alien Armageddon", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team4", password:"team4", teamName:"Team Cheats a Lot", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team5", password:"team5", teamName:"Aliens Love Chicken", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team6", password:"team6", teamName:"Just Have to Outrun the Aliens", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
                new security.TeamDetails(username:"team7", password:"team7", teamName:"Earthlings for America", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true, status: 0)
            }
       // }


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

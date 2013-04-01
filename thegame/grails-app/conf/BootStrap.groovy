import security.TeamDetails

class BootStrap {

    def init = { servletContext ->

       //def admin = {
            if (!TeamDetails.count()) {
                new security.TeamDetails(username:"team1", password:"team1", teamName:"Mama Loves Her Little Alien", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true)
                new security.TeamDetails(username:"team2", password:"team2", teamName:"Tastes Like Chicken", enabled:true,
                        accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true)

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

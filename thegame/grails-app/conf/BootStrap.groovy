class BootStrap {

    def init = { servletContext ->
        def admin=security.Team.findByUsername("admin")?:
            new security.Team(username:"admin", password:"admin", enabled:true, accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true)
        if(admin.hasErrors()){
            admin.errors.each{println it}
        }
    }

    def destroy = {
    }
}

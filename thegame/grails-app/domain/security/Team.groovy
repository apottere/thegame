package security

class Team {

	transient springSecurityService

	String username
	String password
    String teamName

	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    static mapWith="mongo"

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		TeamRole.findAllByTeam(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}


//	def beforeUpdate() {
//		if (isDirty('password')) {
//			encodePassword()
//		}
//	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}



}

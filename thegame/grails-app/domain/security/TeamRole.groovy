package security

import org.apache.commons.lang.builder.HashCodeBuilder

class TeamRole implements Serializable {

	Team team
	Role role
    //static mapWith="mongo"

	boolean equals(other) {
		if (!(other instanceof TeamRole)) {
			return false
		}

		other.team?.id == team?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (team) builder.append(team.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static TeamRole get(long teamId, long roleId) {
		find 'from TeamRole where team.id=:teamId and role.id=:roleId',
			[teamId: teamId, roleId: roleId]
	}

	static TeamRole create(Team team, Role role, boolean flush = false) {
		new TeamRole(team: team, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(Team team, Role role, boolean flush = false) {
		TeamRole instance = TeamRole.findByTeamAndRole(team, role)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Team team) {
		executeUpdate 'DELETE FROM TeamRole WHERE team=:team', [team: team]
	}

	static void removeAll(Role role) {
		executeUpdate 'DELETE FROM TeamRole WHERE role=:role', [role: role]
	}

	static mapping = {
		id composite: ['role', 'team']
		version false
	}
}

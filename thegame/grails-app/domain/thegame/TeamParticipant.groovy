package thegame

import org.apache.commons.lang.builder.HashCodeBuilder

class TeamParticipant implements Serializable {

	Team team
	Participant participant

	boolean equals(other) {
		if (!(other instanceof TeamParticipant)) {
			return false
		}

		other.team?.id == team?.id &&
			other.participant?.id == participant?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (team) builder.append(team.id)
		if (participant) builder.append(participant.id)
		builder.toHashCode()
	}

	static TeamParticipant get(long teamId, long participantId) {
		find 'from TeamParticipant where team.id=:teamId and participant.id=:participantId',
			[teamId: teamId, participantId: participantId]
	}

	static TeamParticipant create(Team team, Participant participant, boolean flush = false) {
		new TeamParticipant(team: team, participant: participant).save(flush: flush, insert: true)
	}

	static boolean remove(Team team, Participant participant, boolean flush = false) {
		TeamParticipant instance = TeamParticipant.findByTeamAndParticipant(team, participant)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Team team) {
		executeUpdate 'DELETE FROM TeamParticipant WHERE team=:team', [team: team]
	}

	static void removeAll(Participant participant) {
		executeUpdate 'DELETE FROM TeamParticipant WHERE participant=:participant', [participant: participant]
	}

	static mapping = {
		id composite: ['participant', 'team']
		version false
	}
}

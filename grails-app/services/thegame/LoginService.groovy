package thegame

import security.Team

class LoginService {

    public boolean login(String teamName, String password) {
        boolean logged = false
        Team team = Team.findByName(teamName)

        if (team.password == password) {
            logged = true
            if(!team.checkpointsCleared) {
                team.checkpointsCleared = [1: new Date()]
                team.save()
            }
        }
        return logged
    }

    public void logout(String teamName) {

    }
}

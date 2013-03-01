package thegame

/**
 *   An individual team in the game
 */
class Team  {

    // Authentication related fields
    String login
    String password
    String email
    int status


    String name

    Map<BigDecimal, Date> checkpointsCleared

    public int currentStatus() {
        return checkpointsCleared.keySet().max()
    }
}

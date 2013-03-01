package thegame

/**
 *   An individual team in the game
 */
class Team {
    String name
    String password
    Map<BigDecimal, Date> checkpointsCleared

    public int currentStatus() {
        return checkpointsCleared.keySet().max()
    }
}

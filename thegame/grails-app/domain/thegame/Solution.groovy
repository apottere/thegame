package thegame

class Solution {
    static mapWith="mongo"
    int pageNumber
    String code

    static mapping = {
        pageNumber indexColumn: [ type: Integer, unique:true]
    }
}

/*globals angular:true, tripoli:true */
angular.module('thegame.services', []);
angular.module('thegame.filters', []);
angular.module('thegame.directives', ['thegame.services']);
angular.module('thegame', ['thegame.services', 'thegame.filters', 'thegame.directives']);


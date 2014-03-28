modules = {

    jquery {
        resource url: 'http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js'
    }

    underscore {
        resource url: 'http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js'
    }

    angular {
        resource url: 'http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js'
    }

    bootstrap {
        resource url: 'http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css', disposition: 'head'
    }

    application {
        dependsOn 'jquery, underscore, angular, bootstrap'
        resource url: 'js/application.js'
        resource url: 'js/thegame-ng-base.js'

        // Hacks to get it working
        resource url: 'js/ng-controllers/StoryController.js'
        resource url: 'js/ng-services/geoLocationService.js'
    }

    story {
        dependsOn 'application'

        resource url: 'js/ng-controllers/StoryController.js'
        resource url: 'js/ng-services/geoLocationService.js'
    }
}
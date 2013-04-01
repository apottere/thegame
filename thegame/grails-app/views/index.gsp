<%@ page import="grails.plugins.springsecurity.SpringSecurityService" %>
<% def springSecurityService %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Aliens vs Earthlings</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.8em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 3em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 1024px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
        <img src="images/aliensHeader.png">

		<div id="status" role="complementary">
			<h1>Team Rankings</h1>
			<ul>
				<li>Original Index Page List</li>
				<li>Alien Armaggedon</li>
				<li>Aliens Taste Like Chicken</li>
				<li>Team Cheats A Lot</li>
                <li>Aliens Love Cookies</li>
				<li>Just Have to Outrun the Aliens</li>
                <li>Earthlings for America</li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to the Game</h1>

			<div id="controller-list" role="navigation">
				<h2>The Story So Far...</h2>
				<ul>
					Aliens. Rubber Chickens. Game on.<p />



                    <sec:ifLoggedIn>
                        Congratulations,
                        ${sec.loggedInUserInfo(field:"username")}
                        Feel free to <g:link controller='logout' action='auth'>logout</g:link>
                    </sec:ifLoggedIn>

                    <sec:ifNotLoggedIn>
                        If you're one of the participating teams, please <g:link controller='login' action='auth'>login</g:link>. This will give
                        you full access to the event site, including details on the story and puzzles that you've earned access to.
                    </sec:ifNotLoggedIn>


				</ul>
			</div>
		</div>
	</body>
</html>

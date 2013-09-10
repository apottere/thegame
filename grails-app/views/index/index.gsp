<%@ page import="grails.plugins.springsecurity.SpringSecurityService" %>
<% def springSecurityService %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Aliens vs Earthlings</title>
		<style type="text/css" media="screen">
      .story h3{
        text-align: center;
      }
      .contents {
        position: relative;
        padding-bottom: 1em;
      }
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: .25em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
        position: absolute;
        top: 0;
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
				margin: 1em 3em 1.25em 18em;
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

			@media screen and (max-width: 800px) {
				#status {
          left: 50%;
          margin-left: -7em;
          position: relative;
          float: none;
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
  <img src="images/aliensHeader.png" width="100%">

  <div class="contents">
		<div id="page-body" role="main">
			<span class="welcome-login-holder">
        <h1>Welcome to the Game</h1>
        <sec:ifLoggedIn>
          <span class="congrats">Hello, team ${team.teamName}</span>
          <g:link class="logout" controller='logout'>logout</g:link>
        </sec:ifLoggedIn>
        <sec:ifNotLoggedIn>
          <g:link class="login" controller='login' action='auth'>login</g:link>
        </sec:ifNotLoggedIn>
      </span>

			<div id="controller-list" role="navigation">
          <sec:ifLoggedIn>
              <span class="story">
                <g:include controller="hud" action="chapter"/>
              </span>
          </sec:ifLoggedIn>

          <sec:ifNotLoggedIn>
              If you're one of the participating teams, please <g:link controller='login' action='auth'>login</g:link>. This will give
              you full access to the event site, including details on the story and puzzles that you've earned access to.
          </sec:ifNotLoggedIn>
			</div>
		</div>

    <div id="status" role="complementary">
			<h1>Team Rankings</h1>
			<ul>

      <g:each in="${allTeams}" status="i" var="team">
          <li>${team.getTeamName()}</li>
      </g:each>

			</ul>
		</div>
  </div>
	</body>
</html>

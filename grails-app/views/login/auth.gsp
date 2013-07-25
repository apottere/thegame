<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="springSecurity.login.title"/></title>
	<style type='text/css' media='screen'>
  html{
    background-color: #000;
    background-image: -moz-linear-gradient(center top, #ddd, #000);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ddd), color-stop(1, #000));
    background-image: linear-gradient(top, #ddd, #ccc);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorStr = '#dddddd', EndColorStr = '#000000');
  }
  body{
    background: transparent;
    background-image: none;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;
  }
	#login {
		margin: 15px 0;
		padding: 0;
		text-align: center;
	}

	#login .inner {
		width: 300px;
		padding-bottom: 6px;
		margin: 60px auto;
		text-align: left;
		border: 1px solid #aab;
		background-color: #fff;
	}

	#login .inner .fheader {
		padding: 18px 26px 14px 26px;
		background-color: #000;
		margin: 0 0 14px 0;
		color: #fee629;
		font-size: 18px;
		font-weight: bold;
    text-align: center;
	}

	#login .inner .cssform p {
		clear: left;
		margin: 0;
		padding: 4px 0 3px 0;
		padding-left: 105px;
		margin-bottom: 20px;
		height: 1%;
	}

	#login .inner .cssform input[type='text'] {
		width: 120px;
	}

	#login .inner .cssform label {
		font-weight: bold;
		float: left;
		text-align: right;
		margin-left: -105px;
		width: 110px;
		padding-top: 3px;
		padding-right: 10px;
	}

	#login #remember_me_holder {
		padding-left: 120px;
    padding-top: 0;
    line-height: 12px;
	}

  #login .inner .cssform p.submit_holder{
    padding: 0;
    margin-top: 40px;
  }

	#login #submit {
		display: block;
    margin: 0 auto;
    cursor: pointer;
    font-weight: bold;
    background-color: #aaa;
	}

  #login #remember_me_holder input {
    float: left;
  }

	#login #remember_me_holder label {
		float: left;
		margin-left: 0;
		text-align: left;
    padding: 0 0 0 5px;
	}

	#login .inner .login_message {
		padding: 6px 25px 20px 25px;
		color: #c33;
	}

	#login .inner .text_ {
		width: 120px;
	}

	#login .inner .chk {
		height: 12px;
	}

  #login .inner .cssform p.home_button {
    text-align: left;
    padding: 0 0 0 10px;
    margin-bottom: 10px;
  }

  #login .home_button a{
    text-decoration: none;
    color: #48802c;
  }
	</style>
</head>

<body>
<div id='login'>
	<div class='inner'>
		<div class='fheader'><g:message code="springSecurity.login.header"/></div>

		<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>

		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
			<p>
				<label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
				<input type='text' class='text_' name='j_username' id='username'/>
			</p>

			<p>
				<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
				<input type='password' class='text_' name='j_password' id='password'/>
			</p>

			<p id="remember_me_holder">
				<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
				<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
			</p>

			<p class="submit_holder">
				<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
			</p>
      <p class="home_button">
        <a href="/thegame">&larr; Home</a>
      </p>
		</form>
	</div>
</div>
<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>

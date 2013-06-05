<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Chapter ${displayPage.pageNumber}</title>
</head>
<body>
    <h3>${displayPage.title}</h3>
    <g:each in="${displayPage.revealedText}" var="text">
        <p>${text}</p>
    </g:each>

    <g:set var="num" value="${1}" />
    <g:while test="${num < displayPage.maxPage }">
        <g:link controller="hud" action="displayPage" params="[page: num]">
            ${num}
        </g:link>
    </g:while>
</body>
</html>
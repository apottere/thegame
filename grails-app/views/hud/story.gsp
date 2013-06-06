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

        Stylish Navigation:
        <g:set var="num" value="${1}" />
        <g:while test="${num <= displayPage.maxPage }">
            <g:if test="${displayPage.pageNumber != num}">
                <g:link controller="hud" action="viewPage" params="[page: num]">
                   ${num++}
                </g:link>
            </g:if>
            <g:else>
                <strong>${num++}</strong>
            </g:else>
        </g:while>

    </body>
</html>
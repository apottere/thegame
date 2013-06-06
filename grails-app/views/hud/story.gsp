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

        <g:if test="${displayPage.pageNumber==displayPage.maxPage}">
            <g:if test="${wrong}">
                <p>REJECTED!</p>
            </g:if>
            <g:form action="answerPuzzle">
                <input type="text" name="code">
                <input type="hidden" value="${displayPage.pageNumber}" name="pageNumber">
                <input type="submit" value="Submit">
            </g:form>
        </g:if>

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
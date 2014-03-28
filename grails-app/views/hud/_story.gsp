<div data-ng-controller="StoryController" data-ng-init="onInit()">
    <g:if test="${flash.success}">
    <p class="correct">CORRECT ANSWER!</p>
    </g:if>

    <h3>Chapter ${displayPage.pageNumber}. ${displayPage.title}</h3>
    <g:each in="${displayPage.revealedText}" var="text">
        <p>${text}</p>
    </g:each>

      <g:if test="${!isFinalPage && displayPage.pageNumber==displayPage.maxPage}">
          <g:if test="${wrong}">
              <p id="answer" class="incorrect">INCORRECT ANSWER!</p>
          </g:if>
          <g:form action="answerPuzzle">
              <input type="text" name="answer">
              <input type="hidden" value="${displayPage.pageNumber}" name="pageNumber">
              <input type="submit" value="Submit">
          </g:form>
      </g:if>

    <div class="stage">Chapter:</div>
    <g:set var="num" value="${1}" />
    <g:while test="${num <= displayPage.maxPage }">
        <g:if test="${displayPage.pageNumber != num}">
            <a href="?page=${num}" class="page-nav">
               ${num++}
            </a>
        </g:if>
        <g:else>
            <strong class="page-nav">${num++}</strong>
        </g:else>
    </g:while>

    <script type="text/javascript">
      setTimeout(function(){location.reload();}, 120000);
    </script>
    <g:render template="timer"/>
    <r:require module="story"/>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<footer class="footer fixed-bottom bg-dark text-light mt-3">
  <div class="container text-center">
    <p class="mb-0">Usuário logado: <strong><c:out value="${fn:escapeXml(sessionScope.currentUser.nmLogin)}" /></strong></p>
  </div>
</footer>

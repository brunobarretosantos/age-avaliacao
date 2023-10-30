<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Exames</title>
    <link rel="stylesheet" href="/context-path/static/css/custom-styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Consulta de Exames</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome do Exame</th>
                    <th>Ativo</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listaExames">
                    <tr>
                        <td><s:property value="cdExame"/></td>
                        <td><s:property value="nmExame"/></td>
                        <td><s:property value="icAtivo ? 'Sim' : 'Não'"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <span>${consultaExamesModel.primeiraPagina}</span>
        <span>${consultaExamesModel.ultimaPagina}</span>
		<nav aria-label="Page navigation" class="d-flex justify-content-center">
		    <ul class="pagination">
		        <li class="page-item">
		            <s:if test="consultaExamesModel.paginaAtual > 1">
		                <a class="page-link" href="?pagina=1" aria-label="First">
		                    <span aria-hidden="true">«« Primeira</span>
		                </a>
		            </s:if>
		        </li>
		       		 
		        <li class="page-item">
		            <s:if test="consultaExamesModel.paginaAtual > 1">
		                <a class="page-link" href="?pagina=${consultaExamesModel.paginaAtual - 1}" aria-label="Previous">
		                    <span aria-hidden="true">&laquo; Anterior</span>
		                </a>
		            </s:if>
		        </li>      
		
		        <s:iterator begin="consultaExamesModel.primeiraPagina" end="consultaExamesModel.ultimaPagina" var="i">
		            <li class="page-item">
		                <s:if test="consultaExamesModel.paginaAtual == i">
		                    <span class="page-link page-active">${i}</span>
		                </s:if>
		                <s:else>
		                    <a class="page-link" href="?pagina=${i}">${i}</a>
		                </s:else>
		            </li>
		        </s:iterator>
		
		        <li class="page-item">
		            <s:if test="consultaExamesModel.paginaAtual < consultaExamesModel.totalPaginas">
		                <a class="page-link" href="?pagina=${consultaExamesModel.paginaAtual + 1}" aria-label="Next">
		                    <span aria-hidden="true">Próxima &raquo;</span>
		                </a>
		            </s:if>
		        </li>
		        
		        <li class="page-item">
		            <s:if test="consultaExamesModel.paginaAtual < consultaExamesModel.totalPaginas">
		                <a class="page-link" href="?pagina=${consultaExamesModel.totalPaginas}" aria-label="Last">
		                    <span aria-hidden="true">Última »»</span>
		                </a>
		            </s:if>
		        </li>
		    </ul>
		</nav>

    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

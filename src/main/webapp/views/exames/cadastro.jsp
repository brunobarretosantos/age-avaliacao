<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><s:if test="id > 0">Edição de Exame</s:if><s:else>Cadastro de Exame</s:else></title>
    <link rel="stylesheet" href="/context-path/static/css/custom-styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<script>
		function toUppercase(element) {
		    element.value = element.value.toUpperCase();
		}
		
		document.addEventListener('DOMContentLoaded', function() {
	        var mensagemElement = document.getElementById('mensagem');
	        if (mensagemElement) {
	            mensagemElement.style.display = 'block';
	            setTimeout(function() {
	                mensagemElement.style.display = 'none';
	            }, 5000);
	        }
	    });
	</script>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card p-4 w-100">
            <h2 class="mb-4"><s:if test="id > 0">Edição de Exame</s:if><s:else>Cadastro de Exame</s:else></h2>
            <form action="executeCadastro" method="post">
            	<s:if test="exame.cdExame > 0">
            		<div class="form-group">
				    	<label for="exame.cdExame">Código do Exame:</label>				    
				        <s:property value="exame.cdExame" />
				        <s:hidden name="exame.cdExame" />				    
					</div>
				</s:if>            
                <div class="form-group">
                    <label for="exame.nmExame">Nome do Exame</label>
                    <s:textfield class="form-control" name="exame.nmExame"  maxlength="255" oninput="toUppercase(this)"/>
                    <s:fielderror fieldName="exame.nmExameError"/>
                </div>
                <div class="form-group w-25">
                    <label for="exame.icAtivo">Ativo</label>
                    <s:select class="form-control" name="exame.icAtivo" list="#{'true':'Sim', 'false':'Não'}" value="true" />
                    <s:fielderror fieldName="exame.icAtivo" />
                </div>
                <div class="form-group">
                    <label for="exame.dsDetalheExame">Detalhe do Exame</label>
                    <s:textarea class="form-control" name="exame.dsDetalheExame" rows="4" />
                    <s:fielderror fieldName="exame.dsDetalheExame" />
                </div>
                <div class="form-group">
                    <label for="exame.dsDetalheExame1">Outro Detalhe do Exame</label>
                    <s:textarea class="form-control" name="exame.dsDetalheExame1" rows="4"/>
                    <s:fielderror fieldName="exame.dsDetalheExame1" />
                </div>
                <s:if test="hasActionErrors()">
				    <div class="alert alert-danger" role="alert">
				        <s:actionerror />
				    </div>
				</s:if>
				<s:if test="hasActionMessages()">
				    <div id="mensagem" class="alert alert-success" style="display:none;">
				        <s:actionmessage/>
				    </div>
				</s:if>				
                <button type="submit" class="btn btn-primary"><s:if test="id > 0">Salvar Alterações</s:if><s:else>Cadastrar</s:else></button>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

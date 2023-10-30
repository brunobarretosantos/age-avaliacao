<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Exame</title>
    <link rel="stylesheet" href="/context-path/static/css/custom-styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card p-4">
            <h2 class="mb-4">Cadastro de Exame</h2>
            <form action="create" method="post">
                <div class="form-group">
                    <label for="exame.nmExame">Nome do Exame</label>
                    <s:textfield class="form-control" name="exame.nmExame" />
                    <s:fielderror fieldName="exame.nmExame" />
                </div>
                <div class="form-group">
                    <label for="exame.icAtivo">Ativo</label>
                    <s:select class="form-control" name="exame.icAtivo" list="#{'true':'Sim', 'false':'Não'}" />
                    <s:fielderror fieldName="exame.icAtivo" />
                </div>
                <div class="form-group">
                    <label for="exame.dsDetalheExame">Detalhe do Exame</label>
                    <s:textfield class="form-control" name="exame.dsDetalheExame" />
                    <s:fielderror fieldName="exame.dsDetalheExame" />
                </div>
                <div class="form-group">
                    <label for="exame.dsDetalheExame1">Outro Detalhe do Exame</label>
                    <s:textfield class="form-control" name="exame.dsDetalheExame1" />
                    <s:fielderror fieldName="exame.dsDetalheExame1" />
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

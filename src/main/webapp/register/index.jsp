<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="/context-path/static/css/custom-styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card p-4">
            <h2 class="mb-4">Cadastro de ${ registerAdmin ? 'Administrador' : 'Usuário' }</h2>
            <form>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="form-group">
                    <label for="password">Senha</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirmar Senha</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
                </div>
                <div class="form-group">
				    <label for="role">Role</label>
				    <select class="form-control" id="role" name="role" ${registerAdmin ? 'disabled' : ''}>
				        <option value="USER" ${registerAdmin ? '' : 'selected'}>USER</option>
				        <option value="ADMIN" ${registerAdmin ? 'selected' : ''}>ADMIN</option>
				    </select>
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

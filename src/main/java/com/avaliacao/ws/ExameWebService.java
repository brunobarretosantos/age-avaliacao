package com.avaliacao.ws;

import com.avaliacao.model.Exame;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;

@WebService
public interface ExameWebService {
	
	@GET
	@WebMethod
    Exame consultarExame(int id);
	
	@WebMethod
    Exame criarExame(Exame exame);
	
	@WebMethod
    boolean atualizarExame(Exame exame);
	
	@WebMethod
    boolean excluirExame(int id);
}
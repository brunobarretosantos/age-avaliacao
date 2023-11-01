package com.avaliacao.ws;

import com.avaliacao.model.Exame;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ExameWebService {
	
	@WebMethod
    Exame consultarExame(int id);
}

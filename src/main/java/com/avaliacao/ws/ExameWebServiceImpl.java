package com.avaliacao.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

import com.avaliacao.facade.ExameFacade;
import com.avaliacao.model.Exame;

@Stateless
@WebService(name = "soap")
public class ExameWebServiceImpl implements ExameWebService {
	private ExameFacade exameFacade;
	
	public ExameWebServiceImpl() {
		exameFacade = new ExameFacade();
	}
	

	@Override
	public Exame consultarExame(int id) {		
		return exameFacade.carregarExame(id);
	}

}

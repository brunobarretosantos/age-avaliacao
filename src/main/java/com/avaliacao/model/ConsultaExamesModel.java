package com.avaliacao.model;

public class ConsultaExamesModel {
		
	private int paginaAtual = 1;
    private int totalPaginas;
    private int registrosPorPagina = 10;
    private int primeiraPagina;
    private Integer cd_exame = null;
    private String nm_exame;
    private String ic_ativo = null;
    
    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
    	if (paginaAtual > this.totalPaginas) {
    		this.paginaAtual = this.totalPaginas;
    		return;
    	}
    	
    	if (paginaAtual < 1) {
    		this.paginaAtual = 1;
    		return;
    	}

        this.paginaAtual = paginaAtual;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }
    
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    
    public int getPrimeiraPagina() {
    	return primeiraPagina = Math.max(1, this.paginaAtual - 2);
    }

    public int getUltimaPagina() {
        return Math.min(this.totalPaginas, this.primeiraPagina + 4);
    }

	public int getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	public void setRegistrosPorPagina(int registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	public Integer getCd_exame() {
		return cd_exame;
	}

	public void setCd_exame(Integer cd_exame) {
		this.cd_exame = cd_exame;
	}

	public String getNm_exame() {
		return nm_exame;
	}

	public void setNm_exame(String nm_exame) {
		this.nm_exame = nm_exame;
	}

	public String getIc_ativo() {
		return ic_ativo;
	}
	
	public Boolean getIc_ativoValue() {
		if (ic_ativo == null || ic_ativo.isEmpty()) {
			return null;
		}
		
		return ("sim".equals(ic_ativo.toLowerCase()));
	}

	public void setIc_ativo(String ic_ativo) {
		this.ic_ativo = ic_ativo;
	}
}	
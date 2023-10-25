package com.avaliacao.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class Usuario {	
	private static final Logger logger = Logger.getLogger(Usuario.class.getName());
	
	private String nmLogin;	
	private String dsSenha;
    private int qtTempoInatividade;    
    private String nmRole;
    private Boolean isPasswordEncripted = false;

    public String getNmLogin() {
        return nmLogin;
    }

    public void setNmLogin(String nmLogin) {
        this.nmLogin = nmLogin;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public int getQtTempoInatividade() {
        return qtTempoInatividade;
    }

    public void setQtTempoInatividade(int qtTempoInatividade) {
        this.qtTempoInatividade = qtTempoInatividade;
    }

    public String getNmRole() {
        return nmRole;
    }

    public void setNmRole(String nmRole) {
    	if (nmRole != null && (nmRole.equals("ADMIN") || nmRole.equals("USER"))) {
            this.nmRole = nmRole;
        } else {
            throw new IllegalArgumentException("O valor de nmRole deve ser 'ADMIN' ou 'USER'.");
        }
    }
    
    public void setIsPasswordEncripted(Boolean isPasswordEncripted) {
    	this.isPasswordEncripted = isPasswordEncripted;
    }
    
    
    public String getEncryptedPassword() throws Exception {
    	logger.info("getEncryptedPassword.isPasswordEncripted: " + isPasswordEncripted);
    	logger.info("getEncryptedPassword.dsSenha: " + dsSenha);
    	return Boolean.TRUE.equals(isPasswordEncripted) ? dsSenha : Usuario.makeEncryptedPassword(dsSenha);
    }
    
    public static String makeEncryptedPassword(String originalPassword) throws Exception {
        try {
        	if (originalPassword == null || originalPassword.trim().isEmpty()) {
        		throw new IllegalArgumentException("Informe a senha");
        	}
        	
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    originalPassword.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.info("makeEncryptedPassword.failed");
            throw e;
        }
    }
}

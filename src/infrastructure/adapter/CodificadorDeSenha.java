package infrastructure.adapter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import application.port.ICodificadorDeSenha;

public class CodificadorDeSenha implements ICodificadorDeSenha {

	@Override
	public String codificar(String senha) {
		MessageDigest digest;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
			
			return Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

package sfpd.exceptions;

import com.fasterxml.jackson.databind.JsonNode;

import java.text.MessageFormat;

public class ExcecaoCampoInexistente extends Exception {

	private static final long serialVersionUID = 1L;
	private String campo;

	public ExcecaoCampoInexistente(String campo, JsonNode node) {
		super( new MessageFormat( "O campo [{0}] não existe no objeto {1}" ).format( campo, node ) );
		this.campo=campo;
	}

	public ExcecaoCampoInexistente(String message) {
		super( message );
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}
}

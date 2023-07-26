package sfpd.exceptions;

import java.io.File;

public final class ArquivoSemConteudo extends Exception {
    final String filename;

    public ArquivoSemConteudo(String filename) {
        this.filename = filename;
    }

    public ArquivoSemConteudo(File arquivoTemporario) {
        this.filename = arquivoTemporario.getAbsolutePath();
    }

    public String toString() {
        return "O arquivo [" + filename + "] está vazio.";
    }
}
package sfpd.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public final class ListArquivoSemConteudo extends Exception {

    public ListArquivoSemConteudo(List<ArquivoSemConteudo> todos) {
        super(todos.stream().map(e->e.getMessage()).collect(Collectors.joining("\n")));
    }
}
package sfpd.exceptions;

import java.util.function.Consumer;

@FunctionalInterface
public interface FunctionWithListException<T> {
    void accept(T t) throws ListArquivoSemConteudo;

    static  <T> Consumer<T> wrap(FunctionWithListException<? super T> ioc, Consumer<ListArquivoSemConteudo> e) {
        return t -> {
            try {
                ioc.accept(t);
            } catch (ListArquivoSemConteudo ioe) {
                e.accept(ioe);
            }
        };
    }
}
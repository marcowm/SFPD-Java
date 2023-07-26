package sfpd.exceptions;

import java.util.function.Consumer;

@FunctionalInterface
public interface FunctionWithException<T> {
    void accept(T t) throws ArquivoSemConteudo;

    static  <T> Consumer<T> wrap(FunctionWithException<? super T> ioc, Consumer<ArquivoSemConteudo> e) {
        return t -> {
            try {
                ioc.accept(t);
            } catch (ArquivoSemConteudo ioe) {
                e.accept(ioe);
            }
        };
    }


}
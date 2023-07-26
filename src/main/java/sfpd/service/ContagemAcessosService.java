package sfpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sfpd.modelo.ContagemAcessos;
import sfpd.repository.ContagemAcessosRepository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class ContagemAcessosService {

    @Autowired
    private ContagemAcessosRepository contagemAcessosRepository;

    public void registrarAcesso(String contador)
    {
        Integer totalAcessos = null;

        try {
            ContagemAcessos contagemAcessos = contagemAcessosRepository.obterContagemAcessos(contador);
            totalAcessos = contagemAcessos.getValor();
            totalAcessos++;

            contagemAcessos.setValor(totalAcessos);

            contagemAcessosRepository.save(contagemAcessos);

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public Integer obterContadorRegistrado(String contador)
    {
        Integer totalAcessos = null;

        try {
            ContagemAcessos contagemAcessos = contagemAcessosRepository.obterContagemAcessos(contador);
            totalAcessos = contagemAcessos.getValor();

            return totalAcessos;

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public HashMap<Integer, List> obterTotalArquivosAnual()
    {
        try {
            HashMap<Integer, List> totalUltimos3Anos = new HashMap<Integer, List>();

            // Obtem o ano atual
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

            // Loop para retornar os 3 ultimos anos
            for (int i = 0; i < 3; i++) {
                int ano = anoAtual - i;
                totalUltimos3Anos.put(i, contagemAcessosRepository.obterTotalArquivosAnual(ano));
            }

             return totalUltimos3Anos;

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}

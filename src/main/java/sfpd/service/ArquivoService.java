package sfpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sfpd.modelo.Arquivo;
import sfpd.modelo.ArquivosLinhas;
import sfpd.modelo.ContagemAcessos;
import sfpd.pojo.RegistroPOJO;
import sfpd.repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArquivoService {

    @Autowired
    public ArquivoRepository arquivoRepository;

    @Autowired
    public LinhaArquivoRepository linhaArquivoRepository;

    @Autowired
    private ContagemAcessosRepository contagemAcessosRepository;

    List<Arquivo> arquivos = new ArrayList<>();
    List<ArquivosLinhas> linhas = new ArrayList<>();

    public List<Arquivo> listarArquivos()
    {
        try {
            arquivos = arquivoRepository.obterArquivosCadastrados();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return arquivos;
    }

    public List<ArquivosLinhas> obterLinhasArquivo(Long id)
    {
        try {
            linhas = linhaArquivoRepository.obterLinhasArquivo(id);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return linhas;
    }

    public Arquivo obterArquivo(Long idArquivo)
    {
        Optional<Arquivo> arquivo;

        try {
            arquivo = arquivoRepository.obterArquivo(idArquivo);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return arquivo.get();
    }

    public Arquivo atualizar(Arquivo arquivo)
    {
        Arquivo arquivoResult;

        try {
            arquivoResult = arquivoRepository.save(arquivo);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return arquivoResult;
    }

    public Arquivo adicionarArquivo(Arquivo arquivo)
    {
        Arquivo arquivoResult;

        try {
            arquivoResult = arquivoRepository.save(arquivo);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return arquivoResult;
    }

    public void adicionarLinhaArquivo(RegistroPOJO linha)
    {
        try {

            // validar existencia arquivo na base
            Optional<Arquivo> arquivo = arquivoRepository.obterArquivo(linha.getArquivoId());
            Long idArquivoNovo = null;

            if (!arquivo.isPresent())
            {
                Arquivo arquivoNovo = new Arquivo();

                arquivoNovo.setId(linha.getArquivoId());
                arquivoNovo.setArquivoPath(linha.getArquivoPath());
                arquivoNovo.setData(new Date());
                arquivoNovo.setAtivo(true);

                arquivoRepository.save(arquivoNovo);
            }

            ArquivosLinhas linhaArquivo = new ArquivosLinhas();

            linhaArquivo.setArquivoID(linha.getArquivoId());
            linhaArquivo.setLinha(linha.getLinha());
            linhaArquivo.setData(linha.getData());

            linhaArquivoRepository.save(linhaArquivo);

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public Double obterEspacoDisco()
    {
        double freeSpace;

        try {
            File f = new File("C:\\");
            freeSpace = f.getFreeSpace() / 1000000000.00;
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return freeSpace;
    }

    public Integer obterTotalArquivos()
    {
        Integer totalArquivos;

        try {

            arquivos = arquivoRepository.obterArquivosCadastrados();
            totalArquivos = arquivos.size();

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return totalArquivos;
    }

    public void registrarDownloadArquivo()
    {
        Integer totalAcessos = null;

        try {
            ContagemAcessos contagemAcessos = contagemAcessosRepository.obterContagemAcessos("countDownloads");
            totalAcessos = contagemAcessos.getValor();
            totalAcessos++;



        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}

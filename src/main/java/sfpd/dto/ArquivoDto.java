package sfpd.dto;

import org.springframework.stereotype.Component;
import sfpd.modelo.Arquivo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArquivoDto implements Serializable {

    private Long id;
    private Date data;
    private String arquivoPath;
    private Boolean ativo;

    public ArquivoDto() {}

    public ArquivoDto(Long id, Date data, String arquivoPath, Boolean ativo)
    {
        this.id = id;
        this.data = data;
        this.arquivoPath = arquivoPath;
        this.ativo = ativo;
    }

    public ArquivoDto(Arquivo arquivo) {
        this.id = arquivo.getId();
        this.data = arquivo.getData();
        this.arquivoPath = arquivo.getArquivoPath();
        this.ativo = arquivo.getAtivo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getArquivoPath() { return arquivoPath; }

    public void setArquivoPath(String arquivoPath) { this.arquivoPath = arquivoPath; }

    public Boolean getAtivo() { return ativo; }

    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public List<ArquivoDto> arquivosOutputDto(List<Arquivo> arquivo)
    {
        return arquivo.stream().map(ArquivoDto::new).collect(Collectors.toList());
    }
}

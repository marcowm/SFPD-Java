package sfpd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.*;

public class RegistroPOJO {

    @JsonProperty
    private Long id;

    @JsonProperty
    @JsonSerialize(as = Date.class)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT-3")
    private Date data;

    @JsonProperty
    private String arquivoPath;

    @JsonProperty
    private Long arquivoId;

    @JsonProperty
    private String linha; // AtributoValor

    public RegistroPOJO(){}

    public RegistroPOJO(Long id, Date data, Long arquivoId, String arquivoPath, String linha)
    {
        this.id = id;
        this.data = data;
        this.arquivoId = arquivoId;
        this.arquivoPath = arquivoPath;
        this.linha = linha;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getArquivoId() {
        return arquivoId;
    }

    public void setArquivoId(Long arquivoId) {
        this.arquivoId = arquivoId;
    }

    public String getArquivoPath() {
        return arquivoPath;
    }

    public void setArquivoPath(String arquivoPath) {
        this.arquivoPath = arquivoPath;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroPOJO that = (RegistroPOJO) o;
        return id.equals(that.id) && data.equals(that.data) && arquivoId.equals(that.arquivoId) && arquivoPath.equals(that.arquivoPath) && linha.equals(that.linha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, arquivoId, arquivoPath, linha);
    }

    @Override
    public String toString() {
        return "RegistroPOJO{" +
                "id=" + id +
                ", data=" + data +
                ", arquivoPath='" + arquivoPath + '\'' +
                ", arquivoId=" + arquivoId +
                ", linha='" + linha + '\'' +
                '}';
    }
}

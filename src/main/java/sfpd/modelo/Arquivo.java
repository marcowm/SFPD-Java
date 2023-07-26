/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfpd.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "arquivos")
public class Arquivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private Date data;

    @Column(name = "arquivoPath")
    private String arquivoPath;

    @Column
    private Boolean ativo;


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

    public String getArquivoPath() {
        return arquivoPath;
    }

    public void setArquivoPath(String arquivoPath) {
        this.arquivoPath = arquivoPath;
    }

    public Boolean getAtivo() { return ativo; }

    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arquivo arquivo = (Arquivo) o;
        return id.equals(arquivo.id) && data.equals(arquivo.data) && arquivoPath.equals(arquivo.arquivoPath) && ativo.equals(arquivo.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, arquivoPath, ativo);
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "id=" + id +
                ", data=" + data +
                ", arquivoPath='" + arquivoPath + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}

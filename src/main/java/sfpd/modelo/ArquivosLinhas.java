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
@Table(name = "arquivos_linhas")
public class ArquivosLinhas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date data;

    @Column
    private Long arquivoID;

    @Column
    private String linha;

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

    public Long getArquivoID() {
        return arquivoID;
    }

    public void setArquivoID(Long arquivoID) {
        this.arquivoID = arquivoID;
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
        ArquivosLinhas arquivo = (ArquivosLinhas) o;
        return id.equals(arquivo.id) && data.equals(arquivo.data) && Objects.equals(arquivoID, arquivo.arquivoID) && linha.equals(arquivo.linha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, arquivoID, linha);
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "id=" + id +
                ", data=" + data +
                ", arquivoID=" + arquivoID +
                ", linha='" + linha + '\'' +
                '}';
    }
}

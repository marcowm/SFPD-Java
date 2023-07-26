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
@Table(name = "contagem_acessos")
public class ContagemAcessos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date data;

    @Column(name = "descricao")
    private String descricao;

    @Column
    private Integer valor;


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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContagemAcessos that = (ContagemAcessos) o;
        return id.equals(that.id) && data.equals(that.data) && descricao.equals(that.descricao) && valor.equals(that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, descricao, valor);
    }

    @Override
    public String toString() {
        return "ContagemAcessos{" +
                "id=" + id +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}

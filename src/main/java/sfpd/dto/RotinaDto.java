package sfpd.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class RotinaDto implements Serializable {

    private Date data;
    private Boolean executado;
    private String status;

    public RotinaDto() {}

    public RotinaDto(Date data, Boolean executado)
    {
        this.data = data;
        this.executado = executado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getExecutado() { return executado; }

    public void setExecutado(Boolean executado) { this.executado = executado; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}

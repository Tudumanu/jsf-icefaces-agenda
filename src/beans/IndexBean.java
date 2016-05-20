package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {
    private String valor;

    public String adicionar() {
        System.out.println("ADDDDDDDDDDDDD");

        valor = "add";
        return "adicionar";
    }

    public String getValor() {
        return valor;
    }
}
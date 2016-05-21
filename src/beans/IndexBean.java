package beans;

import dao.ContatoDAO;
import model.Contato;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@CustomScoped(value = "#{window}")
public class IndexBean {

    private String msg;
    private Contato contato;
    private ContatoDAO contatoDAO;
    private List<Contato> listaContato;


    public IndexBean() {
        System.out.println("IndexBean");
        init();
    }

    private synchronized void init() {
        System.out.println("init");

        contato = new Contato();
        contatoDAO = new ContatoDAO();

        listaContato = contatoDAO.search("%");
    }

    public void insert() {
        System.out.println("insert");

        msg = contatoDAO.insert(contato) ?
                contato.getNome() + " inserido com sucesso!"
                : "Ocorreu um erro ao inserir.";
    }

    public void update() {
        System.out.println("update");
    }

    public void delete() {
        System.out.println("delete");
    }

    // GETTERS AND SETTERS //

    public String getMsg() {
        return msg;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
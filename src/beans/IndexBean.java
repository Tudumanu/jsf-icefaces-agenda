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
    private String searchStr;
    private Contato contato;
    private ContatoDAO contatoDAO;
    private List<Contato> listaContato;


    public IndexBean() {
        System.out.println("IndexBean");

        contatoDAO = new ContatoDAO();
        init();
    }

    private synchronized void init() {
        System.out.println("init");

        contato = new Contato();
        searchStr = "";
        listaContato = contatoDAO.search(searchStr);
    }

    public void insert() {
        System.out.println("insert");

        msg = contatoDAO.insert(contato) ?
                contato.getNome() + " inserido com sucesso!"
                : "Ocorreu um erro ao inserir.";

        init(); //atualiza listagem, zera campos contato
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

    public List<Contato> getListaContato() {
        return listaContato;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        System.out.println("setSearchStr");
        this.searchStr = searchStr;
        listaContato = contatoDAO.search(searchStr);
    }
}
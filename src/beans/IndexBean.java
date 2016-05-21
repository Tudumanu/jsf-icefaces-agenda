package beans;

import dao.ContatoDAO;
import model.Contato;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@CustomScoped(value = "#{window}")
public class IndexBean {

    private String msg;
    private String editMsg;
    private String searchStr;
    private Contato contato;
    private ContatoDAO contatoDAO;
    private List<Contato> listaContato;
    private ArrayList listaContatoCompleta;

    private Contato contatoSelecionado;

    public IndexBean() {
        System.out.println("IndexBean");

        contatoDAO = new ContatoDAO();
        init();
    }

    private synchronized void init() {
        System.out.println("init");

        contato = new Contato();

        //string de busca e listagem dos contatos
        searchStr = "";
        listaContato = contatoDAO.search(searchStr);

        //lista usada para editar ou excluir um contato
        listaContatoCompleta = new ArrayList();
        for (int i = 0; i < listaContato.size(); i++) {
            listaContatoCompleta.add(new SelectItem(listaContato.get(i).getId(), listaContato.get(i).getNome()));
        }

        //elemento selecionado no selectMenu
        contatoSelecionado = listaContato.get(0);
        if (contatoSelecionado == null)
            contatoSelecionado = new Contato();

    }

    public void contatoSelectAlterado(ValueChangeEvent event){
        System.out.println("contatoSelectAlterado");

        if(event.getNewValue() != null) {
            System.out.println(event.getNewValue());

            int id = Integer.parseInt(event.getNewValue().toString());
            contatoSelecionado = contatoDAO.show(id);
            System.out.println(contatoSelecionado.getNome());
            //selNome.setValue(endSelecionado.getNome());
        }
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

    public Contato getContatoSelecionado() {
        return contatoSelecionado;
    }

    public void setContatoSelecionado(Contato contatoSelecionado) {
        this.contatoSelecionado = contatoSelecionado;
    }

    public List<Contato> getListaContatoCompleta() {
        return listaContatoCompleta;
    }

    public String getEditMsg() {
        return editMsg;
    }

}
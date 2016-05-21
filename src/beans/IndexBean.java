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
        listaContatoCompleta = new ArrayList();
        init();
    }

    private synchronized void init() {
        System.out.println("init");

        contato = new Contato();

        //string de busca e listagem dos contatos
        searchStr = "";
        listaContato = contatoDAO.search(searchStr);

        //lista usada para editar ou excluir um contato
        listaContatoCompleta.clear();
        for (int i = 0; i < listaContato.size(); i++) {
            listaContatoCompleta.add(new SelectItem(listaContato.get(i).getId(), listaContato.get(i).getNome()));
        }

        //elemento selecionado no selectMenu
        if (listaContato.size() > 0) {
            Contato tmp = listaContato.get(0);
            contatoSelecionado = new Contato();
            contatoSelecionado.setId(tmp.getId());
            contatoSelecionado.setNome(tmp.getNome());
            contatoSelecionado.setTelefone(tmp.getTelefone());
            contatoSelecionado.setEmail(tmp.getEmail());
            contatoSelecionado.setEndereco(tmp.getEndereco());
            contatoSelecionado.setNascimento(tmp.getNascimento());
        } else
            contatoSelecionado = new Contato();
    }

    public void contatoSelectAlterado(ValueChangeEvent event){
        System.out.println("contatoSelectAlterado "+ event.getNewValue());

        if(event.getNewValue() != null) {
            int id = Integer.parseInt(event.getNewValue().toString());
            contatoSelecionado = contatoDAO.show(id);
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

        if (contatoSelecionado.getId() > 0) {
            editMsg = contatoDAO.update(contatoSelecionado) ?
                    contatoSelecionado.getNome() + " Atualizado com sucesso!"
                    : "Ocorreu um erro ao atualizar.";

            init(); //atualiza listagem, zera campos contato
        } else
            editMsg = "Necessita selecionar um contato!!!";

    }

    public void delete() {
        System.out.println("delete");

        if (contatoSelecionado.getId() > 0) {
            editMsg = contatoDAO.delete(contatoSelecionado) ?
                    contatoSelecionado.getNome() + " Removido com sucesso!"
                    : "Ocorreu um erro ao remover.";

            init(); //atualiza listagem, zera campos contato
        } else
            editMsg = "Necessita selecionar um contato!!!";
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
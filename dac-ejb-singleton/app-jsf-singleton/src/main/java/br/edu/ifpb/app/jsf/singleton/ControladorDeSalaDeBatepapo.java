package br.edu.ifpb.app.jsf.singleton;

import br.edu.ifpb.service.shared.SalaDeBatepapo;
import br.edu.ifpb.service.shared.ServiceLookup;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ControladorDeSalaDeBatepapo implements Serializable {

    private String mensagem;

    private SalaDeBatepapo sdb;

    @PostConstruct
    public void init() {
        this.sdb = new ServiceLookup()
                .lookup("host-core", "3700",
                        "java:global/service-core-singleton/SalaDeBatepapoOnline");
    }

    public String addMensagem() {
        this.sdb.addMensagem(mensagem);
        this.mensagem = "";
        return null;
    }

    public String rmvMensagem(String mensagem) {
        this.sdb.rmvMensagem(mensagem);
        return null;
    }

    public List<String> listarMensagens() {
        return this.sdb.listarMensagens();
    }

    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

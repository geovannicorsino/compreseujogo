package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Sexo;


@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> lista;

	public ClienteController() {
		super();
		this.cliente = new Cliente();
		this.lista = new ArrayList<Cliente>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Estado[] getEstado() {
		return Estado.values();
	}
	
	public List<Cliente> getLista() throws Exception {
		Facade facade = new Facade();
		lista = facade.listaCliente(cliente);
		
		return lista;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Facade facade = new Facade();
			facade.salvarCliente(this.cliente);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				e.getMessage(),""));
			return "vendedor";
		}	
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Atendimento salvo com sucesso!", "SUCESSO"));		
		return "sucesso";
	}
	
	public List<Cliente> carregarLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			return facade.listaCliente(cliente);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return lista;
	}
	
	public String alterar(Cliente c) {
		this.cliente = c;
		return "cadastroCliente.xhtml";
	}
	
	public void excluir(Cliente cliente) {
		
	}
	
	
	
}

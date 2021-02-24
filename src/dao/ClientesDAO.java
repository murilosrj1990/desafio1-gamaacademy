package dao;
import java.util.ArrayList;

import bean.Cliente;

public interface ClientesDAO {

	public void addCliente(Cliente cliente);
	
	public void getClienteById(int clienteId);
	
	public void updateClienteById (Cliente cliente);
	
	public void deleteClienteById (int clienteId);
	
	public ArrayList<Cliente> findAllCliente();
}

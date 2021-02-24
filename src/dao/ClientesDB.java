package dao;

import java.util.ArrayList;

import bean.Cliente;

public class ClientesDB implements ClientesDAO{
	private String sql;

	@Override
	public void addCliente(Cliente cliente) {
		sql = "INSERT INTO clientes (cpf,nome,tel)"
				+ "VALUES ('"+cliente.getCpf()+"','"+cliente.getNome()+"','"+cliente.getTel()+"')";
		ConnectionManager.executeUpdate(sql);
	}

	@Override
	public void getClienteById(int clienteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClienteById(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClienteById(int clienteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Cliente> findAllCliente() {
		// TODO Auto-generated method stub
		return null;
	}

}

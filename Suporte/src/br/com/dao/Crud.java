package br.com.dao;

import java.util.List;

public interface Crud {
	
	public interface CRUD<T> { 
		 String registrar(T obj); 
		 List<T> listar(); 
		 List<T> listar(T obj); 
		 T atualizar(T obj); 
		 String apagar(T obj); 
		} 

}

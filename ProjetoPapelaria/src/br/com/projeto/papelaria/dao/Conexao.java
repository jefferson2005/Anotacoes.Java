package br.com.projeto.papelaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
	
	protected Connection con = null;
	protected PreparedStatement pst = null;
	protected ResultSet ts = null;
	
	protected void abrirBanco() {
		
	}
	
	protected void fecharBanco() {
		
	}
}

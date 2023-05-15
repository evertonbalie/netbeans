/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClientesDAO {
    private Connection con;
    
    public ClientesDAO(){
    this.con= new ConnectionFactory().getConnection();
    }
                  
    
   public void cadastrarCliente( Clientes obj){
   
       try {
           
String sql ="insert into tb_clientes( nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" +
"values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        
           PreparedStatement stmt = con.prepareStatement(sql);
           
           stmt.setString(1,obj.getNome());
           stmt.setString(2,obj.getRg());
           stmt.setString(3,obj.getCpf());
           stmt.setString(4,obj.getEmail());
           stmt.setString(5,obj.getTelefone());
           stmt.setString(6,obj.getCelular());
           stmt.setString(7,obj.getCep());
           stmt.setString(8,obj.getEndereco());
           stmt.setInt(9,obj.getNumero());
           stmt.setString(10,obj.getComplemento());
           stmt.setString(11,obj.getBairro());
           stmt.setString(12,obj.getCidade());
           stmt.setString(13,obj.getUf());
           
           stmt.execute();
           
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
           stmt.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro"+ e);
       }
   }
   
   public void AlterarCliente(Clientes obj ){
   
   try {
           
String sql ="update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
      
           PreparedStatement stmt = con.prepareStatement(sql);
           
           stmt.setString(1,obj.getNome());
           stmt.setString(2,obj.getRg());
           stmt.setString(3,obj.getCpf());
           stmt.setString(4,obj.getEmail());
           stmt.setString(5,obj.getTelefone());
           stmt.setString(6,obj.getCelular());
           stmt.setString(7,obj.getCep());
           stmt.setString(8,obj.getEndereco());
           stmt.setInt(9,obj.getNumero());
           stmt.setString(10,obj.getComplemento());
           stmt.setString(11,obj.getBairro());
           stmt.setString(12,obj.getCidade());
           stmt.setString(13,obj.getUf());
           stmt.setInt(14,obj.getId());
           stmt.execute();
           
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
           stmt.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro"+ e);
       }
   }
   
   public void ExcluirCliente(Clientes obj){
       try {
           String sql= "delete from tb_clientes where id=?";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, obj.getId());
           stmt.execute();
           stmt.close();
           
           JOptionPane.showMessageDialog(null, "Excluido com sucesso");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro de exclusão"+ e);
       }
   }
   
   
    public List<Clientes> PesquisarClientes(String nome) {
       
        try {
            List<Clientes> pesquisa = new ArrayList<>();
            String sql = "select * from tb_clientes where nome like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){            
            
           Clientes obj = new Clientes();
           /*nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado*/
           obj.setId(rs.getInt("id"));
           obj.setNome(rs.getString("nome"));
           obj.setRg(rs.getString("rg"));
           obj.setCpf(rs.getString("cpf"));
           obj.setEmail(rs.getString("email"));
           obj.setTelefone(rs.getString("telefone"));
           obj.setCelular(rs.getString("celular"));
           obj.setCep(rs.getString("cep"));
           obj.setEndereco(rs.getString("endereco"));
           obj.setNumero(rs.getInt("numero"));
           obj.setComplemento(rs.getString("complemento"));
           obj.setBairro(rs.getString("bairro"));
           obj.setCidade(rs.getString("cidade"));
           obj.setUf(rs.getString("estado"));
           
             System.out.println(""+obj.getNome());
          pesquisa.add(obj);
             //   System.out.println("Bairro: "+obj.getBairro()+" \n Nome: "+obj.getNome());          
            }
            
            return pesquisa;
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro dao exeption"+ e);
           return null;
        }
        
    }
   
   public List<Clientes> listarClientes(){
       try {
          
           List<Clientes> lista = new ArrayList<>();
           
           String sql = "select * from tb_clientes";        
           
           PreparedStatement stmt = con.prepareStatement(sql);
           
           ResultSet rs =stmt.executeQuery();
           
           while(rs.next()){
           
           Clientes obj = new Clientes();
           /*nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado*/
           obj.setId(rs.getInt("id"));
           obj.setNome(rs.getString("nome"));
           obj.setRg(rs.getString("rg"));
           obj.setCpf(rs.getString("cpf"));
           obj.setEmail(rs.getString("email"));
           obj.setTelefone(rs.getString("telefone"));
           obj.setCelular(rs.getString("celular"));
           obj.setCep(rs.getString("cep"));
           obj.setEndereco(rs.getString("endereco"));
           obj.setNumero(rs.getInt("numero"));
           obj.setComplemento(rs.getString("complemento"));
           obj.setBairro(rs.getString("bairro"));
           obj.setCidade(rs.getString("cidade"));
           obj.setUf(rs.getString("estado"));
           
           
           lista.add(obj);
               System.out.println("Bairro: "+obj.getBairro()+" \n Nome: "+obj.getNome());
           
           }
           
             return lista;                   
                
       } catch (Exception e) {         
           
           JOptionPane.showMessageDialog(null,"erro"+ e);
           return null;
       } 
   } 
   
    public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

   
}
}

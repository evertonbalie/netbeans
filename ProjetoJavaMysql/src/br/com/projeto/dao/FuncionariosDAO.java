/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionariosDAO {
    
    private Connection con;
    
    public FuncionariosDAO(){
    this.con= new ConnectionFactory().getConnection();
    }
    
    public void cadastrarFuncionarios( Funcionarios obj){
   
       try {
           
String sql ="insert into tb_funcionarios"
        + "( nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular"
        + ",cep,endereco,numero,complemento,bairro,cidade,estado)"
        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        
           PreparedStatement stmt = con.prepareStatement(sql);
           
           stmt.setString(1,obj.getNome());
           stmt.setString(2,obj.getRg());
           stmt.setString(3,obj.getCpf());
           stmt.setString(4,obj.getEmail());
           stmt.setString(5,obj.getSenha());
           stmt.setString(6,obj.getCargo());
           stmt.setString(7,obj.getNivel_acesso());
           stmt.setString(8,obj.getTelefone());
           stmt.setString(9,obj.getCelular());
           stmt.setString(10,obj.getCep());
           stmt.setString(11,obj.getEndereco());
           stmt.setInt(12,obj.getNumero());
           stmt.setString(13,obj.getComplemento());
           stmt.setString(14,obj.getBairro());
           stmt.setString(15,obj.getCidade());
           stmt.setString(16,obj.getUf());
           
           stmt.execute();
           
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
           stmt.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro"+ e);
           
           
           
           
           
        
       }
   }
    
  public void ExcluirFuncionarios(Funcionarios obj){
       try {
           String sql= "delete from tb_funcionarios where id=?";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, obj.getId());
           stmt.execute();
           stmt.close();
           
           JOptionPane.showMessageDialog(null, "Excluido com sucesso");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro de exclusão"+ e);
       }
   }
    
       public List<Funcionarios> listarFuncionarios(){
       try {
          
           List<Funcionarios> lista = new ArrayList<>();
           
           String sql = "select * from tb_funcionarios";        
           
           PreparedStatement stmt = con.prepareStatement(sql);
           
           ResultSet rs =stmt.executeQuery();
           
           while(rs.next()){
           
           Funcionarios obj = new Funcionarios();
           /*nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado*/
           obj.setId(rs.getInt("id"));
           obj.setNome(rs.getString("nome"));
           obj.setRg(rs.getString("rg"));
           obj.setCpf(rs.getString("cpf"));
           obj.setEmail(rs.getString("email"));
           obj.setSenha(rs.getString("senha"));
           obj.setCargo(rs.getString("cargo"));
           obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
       
        public List<Funcionarios> PesquisarFuncionariosPorNome(String nome) {
       
        try {
            List<Funcionarios> pesquisa = new ArrayList<>();
            String sql = "select * from tb_funcionarios where nome like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){            
            
           Funcionarios obj = new Funcionarios();
           /*nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado*/
           obj.setId(rs.getInt("id"));
           obj.setNome(rs.getString("nome"));
           obj.setRg(rs.getString("rg"));
           obj.setCpf(rs.getString("cpf"));
           obj.setEmail(rs.getString("email"));
           obj.setSenha(rs.getString("senha"));
           obj.setCargo(rs.getString("cargo"));
           obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
}      
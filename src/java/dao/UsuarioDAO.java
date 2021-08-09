
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import model.Usuario;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlandeMedeiros
 */
@ManagedBean(name="Usuario")

public class UsuarioDAO {
    private  Connection connection;

    private Usuario usuario;
    public UsuarioDAO() throws ClassNotFoundException{
        this.connection=new ConnectionFactory().getConnection();
        this.usuario=new Usuario();
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     public String logar(Usuario u){
        try{
            PreparedStatement stmt=connection.prepareStatement("select * from usuario where email=? and senha=?");
            stmt.setString(1,u.getLogin());
            stmt.setString(2,u.getSenha());
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                this.usuario=u;
                this.usuario.setId(rs.getInt("id"));
             
                return "faces/home";
            //tem resultado
            }else{
                this.usuario= new Usuario();
                return "index";

                // não tem resultado
           }
        }catch(SQLException s){
            throw  new RuntimeException(s);
        }
    }
   
      public String adicionaUsuario(Usuario u) {
        String sql="insert into usuario"+"(nome,email,senha)"+"values(?,?,?)";
        try{
            PreparedStatement stmt=connection.prepareStatement(sql);
                        stmt.setString(1,u.getNome());

            stmt.setString(2,u.getLogin());
            stmt.setString(3,u.getSenha());
           

            stmt.execute();    
            stmt.close();
             this.usuario=new Usuario();
             return "index";
        }catch(SQLException s){
            throw  new RuntimeException(s);
        }
    }
       public String altera(Usuario u) {
        String sql="update usuario set email=?,senha=? where id=?";
        try{
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
           

            stmt.setString(3,Integer.toString(u.getId()));
            stmt.execute();
            stmt.close();
            return "faces/listar";
        }catch(SQLException s){
              throw  new RuntimeException(s);

        }
    } 

}

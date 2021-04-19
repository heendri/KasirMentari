/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.kasir.mentari;

/**
 *
 * @author Hendri
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Authentification {

    private String username, password;
    private String query;

    public Authentification(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Authentification() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String Login() {
        query = "select * from tabel_pegawai where NIP='" + this.username + "' and Password='" + this.password + "'";
        return query;

    }
    public int Auth(){
        
        ResultSet r=new Database().getData(this.Login());
        int i=0;
        try {
            while(r.next()){

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    

}

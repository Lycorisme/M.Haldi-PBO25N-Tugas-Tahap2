package config;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class KoneksiDB {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/m_haldi_2210010283_pbo2";
    private String username = "root";
    private String password = "";
    
    public KoneksiDB() {
        
    }
    
    public Connection getKoneksiDB() throws SQLException {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
            System.out.println("Koneksi DB Berhasil");
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal!");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal! " + e.getMessage());
        }
        
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

     public boolean duplicateKey(String NamaTabel, String PrimaryKey, String isidata){
        boolean hasil=false;
        int i = 0;
        
        try {
            String SQL ="SELECT * FROM "+NamaTabel+" WHERE "+PrimaryKey+" ='"+isidata+"'";
            Statement perintah = getKoneksiDB().createStatement();
            ResultSet hasilData = perintah.executeQuery(SQL);
            
            while(hasilData.next()){
                i++;
            }
            if(i==1){
                hasil=true;
            }else{
                hasil=false;
            }
            
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
        return hasil;
    }
     
     
     public String getFieldTabel(String[] FieldTabelnya)
     {
         String hasilnya="";
         int deteksiIndexAkhir=FieldTabelnya.length-1;
        try {
             
            for (int i = 0; i < FieldTabelnya.length; i++){
                 
                if(i==deteksiIndexAkhir){   
                   hasilnya=hasilnya+FieldTabelnya[i];
                }else{
                   hasilnya=hasilnya+FieldTabelnya[i]+",";
                }
            }
        } catch (Exception e) 
            {
             System.out.println(e.toString());
            }  
        
         return "("+hasilnya+")";
     }
     
      public String getIsiTabel(String[] IsiTabelnya)
     {
        String hasilnya="";
        int deteksiIndexAkhir=IsiTabelnya.length-1;
        try {
             
            for (int i = 0; i < IsiTabelnya.length; i++){
                 
                if(i==deteksiIndexAkhir){   
                   hasilnya=hasilnya+"'"+IsiTabelnya[i]+"'";
                }else{
                   hasilnya=hasilnya+"'"+IsiTabelnya[i]+"',";
                }
            }
        } catch (Exception e) 
            {
             System.out.println(e.toString());
            }  
        
         return "("+hasilnya+")";
     }
      
      public void SimpanDinamis(String NamaTabel, String[] Fieldnya, String[] Isinya)
      {
            try {
              String SQLSave="INSERT INTO "+NamaTabel+" "+getFieldTabel(Fieldnya)+" VALUES "
                      +getIsiTabel(Isinya);
              Statement perintah =getKoneksiDB().createStatement();
              perintah.executeUpdate(SQLSave);
              perintah.close();
              JOptionPane.showMessageDialog(null,"Data Berhasil DiSimpan");
            } catch (Exception e) {
              System.out.println(e.toString());
            }
      }
      
       public String getFieldValueEdit(String[] Field, String[] value){
        String hasil = "";
        int deteksi = Field.length-1;
        try {
            for (int i = 0; i < Field.length; i++) {
                if (i==deteksi){
                    hasil = hasil +Field[i]+" ='"+value[i]+"'";
                }else{
                   hasil = hasil +Field[i]+" ='"+value[i]+"',";  
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return hasil;
    }

       public void UbahDinamis(String NamaTabel, String PrimaryKey, String IsiPrimary,String[] Field, String[] Value){
        
        try {
           String SQLUbah = "UPDATE "+NamaTabel+" SET "+getFieldValueEdit(Field, Value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
           Statement perintah = getKoneksiDB().createStatement();
           perintah.executeUpdate(SQLUbah);
           perintah.close();
           getKoneksiDB().close();
           JOptionPane.showMessageDialog(null,"Data Berhasil DiUbah");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
       
      public void HapusDinamis(String NamaTabel, String PK, String isi){
        try {
            String SQL="DELETE FROM "+NamaTabel+" WHERE "+PK+"='"+isi+"'";
            Statement perintah = getKoneksiDB().createStatement();
            perintah.executeUpdate(SQL);
            perintah.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

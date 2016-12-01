package exercicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class VisitanteTableModel extends AbstractTableModel{
    
    private final Connection conexao;
    private ArrayList<visitante> visitantes;

    public VisitanteTableModel(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int getRowCount() {
        if (visitantes != null) {
            atualizaDados();
         return visitantes.size();
      } else {
         atualizaDados();
         return 0;
}
      
    }

    @Override
    public int getColumnCount() {
        atualizaDados();
        return 3;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
      atualizaDados();
      switch (columnIndex) {
         case 0:
            return visitantes.get(rowIndex).getNome();
         case 1:
            return visitantes.get(rowIndex).getIdade();
         case 2:
             return visitantes.get(rowIndex).getEntrada();
         default:
            return "?";
}
    }
    
    @Override
   public String getColumnName(int column) {
      switch (column) {
         case 0:
            return "Nome";
         case 1:
            return "Idade";
         case 2:
             return "Entrada";
         default:
            return "?";
      }

}
    
    public void atualizaDados() {
      visitantes = new ArrayList<>();
      try {
          Statement operacao = conexao.createStatement();
          ResultSet resultado = operacao.executeQuery("SELECT nome,idade FROM visitante");
         int l = 0;
         while (resultado.next()) {
            String nome = resultado.getString(1);
            int idade = Integer.parseInt(resultado.getString(2));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            visitantes.add(new visitante(nome,idade,dateFormat.format(date)));

         }
      } catch (SQLException ex) {
          Logger.getLogger(VisitanteTableModel.class
                 .getName()).log(Level.SEVERE, null, ex);

      }
   }

    
}

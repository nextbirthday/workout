package temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GradeCalculatorLogic implements ActionListener {
    
    GradeCalculatorView view;
    
    public GradeCalculatorLogic( GradeCalculatorView view ) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            case "편집(토글)":
                if ( view.table.isEnabled() )
                    view.table.setEnabled( false );
                else
                    view.table.setEnabled( true );
                break;
            case "계산":
                view.table.setEnabled( false );
                
                // raw type 사용되지 않도록 타입캐스팅 필요
                Vector<Vector> records = view.model.getDataVector();
                for ( Vector score : records ) {
                    
                    double sum = Double.parseDouble( String.valueOf( score.get( 1 ) ) ) + Double.parseDouble( String.valueOf( score.get( 2 ) ) )
                                    + Double.parseDouble( String.valueOf( score.get( 3 ) ) );
                    score.setElementAt( sum, 4 );
                    score.setElementAt( sum / 3, 5 );
                    score.setElementAt( 1, 6 );
                    
                }
                
                for ( int i = 0; i < records.size(); i++ ) {
                    
                    for ( int j = 0; j < records.size(); j++ ) {
                        if ( Double.parseDouble( String.valueOf( records.get( j ).get( 4 ) ) ) < Double.parseDouble( String.valueOf( records.get( i ).get( 4 ) ) ) )
                            records.get( j ).setElementAt( Integer.parseInt( String.valueOf( records.get( j ).get( 6 ) ) ) + 1, 6 );
                    }
                }
                
                int index = 0;
                for ( Vector vector : records ) {
                    view.model.setValueAt( vector.get( 4 ), index, 4 );
                    view.model.setValueAt( vector.get( 5 ), index, 5 );
                    view.model.setValueAt( vector.get( 6 ), index, 6 );
                    index++;
                }
                
                break;
            case "삭제":
                if ( view.table.isEnabled() ) {
                    int row = view.table.getSelectedRow();
                    
                    if ( row != -1 ) {
                        int result = JOptionPane.showConfirmDialog( view, "삭제하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
                        if ( result == 0 )
                            view.model.removeRow( row );
                    }
                    else
                        JOptionPane.showMessageDialog( view, "삭제할 레코드를 선택해주세요.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                    JOptionPane.showMessageDialog( view, "편집 모드에서만 삭제할 수 있습니다.", "Error", JOptionPane.ERROR_MESSAGE );
                break;
            case "종료":
                view.dispose();
                break;
        }
    }
}

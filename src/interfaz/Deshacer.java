package interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Deshacer extends AbstractAction{
    
     private UndoManager manager;
     
     public Deshacer(UndoManager manager){
        this.manager = manager;
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            manager.undo();
        }catch (CannotUndoException e){
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
}

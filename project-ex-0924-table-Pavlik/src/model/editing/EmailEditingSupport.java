package model.editing;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import model.Person;

public class EmailEditingSupport extends EditingSupport {
   private final TableViewer viewer;
   private TextCellEditor editor;

   public EmailEditingSupport(TableViewer viewer) {
      super(viewer);
      this.viewer = viewer;
      this.editor = new TextCellEditor(viewer.getTable());
   }

   @Override
   protected Object getValue(Object element) {
      return ((Person) element).getEmail();
   }

   @Override
   protected void setValue(Object element, Object value) {
      ((Person) element).setEmail(String.valueOf(value));
      viewer.update(element, null);
   }

   protected CellEditor getCellEditor(Object element) {
	      return this.editor;
	   }

	   @Override
	   protected boolean canEdit(Object element) {
	      return true;
	   }
}

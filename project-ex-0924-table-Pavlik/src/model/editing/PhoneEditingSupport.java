package model.editing;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import model.Person;

public class PhoneEditingSupport extends EditingSupport {
   private final TableViewer viewer;
   private TextCellEditor editor;

   public PhoneEditingSupport(TableViewer viewer) {
      super(viewer);
      this.viewer = viewer;
      this.editor = new TextCellEditor(viewer.getTable());
   }

   @Override
   protected Object getValue(Object element) {
      return ((Person) element).getPhone();
   }

   @Override
   protected void setValue(Object element, Object value) {
      ((Person) element).setPhone(String.valueOf(value));
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

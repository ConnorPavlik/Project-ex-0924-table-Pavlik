
package handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import model.Person;
import model.PersonModelProvider;
import util.MsgUtil;
import view.MyTableViewer;
import util.UtilFile;

public class AddPersonHandler {
   @Inject
   private EPartService epartService;
   @Inject
   @Named(IServiceConstants.ACTIVE_SHELL)
   Shell shell;

   @Execute
   public void execute(EPartService epartService) {
      MPart findPart = epartService.findPart(MyTableViewer.ID);
      Object findPartObj = findPart.getObject();

      if (findPartObj instanceof MyTableViewer) {
         MyTableViewer v = (MyTableViewer) findPartObj;
         
         add();
         v.refresh();
      }
   }

   private void add() {
	   List<String> contents = UtilFile.readFile(getFilePath());
	      List<List<String>> tableContents = UtilFile.convertTableContents(contents);
	      
	      for(List<String> iList : tableContents) {
	    	  PersonModelProvider.INSTANCE.getPersons().add(new Person(iList.get(0),iList.get(1),iList.get(2),iList.get(3)));
	      }
         
   }
   private static String getFilePath() {
		  return "/Users/pav/Library/CloudStorage/iCloud Drive/Desktop/CSCI8710/workspaceCSCI8710/workspaceCSCI8710-Pavlik/project-ex-0924-table-Pavlik/input_add.csv";
	   }
}

/*
PersonModelProvider personInstance = PersonModelProvider.INSTANCE;
AddPersonDialog dialog = new AddPersonDialog(shell);
dialog.open();
if (dialog.getPerson() != null) {
   personInstance.getPersons().add(dialog.getPerson());
   MPart findPart = epartService.findPart(MyTableViewer.ID);
   Object findPartObj = findPart.getObject();

   if (findPartObj instanceof MyTableViewer) {
      MyTableViewer v = (MyTableViewer) findPartObj;
      v.refresh();
   }
}
*/

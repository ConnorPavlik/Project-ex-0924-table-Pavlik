package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum PersonModelProvider {
   INSTANCE(getFilePath());

   private List<Person> persons;

   private PersonModelProvider(String file) {
      List<String> contents = UtilFile.readFile(file);
      List<List<String>> tableContents = UtilFile.convertTableContents(contents);
      
	   
	   
	   persons = new ArrayList<Person>();
      for(List<String> iList : tableContents) {
    	  if(iList.size() == 4)
    	  persons.add(new Person(iList.get(0),iList.get(1),iList.get(2),iList.get(3)));
      }
   }

   private static String getFilePath() {
	  return "/Users/pav/Library/CloudStorage/iCloud Drive/Desktop/CSCI8710/workspaceCSCI8710/workspaceCSCI8710-Pavlik/project-ex-0924-table-Pavlik/input_init.csv";
   }

   public List<Person> getPersons() {
      return persons;
   }
}

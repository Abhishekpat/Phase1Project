import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class phase1Project {
	
	
	public static void  main ( String [] args){
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Application Name = LockedMe.com");
		System.out.println("Developer Name = Abhishek patil");
		 
		int choice1,choice2 ;
		
		do {
		
		
		System.out.println("----Main Menu-----");
		 System.out.println("Enter 1 for  View All files");
		 System.out.println("Enter 2 for Add/Delete/Search file");
		 System.out.println("Enter 3 for Closing the application");
		 System.out.println("-----------------------");
		 System.out.println("Enter your choice ");
		  choice1 = sc.nextInt();
		  
		  
		  if(choice1 == 1) {
			  viewAllFiles();
		  }
		  else if(choice1 == 2){
			  do {	 
				  System.out.println("Enter 1 for Adding file");
				  System.out.println( "Enter 2 for Deleting File");
				  System.out.println("Enter 3 for Searching a File");		
				  System.out.println("Enter 0 for closing");
				  System.out.println("Enter your Choice ");
				  choice2 = sc.nextInt();

				  switch(choice2){
				    case 1 : 
				    System.out.println("Enter the Name of the File with fileFormat");
				   String fileName = sc.next();
				   
				    createFile(fileName);
				    break;
				    
				    
				    case 2 : 
				    	System.out.println("Enter the name of file you want to delete");
				    	String fileDelete = sc.next();
				    	deleteFile(fileDelete);
				    	break;
				    	
				    	
				    case 3 :
				    	System.out.println("Enter the name of the file you want to search");
				    	String fileSearchName = sc.next();
				    	searchFile(fileSearchName);
				    	break;
				    	
				    
				    	
				    default :
				    	System.out.println("Exiting from  current program");
				    	break;
				  }
				} while(choice2 != 0);
		  }
			  
			  else if(choice1 == 3) {
				  System.out.println("Exiting from main menu !!THANK YOU FOR VISITING!!");

			  }
		}while(choice1 != 3);

		  }

		
		
	

	private static void searchFile(String fileSearchName) {
		 File myFile = new File("C:\\Users\\Abhishek Patil\\eclipse-workspace\\Phase1Project\\files");
	      String[] myFileList = myFile.list();
	      
	      if (myFileList == null) {
	         System.out.println("does not exist or is not a directory");
	      } else {
	         for (int i = 0; i < myFileList.length; i++) {
	           fileSearchName = myFileList[i];
	            System.out.println(fileSearchName+ " is found");
	          
	         }
	      }
		
	}

	private static void viewAllFiles() {
		 File directoryPath = new File("C:\\Users\\Abhishek Patil\\eclipse-workspace\\Phase1Project");
	      //List of all files and directories
	      String contents[] = directoryPath.list();
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	      }	
	}

	private static void deleteFile(String fileDelete) {
		File myFile = new File(fileDelete);
		if(myFile.delete()) {
		System.out.println(fileDelete+" is Successfully deleted ");
		}
		else {
			System.out.println("Failed in deleting the file");
		}
		
	}

	private static void createFile(String fileName) {
			File myFile = new File(fileName);
			
			
			try {
				myFile.createNewFile();
				System.out.println(fileName+ "  is created Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
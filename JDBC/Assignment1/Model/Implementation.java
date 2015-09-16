package Model;

import java.util.ArrayList;

import Business.Title;

public class Implementation {
	
	
	public static void main(String[] args) {
		
		//find all books written by an author
		ArrayList<Title> titleList= QueryOnDatabase.getBookPublishedByAuthor();
		if(!titleList.isEmpty()){
			System.out.println( "TitleId		TitleName	" );
			for ( Title t:titleList ) {
				System.out.println(t.getTitleId()+"          "+t.getTitleName());	
			}
		}
		
		//make new entry in book_issue table
		int flag = QueryOnDatabase.setBookEntry();
		if(flag==1){
			System.out.println("Mission Completed");
		}
		
		//delete books that are not longer used
		int flag1 = QueryOnDatabase.executeQueryTODeleteBooksNotIssuedInLast1Yeat();
		if(flag!=1){
			System.out.println("Number of books deleted = "+flag1);
		}
	}
}

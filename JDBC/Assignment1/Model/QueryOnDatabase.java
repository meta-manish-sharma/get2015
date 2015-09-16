package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Business.Books;
import Business.Members;
import Business.Title;
import Connection.ConnectionUtil;

public class QueryOnDatabase {
	
	static Scanner scan = new Scanner(System.in);
	
	
	
	/*Delete all those books which were not issued in last 1 year. Return the number of books deleted. */
	public static int executeQueryTODeleteBooksNotIssuedInLast1Yeat() {
        String query = "DELETE FROM B Using Books AS B WHERE(PERIOD_DIFF(DATE_FORMAT(CURDATE(), '%Y%m'),DATE_FORMAT((SELECT BI.issue_dt FROM Book_Issue BI WHERE BI.accession_No=B.accession_No "
                + "ORDER BY BI.issueDate DESC LIMIT 0,1), '%Y%m'))>12 OR (PERIOD_DIFF(DATE_FORMAT(CURDATE(), '%Y%m'),DATE_FORMAT(B.purchase_dt, '%Y%m') )>12 AND "
                + " NOT EXISTS(SELECT BI.issue_dt FROM Book_Issue BI WHERE BI.accession_No=B.accession_No ORDER BY BI.issue_dt DESC LIMIT 0,1) ))";
        Connection connection = null;
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = connectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalBooksDeleted = 0;
        try {
            preparedStatement = connection.prepareStatement(query);
            /* set variable in prepared statement */
            totalBooksDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* close connection */
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalBooksDeleted;
    }
	
	/*Given the name of the book, to be issued by an existing member.Return flag to indicate whether the  the book has been issued or not.*/
	public static int setBookEntry(){
		int flag = 0;
		
		ArrayList<Members> memberList=new ArrayList<Members>();
		ArrayList<Books> bookList=new ArrayList<Books>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();

		String query  = "SELECT member_nm, member_id from Members WHERE member_nm= ? ";
		String query1 = "SELECT B.accession_no from Titles T JOIN Books b ON B.title_Id=T.title_Id AND B.status = 'F' WHERE title_nm= ? ";
		String query2 = "UPDATE books SET status='N' WHERE accession_no = ?;";
		String query3 = "INSERT INTO book_issue (`accession_no`, `member_id`) VALUES (?,?);";
		System.out.println("Enter name of member");
		String memberName = scan.nextLine();
			
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,memberName);
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				System.out.println("Member does not exists");
				return flag;
			}
			else{
				rs.beforeFirst();
				Members member;
				while(rs.next()) {
					member=new Members();
					member.setMember_nm(rs.getString(1));
					member.setMember_id(rs.getString(2));
					memberList.add(member);
				}
				System.out.println("Enter title of book");
				String bookTitle=scan.nextLine();
			
				ps = con.prepareStatement(query1);
				ps.setString(1, bookTitle);
				rs = ps.executeQuery();
				if(!rs.next()) {
					System.out.println("Book does not exists");
					return flag;
				}
				else{
					rs.beforeFirst();
					Books books;
					while(rs.next()) {
						books=new Books();
						books.setAccessionNo(rs.getInt(1));
						bookList.add(books);
					}
				}
				
				Books books = bookList.get(0);
				ps = con.prepareStatement(query2);
				ps.setInt(1, books.getAccessionNo());
				ps.executeUpdate();
				
				Members members = memberList.get(0);
				ps = con.prepareStatement(query3);
				ps.setString(2, members.getMember_id());
				ps.setInt(1,books.getAccessionNo());
				flag = ps.executeUpdate();
				
			}	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	
		try {
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		return flag;
	}
	
	/*Fetch all the books published by author, given the name of the author. 
	Return the books data (List of Titles).*/
	public static ArrayList<Title> getBookPublishedByAuthor(){
		
		ArrayList<Title> titleList=new ArrayList<Title>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		String query = "select T.title_Id,T.title_nm from Titles T JOIN Title_Author TA ON T.title_Id=TA.title_Id "
						+ "JOIN Authors A ON A.author_Id=TA.author_Id WHERE author_nm= ? ";
	
		System.out.println("Enter author name");
		String authorName=scan.nextLine();
		
		Title title=null;
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1,authorName);
		
			rs = ps.executeQuery();
			
			if(!rs.next()){
				System.out.println("Author does not exists");
				return titleList;
			}
			rs.beforeFirst();
			while (rs.next()) {
				
				title=new Title();
				title.setTitleId(rs.getString(1));
				title.setTitleName(rs.getString(2));
				titleList.add(title);
			
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return titleList;
	}
}

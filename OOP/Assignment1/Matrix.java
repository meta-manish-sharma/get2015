/**Matrix class
 *@auther Manish 
 */

import java.util.Scanner;



public class Matrix {
	
	private int data[][];
	private int nRows;
	private int nCols;
	//constructor
	public Matrix(int row,int col){
		this.nRows=row;
		this.nCols=col;
		data=new int [nRows][nCols];
	}
	
	//method to add element in 2-D matrix
	public void addElement(int row,int col,int val){
		data[row][col]=val;
	}
	
	//method to show elements of matrix
	public void showElement(){
		for(int i=0;i<this.nRows;i++){
			for(int j=0;j<this.nCols;j++){
				System.out.print(" "+this.data[i][j]);
			}
			System.out.println();
		}
	}
	
	//method to transpose the matrix
	public Matrix  tanspose(){
		Matrix trans=new Matrix(nCols,nRows);
		
		for(int i=0;i<nCols;i++){
			for(int j=0;j<nRows;j++){
				trans.data[i][j]=data[j][i];
			}
		}
		return trans;
	}
	
	//execution starts from here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row,col;
		System.out.println("Enter the number of rows and columns of matrix");
		row=sc.nextInt();
		col=sc.nextInt();
		
		Matrix mat=new Matrix(row,col);
		
		System.out.println("Enter the elements of matrix");
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				int value = sc.nextInt();
				mat.addElement(i,j,value);
			}
		}
		sc.close();
		System.out.println();
		System.out.println("Matrix is  ");
		mat.showElement();
		System.out.println();
		System.out.println("Transpose of Matrix is  ");
		mat.tanspose().showElement();
		System.out.println();
		
	}

}

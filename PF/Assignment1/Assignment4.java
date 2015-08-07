
public class Assignment4 {
		public  int[][] FCFS( int arrival [], int job_size[] ,int n)
		{
			int[] wait= new int[n];
			int[] start= new int[n];
			int[] finished= new int[n];
			int[][] result=new int[n][5];
			wait[0]=0;
			start[0]=arrival[0];                                                            
			for(int i=0;i<n-1;i++)
			{
				finished[i]=start[i]+job_size[i]-1;
				if(arrival[i+1]<finished[i])
				{
					wait[i+1]=finished[i]-arrival[i+1]+1;
					start[i+1]=finished[i]+1;
				}
				else
				{
					wait[i+1]=0;
					start[i+1]=arrival[i+1];
				}
				
			}
			finished[n-1]=start[n-1]+job_size[n-1]-1;
			for(int i=0;i<n;i++)
			{
				result[i][0]=i+1;
				result[i][1]=arrival[i];
				result[i][2]=wait[i];
				result[i][3]=start[i];
				result[i][4]=finished[i];
			}
			
			return result;
		}
		
		public static void main(String args[])
		{
			Assignment4 assignment4=new Assignment4();
			int a[]={1,5,9,25};
			int s[]={12,7,2,5};
			int n=4;
			int out[][]=assignment4.FCFS(a,s,n);
			System.out.println("job\t"+"job arrived time "+" job waited time "+" job start at "+" job finished a");
			for(int j=0;j<n;j++)
			{
				System.out.println("\n");
				for(int i=0;i<5;i++)
				{
					System.out.print(out[j][i]+"\t\t");
				}
			}
		}
	}


import java.util.Scanner; 
public class lab2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Задача 1 введите число N = "); 
		int N = scan.nextInt();

//////////////////////////////////////////////////////1 
//		int j = 0; 
//		int i = 1; 
//		int num = 1;
//		do {
//		j=1;
//		num=1;
//		num*=i;
//		do {
//			System.out.printf("%d ", num); 
//			num = num+2; 
//			j++;
//		}while(j <= N);
//		System.out.println(); 
//		 i++;
//	}while (i <= N ); 
//	}
//}

		
////////////////////////////////////////////////////2 

//		int j; 
//		int i = 1; 
//		do {
//			j = 1; 
//	
//			do {
//				System.out.printf("%d ", j); 
//				j++; 
//				
//			}while(j <= i);
//			
//			System.out.println();
//			i++;
//			
//		}while(i <= N);
//	}
//}
		
		
////////////////////////////////////////////////////3
	
		
//		int j;
//		int i = 1; 
//		do {
//		j = 1; 
//		
//		do {
//			System.out.printf("%d ", j); 
//			j++;
//		}while(j <= N);
//		System.out.println(); 
//		
//		 i++;
//		 N=N-1;
//	}while (1 <= N ); 
//	}
//}
///////////////////////////////////////////////////4
//		int j=0;
//		
//		int i = 1; 
//		
//		do {
//			
//		j++; 
//		
//		do {
//			System.out.printf("%d ", N); 
//			N--;
//			
//		}while(j <= N);
//		System.out.println(); 
//		N = 5;
//		i++;
//		 
//	}while (i <= N); 
//	}
//}
///////////////////////////////////////////////////ДЗ 6А 

		
//	int i = 1; 
//	int j = 1; 
//	int M = N;
//	int Q = N;
//	do {
//		j = 1; 	
//		do {
//			System.out.printf(" %4d",M );
//			M = M+N;
//			j++;
//			
//		}while(j<=Q);
//		System.out.println(); 
//		
//		N--; 
//		M=N;
//		i++;
//	}while(i<=Q); 
//	}
//}
//		
		
///////////////////////////////////////////////////ДЗ 7А
		
		
//		int i = 1; 
//		int j = 1; 
//		int w = 1; 
//		
//		int R = 0; 
//		int y = 1;
//		int n = 1; 
//
//		do {
//			
//			if (i<=N){
//			j=1;
//			w=1; 
//			do {
//				R = R+y;  
//				j++; 
//				System.out.print(R+" ");
//			}while(j<=N);
//			i++;
//			}
//			
//			System.out.println(); 
//			
//			n++; 
//			y++;
//			R = n * N; 
//
//		if (i<=N){
//			do {
//				System.out.print(R+" ");
//				R = R-y;  
//				w++;
//			}while(w<=N);
//			i++;
//
//		}
//		
//			System.out.println(); 
//
//			n++;
//			y++; 
//
//		}while(i<=N); 
//		
//
//		}
//		
//		
//	}
//		
///////////////////////////////////////////////////ДЗ 1Б
		int j = 1; 
        int i = 1;
        int K = 2; 
        int M = N;
  
        do {     
        
        	j=1;
            do {
                if (j >= M){
                    System.out.printf("%d ", j);
                } else {
                    System.out.print("  ");
                }
                j++;
            } while (j <= N);
            M--;
            System.out.println();
            i++;   
        } while (i <= N);  
        	
        	i = 1;
        	M = N; 
        	j=1; 
        do {     
        	j=1;
            do {
                if (j >= K){
                    System.out.printf("%d ", j);
                } else {
                    System.out.print("  ");
                }
                j++;
            } while (j <= N);
            System.out.println();
            i++;   
        	K++;
        } while (i <= N);   
        
        	}
    }

		
		
		
		

		
		
		
		
		
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

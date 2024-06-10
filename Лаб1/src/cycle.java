
// вывод чисел 1.2.3.4...
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число N = "); 
//	byte num1 = scan.nextByte(); 
//	int i = 0; 
//	while (i <= num1) {
//		System.out.printf("%d ", i);
//		i++; 
//	}	
//}
//}

//100 90 80 70 60 50 40 30 20 10 0 
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число N = "); 
//	byte num1 = scan.nextByte(); 
//	int i = 0; 
//	while (i <= num1) {
//		System.out.printf("%d ", num1);
//		num1 -= 10;
//	}	
//}
//}

//умножение на 2 
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число N = "); 
//	int num1 = scan.nextInt(); 
//	int i = 1; 
//	while (i <= num1) {
//		System.out.printf("%d ", i);
//		i *= 2; 
//	}
//}
//}

//Каждое следующее число вычисляется по формуле A = A * 2;
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число N = "); 
//	int num1 = scan.nextInt(); 
//	int i = 1; 
//	int A = 0; 
//	while (A <= num1){
//		System.out.printf("%d ", A);
//		A = i*i; 
//		i++; 	
//	}
//	do{
//		System.out.printf("%d ", A);
//		A = i*i; 
//		i++;
//	}while (A <= num1);
//}
//}





//Каждое следующее число вычисляется по формуле A = A * I, I++;
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число n = "); 
//	int num1 = scan.nextInt(); 
//	int i = 1; 
//	int A = 1; 
//	while (i <= num1) {
//		System.out.printf("%d ", A);
//		i++;
//		A = A*i; 
//	}

//	do {
//		A = A*i; 
//		i++;
//
//		System.out.printf("%d ", A);
//	}while(i <= num1);
//}
//}





//фибоначчи 
//import java.util.Scanner;
//public class cycle {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Введите число N = "); 
//	int num1 = scan.nextInt(); 
//	int a = 0; 
//	int A1 = 1; 
//	int A2 = 1; 
//	int i = 0; 
//	while (i <= num1) {
//		System.out.printf("%d ", a);
//		a = A1 + A2; 
//		A1 = A2; 
//		A2 = a; 
//
//		i++; 
//		
//	}
//}
//}

//////////////////////////////////////////////////////////////////////////////////////////////////дз лаб 1 


//1
//import java.util.Scanner; 
//public class cycle {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in); 
//		System.out.print("Введите число num1 = "); 
//		int num1 = scan.nextInt();
//		System.out.print("Введите число num2 = "); 
//		int num2 = scan.nextInt(); 
//		int num3 = 0; 
//		int num4 = 0; 
//		
//		int i = 0; 
//		while (i < num1) {
//			num3 = num3 + num2; 
//			i++; 
//		}
//		System.out.printf("Результат: %d\n", num3); 
//
//
//	}
//}

//2
//import java.util.Scanner; 
//public class cycle {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in); 
//		System.out.print("Введите основание степени = "); 
//		int num2 = scan.nextInt(); 
//		System.out.print("Введите число показатель степени = "); 
//		int num1 = scan.nextInt();
//
//		int num3 = 1; 
//		int num4 = 0; 
//		
//		int i = 0; 
//		while (i < num1) {
//			num3 = num3*num2; 
//			i++; 
//		}
//		System.out.printf("Результат: %d\n", num3); 
//
//
//	}
//}


//3 
//import java.util.Scanner; 
//public class cycle {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in); 
//		System.out.print("Сумма вклада = "); 
//		float num2 = scan.nextFloat(); 
//
//		float num3 = 0; 
//		
//		int i = 0; 
//		while (i < 12) {
//			num3 = (float) (num2 * 0.0095); 
//			num2 = num3 + num2; 
//			i++; 
//			System.out.printf("Результат %d  месяца: %f\n", i, num2); 
//
//		}
//
//
//	}
//}


//4 

//import java.util.Scanner; 
//public class cycle {
//	public static void main (String[] args) {
//		Scanner scan = new Scanner (System.in); 
//		int num = 650000; 
//		System.out.printf("Населние на 2013 год: %d", num); 
//		float proc = (float) 0.03;
//		int i = 2013; 
//		float pep = 0; 
//		while(i<2024) {
//			pep = (float) (num*proc);
//			num = (int) (num + pep); 
//			i++;
//			System.out.printf("\nКоличсетво начелния в %d году = %d", i, num); 
//		}
//		
//	}
//}

//5
//import java.util.Scanner; 
//public class cycle {
//	public static void main (String[] args) {
//		Scanner scan = new Scanner (System.in); 
//		System.out.printf("Сумма вклада: "); 
//		float num = scan.nextFloat(); 
//		float proc = (float) 0.09;
//		int i = 0; 
//		float pep = 0; 
//		while(i<20) {
//			pep = (float) (num*proc);
//			num = (float) (num + pep); 
//			i++;
//			System.out.printf("\n %d год %.1f рублей", i, num); 
//		}
//		
//	}
//}

//6 
//import java.util.Scanner; 
//public class cycle{
//	public static void main (String[] args){ 
//		Scanner scan = new Scanner(System.in); 
//		System.out.print("Введите число N = "); 
//		int N = scan.nextInt(); 
//		
//		int i = 0; 
//		float num1 = 1; 
//		float num2 = 0;
//		float num3 = 1; 
//
//		while(i<N) {
//			num1  = 1/num3;
//			num2 = num2 + num1; 
//			System.out.printf("%.3f + ", num1); 
//			num3++;
//			i++; 
//		}
//		System.out.printf("\n\nИтого: %.3f ", num2); 
//
//	}
//}

//7
//import java.util.Scanner; 
//public class cycle{
//	public static void main (String[] args){ 
//		Scanner scan = new Scanner(System.in); 
//		System.out.print("Введите число N = "); 
//		int N = scan.nextInt(); 
//		int i = 0; 
//		float num1 = 1; 
//		float num2 = 0;
//		float num3 = 1; 
//		int f = 1; 
//		while(i<=N) {
//			num1  = 1/num3; 
//
//			num3 = 1;
//			int j = 1; 
//			while(j <= f) {
//			      num3 = num3 * j;
//				j++;
//			}
//			
//			num2 = num2 + num1; 
//			System.out.printf("%f + ", num1); 
//			f++;
//			i++; 
//		}
//		System.out.printf("\n\nИтого: %.1f ", num2); 
//
//	}
//}


//8
//import java.util.Scanner; 
//public class cycle{
//	public static void main(String[] args) {
//
//		int c = 15; 
//		float f = 1; 
//		while(c<=30) {
//			f = (float) (1.8*c+32); 
//			System.out.printf("\n%d°С = %.1f F",c, f); 
//			c++; 
//
//		}
//	}
//}



//9
//import java.util.Scanner; 
//public class cycle {
//	public static void main (String[] args) {
//
//		int num1 = 100000; 
//		int num2 = 200000; 
//		int num3 = 0; 
//		int num4 = 0; 
//		int i = 1; 
//		System.out.printf("      счет 1  счет 2"); 
//
//		while(num1 <= num2) {
//			num3 = (int) (num1*0.01);
//			num1 = num1 + num3; 
//			
//			num4 = (int) (num2*0.002);
//			num2 = num2 + num4; 
//		
//			System.out.printf("\n%d год %d  %d",i, num1, num2); 
//			i++; 
//
//
//		}
//		
//	}
//}



////10
//import java.util.Scanner; 
//public class cycle {
//	public static void main (String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int a0 = 10;
//		int sum = 0;
//		
//		int current = a0;
//		
//		int i = 0; 
//		
//		while (i<n) {
//			sum = sum + current;
//			current += 3;
//			
//			i++;
//			System.out.println(sum);
//
//		}
//		}
//		
//	}










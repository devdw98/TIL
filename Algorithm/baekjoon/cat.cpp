#include <iostream>

using namespace std;

int main()
{
	//10171 고양이 
	printf("\\    /\\ \n");
	printf(" )  ( ')\n");
	printf("(  /  )\n");
	printf(" \\(__)|\n");
	
	//10172 개
	printf("|\\_/|\n");
	printf("|q p|   /}\n");
	printf("( 0 )\"\"\"\\ \n");
	printf("|\"^\"`    |\n");
	printf("||_/=\\\\__|");
	
	//10869 사칙연산 

	int a;
	int b;
	
	cin >> a;
	cin >> b;
	cout << a+b << endl;
	cout << a-b << endl;
	cout << a*b << endl;
	cout << a/b << endl;
	cout << a%b << endl;

	//10430 나머지
	int a;
	int b;
	int c;
	
	cin >> a;
	cin >> b;
	cin >> c;
	
	cout << (a+b)%c << endl;
	cout << ((a%c)+(b%c))%c << endl;
	cout << (a*b)%c << endl;
	cout << ((a%c)*(b%c))%c << endl;

	//2588 곱셈 
	int a, b;
	int temp;
	int r1, r2, r3, r;
	
	cin >> a;
	cin >> b;
	
	temp = b % 10;
	r1 = a * temp;
	cout << r1 << endl;
	
	temp = (int)(b%100)/10;
	r2 = a * temp;
	cout << r2 << endl;
	
	temp = (int)(b/100);
	r3 = a * temp;
	cout << r3 << endl;
	
	r = r3 * 100 + r2 * 10 + r1;
	cout << r << endl;
}


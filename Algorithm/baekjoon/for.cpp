#include <iostream>


using namespace std;
int main()
{
	//2739 구구단
//	int n;
//	cin >> n;
//	for(int i = 1; i <= 9; i++)
//	{
//		cout << n << " * " << i << " = " << n * i << endl;
//	}

    //10950 A+B - 3
//    int a, b;
//    int t;
//    cin >> t;
//	for(int i=0; i < t; i++){
//		cin >> a;
//		cin >> b;
//		cout << a+b << endl;
//	}
	//8393 합
//	int num;
//	int result = 0;
//	cin >> num;
//	for(int i=1;i<=num;i++)
//	{
//		result += i;
//	}
//	cout << result << endl;

    //15552 빠른 A+B 
//	cin.tie(NULL);
//	std::ios::sync_with_stdio(false);
//	
//	int t;
//	int a, b;
//	cin >> t;
//	for(int i=0;i<t;i++)
//	{
//		cin >> a >> b;
//		cout << a+b <<"\n";
//	}

    //2741 N찍기 < endl 쓰면 시간초과 나옴 
//    cin.tie(NULL);
//	std::ios::sync_with_stdio(false);
//    int n;
//    cin >> n;
//    for(int i=1;i<=n;i++)
//    {
//    	cout << i << "\n";
//	}

    //2742 기찍N
//	cin.tie(NULL);
//	std::ios::sync_with_stdio(false);
//	int n;
//	cin >> n;
//	for(int i = n;i>0;i--)
//	{
//		cout << i << "\n";
//	} 

    //11021 A+B -7
    
//    int t;
//    int a, b;
//    cin >> t;
//    for(int i=1;i<= t; i++)
//    {
//    	cin >> a >> b;
//    	cout << "Case #" << i << ": "<< a+b << endl;
//	}

    //11022 A+B -8
//    int t;
//    int a, b;
//    cin >> t;
//    for (int i=1; i<=t; i++)
//    {
//    	cin >> a >> b;
//    	printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
//	}

    //2438 별찍기 -1
//	int num;
//	cin >> num;
//	for (int i=1;i<=num;i++)
//	{
//		for(int j=0;j<i;j++){
//			cout << "*";
//		}
//		cout << endl;
//	 } 
	
	//2439 별찍기 -2
//	int num;
//	cin >> num;
//	for(int i = 1; i<= num; i++)
//	{
//		for(int j = num; j>i; j--){
//			cout << " ";
//		}
//		for(int k = 0;k < i; k++){
//			cout << "*";
//		}
//		cout << endl;
//	 } 

    //10871 X보다 작은 수
	int n, x;
	cin >> n >> x;
	int a[n];
	for(int i=0;i<n;i++)
	{
		cin >> a[i];

	}
	for(int i=0;i<n;i++){
		if(a[i]<x)
		{
			cout << a[i] <<" ";
		}
	} 
	 
	return 0;
}


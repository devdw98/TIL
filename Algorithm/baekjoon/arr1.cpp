#include <iostream>
#include <string>
#include <typeinfo>

using namespace std;
int main()
{
	
	//10818 �ּ�, �ִ�
//	int n = 0;
//	int min = 0, max = 0;
//	int i;
//	cin >> n;
//	
//	int arr[n];
//	for(i=0;i<n;i++) {
//		cin >> arr[i];
//	}
//	
//	min = arr[0];
//	max = arr[0];
//	for(i = 0; i<n; i++){
//		if(arr[i] <= min){
//			min = arr[i];
//		}else if(arr[i] >= max){
//			max = arr[i];
//		}else{
//			continue;
//		}
//	}
//
//	cout << min << " " << max << endl;

    //2562 �ִ�
//	int arr[9];
//	int max = 0, n = 0, tmp = 0;
//	for(int i=0;i<9;i++){
//		cin >> arr[i];
//	}
////	max = arr[0]; 
//// arr[0] �� �� for���� if���� �������� �����Ƿ�  n���� �ٲ��� �ʴ´�. 
//	for(int i=0;i<9;i++){
//		tmp = arr[i];
//		if(max < arr[i]){
//			max = arr[i];
//			n = i+1;
//		}
//	}
//	cout << max << endl << n << endl;

    //2577 ������ ����
    //string ��� �ʿ�  
//	int a, b, c;
//	int tmp = 0, n = 0;
//	int num_arr[10] ={ 0, };
//	
//	cin >> a >> b >> c;
//	tmp = a * b * c;
//	string s = to_string(tmp);
//
//	for(int i=0;i<s.length();i++){
////		cout << s.at(i) << endl;
////        cout << s[i] <<endl;
//        num_arr[s[i] - '0']++;
//	}
//	
//	for(int i=0;i<10;i++){
//		cout << num_arr[i]<<endl;
//	}
	
	//3052 ������ -> �ڵ�  
	int arr[10];
	int n, m = 0; //tmp���� +  ���δٸ� ������ ���� 
	int i, j;
	
	for(i=0;i<10;i++){
		cin >> n;
		arr[i] = n % 42;
		
	}
//	cout << endl;
//	for(i = 0;i<10;i++){
//		cout << i<<": "<<arr[i]<<endl;
//	}
	n = 0;
	for(i = 0; i < 10; i++){
		n++;
		for(j = 0; j < 10; j++){
			if((i!=j)&&(arr[i]==arr[j])){
				cout << i <<" "<< j << endl;
				m++;
				n--;
				break;
			}
		}
	}
	n = n + m/2;
	cout << n << endl;
	
	return 0;
}

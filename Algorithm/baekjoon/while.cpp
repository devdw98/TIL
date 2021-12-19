#include <iostream>

using namespace std;
int main()
{
	//10952 A+B -5
	int a, b;
	while(true){
		cin >> a >> b;
		if((a > 0 && a < 10) && (b > 0 && b < 10)){
			
			cout << a + b << endl;
			
		}else if(a == 0 && b == 0){
			break;
		}else{
			cout << "잘못된 값입니다."<<endl;
		}
	}

    //10951 A+B -4
    // 파일의 끝 (EOF)을 올바르게 판단하는 법 연습하는 문제!
	 
//    int a, b;
//
//    while(true)
//    {
//    	cin >> a >> b;
//    	if(cin.eof() != true){
//    		if((a > 0 && a < 10) && (b > 0 && b < 10)){
//    		cout << a + b << endl;
//			}else{
//				cout << "잘못된 값입니다."<< endl;
//	//			break;
//			}	
//		}else{
//			break;
//		}
//    	
//	}

	//1110 더하기 사이클
		
//    int x = 0; //입력받는 수
//	int y = 0; //새로운 수
//	int tmp1 = 0, tmp2 = 0, tmp3 = 0; //계산을 위해 쓰이는 공간 
//    int n = 0; // 사이클 길이
//    
//	cin >> x; //26
//	y = x;
//	while(true){
//		if(y < 10){
//			tmp1 = 0;
//			tmp2 = y;
//		}else{
//			tmp1 = (int)y / 10; 
//			tmp2 = (int)y % 10; 
//		}
//		tmp3 = tmp1 + tmp2; 
//		tmp3 = tmp3 % 10;
//		y = tmp2 * 10 + tmp3; 
//		n++;
//		if(x == y)
//		    break;
//		
//	}
//	cout << n << endl;
	return 0;
}


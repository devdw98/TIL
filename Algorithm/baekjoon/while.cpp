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
			cout << "�߸��� ���Դϴ�."<<endl;
		}
	}

    //10951 A+B -4
    // ������ �� (EOF)�� �ùٸ��� �Ǵ��ϴ� �� �����ϴ� ����!
	 
//    int a, b;
//
//    while(true)
//    {
//    	cin >> a >> b;
//    	if(cin.eof() != true){
//    		if((a > 0 && a < 10) && (b > 0 && b < 10)){
//    		cout << a + b << endl;
//			}else{
//				cout << "�߸��� ���Դϴ�."<< endl;
//	//			break;
//			}	
//		}else{
//			break;
//		}
//    	
//	}

	//1110 ���ϱ� ����Ŭ
		
//    int x = 0; //�Է¹޴� ��
//	int y = 0; //���ο� ��
//	int tmp1 = 0, tmp2 = 0, tmp3 = 0; //����� ���� ���̴� ���� 
//    int n = 0; // ����Ŭ ����
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


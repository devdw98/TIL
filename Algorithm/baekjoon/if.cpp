#include <iostream>

using namespace std;

int main()
{
	//1330 �� �� ���ϱ� 
//	int a, b;
//	cin >> a;
//	cin >> b;
//	
//	if(a > b)
//	{
//		cout << ">" << endl;
//	}else if(a < b)
//	{
//		cout << "<" << endl;
//	}else
//	{
//		cout << "==" << endl;
//	}

	//9498 ���� ���� 
//	int score = 0;
//	cin >> score;
//	if(score>=90 && score <= 100)
//	{
//		cout << "A" << endl;
//	}else if(score >= 80)
//	{
//		cout << "B" << endl;
//	}else if(score >= 70)
//	{
//		cout << "C" << endl;
//	}else if(score >= 60)
//	{
//		cout << "D" << endl;
//	}else
//	{
//		cout << "F" << endl;
//	}
	
	//2753 ���� 
//	int year = 0;
//	cin >> year;
//	
//	if((year%4 == 0 && year%100 != 0)||(year % 400 == 0))
//	{
//		cout << 1 <<endl;
//	}else
//	{
//		cout << 0 << endl;
//	}

    //14681 ��и� ����
//	int x, y;
//	cin >> x;
//	cin >> y;
//	if((x>=-1000 && x<=1000 && x != 0) && (y>=-1000 && y<=1000 && y != 0))
//	{
//		if(x > 0 && y > 0)
//		{
//			cout << 1 << endl;
//		}else if(x < 0 && y > 0)
//		{
//			cout << 2 << endl;
//		}else if(x < 0 && y < 0)
//		{
//			cout << 3 << endl;
//		}else
//		{
//			cout << 4 << endl;
//		}
//	}else
//	{
//		cout << "���ǿ� �������� �ʽ��ϴ�." <<endl;
//	}
	
	//2884 �˶��� �� 
	int h, m;
	int temp;
	cin >> h;
	cin >> m;
	if((h >= 0 && h <= 23) && (m >= 0 && m <= 59))
	{
		h--;
		temp = m + 60 - 45;
		if(temp >= 60)
		{
		    h++;
			m = temp - 60;
		}else
		{
			m = temp;
		}
		
		if(h < 0){
			h = 23;
		}
		cout << h << " "<< m << endl;
		
	}else
	{
		cout <<"���ǿ� �������� �ʽ��ϴ�." << endl;
	 } 

	return 0;
}

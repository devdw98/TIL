#2-1
daum = 89000
naver = 751000
jusik = daum * 100 + naver * 20
print("2-1: ",jusik)

#2-2
des_daum = daum *0.95
des_naver = naver * 0.9
des_jusik = jusik - (des_daum*100 + des_naver*20)
print("2-2: ",des_jusik)

#2-3
F = 50
C = (F - 32) / 1.8
print("2-3: c=",C)

#2-4
print("2-4: pizza\n"*10)

#2-5
mon_naver = 100
wed_naver = ((mon_naver*0.7)*0.7)*0.7
print("2-5: ",wed_naver)

#2-6
name = "파이썬"
birth = "2014년 12월 12일"
num = "20141212-1623210"

print("2-6: "+name+" "+birth+" "+num)

#2-7
s = "Daum KaKao"
s = s[-5:] +s[4:5]+ s[:5]
print("2-7: "+s)

#2-8
a = 'hello world'
a = a.replace('hello','hi')
print("2-8: "+a)

#2-9
x = 'abcdef'
x = x[1:]+x[0]
print("2-9: "+x)
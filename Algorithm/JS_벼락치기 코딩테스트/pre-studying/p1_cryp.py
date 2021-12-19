import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

sun = '1'
moon = '0'

cryp = ['   + -- + - + -   ','   + --- + - +   ','   + -- + - + -   ','   + - + - + - +   ']
cryp_result = []

for i in cryp :
    result = i.replace('+', sun).replace('-', moon).replace(' ','')
    cryp_result.append(result)
print(cryp_result)

for j in cryp_result:
    n = len(j)-1
    tmp = 0
    for k in j:
        if k == sun:
            tmp += 2 ** n
        else:
            pass
        n -= 1
    print(chr(tmp)) #인코딩이 안되는 문제 있음 나중에 해결

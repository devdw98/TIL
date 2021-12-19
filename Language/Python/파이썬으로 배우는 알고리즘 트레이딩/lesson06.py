#6-1
class Point:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def setx(self,x):
        self.x = x

    def sety(self, y):
        self.y = y

    def get(self):
        return (self.x,self.y)

    def move(self, dx, dy):
        self.x = self.x + dx
        self.y = self.y + dy

#6-2
point = Point(1,1)
getPoint = point.get()
print(getPoint)
movePoint = point.move(1,2)
getPoint1 = point.get()
print(getPoint1)
point2 = Point(0,0)
point2.setx(3)
point2.sety(4)
getPoint2 = point2.get()
print(getPoint2)

#6-3
class Stock:
    market = "kospi"

# a = Stock() 과 b = Stock() 모두 아무 것도 없다

#6-4
# a.market : kospi
# b.market : kospi
# Stock.market : kospi
# a.market : kosdaq
# b.market :nasdaq
# Stock.market : kospi

#6-5
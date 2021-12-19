class FourCal:
    def __init__(self, first, second):
        self.first = first
        self.second = second
    def setdata(self, first, second):
        self.first = first
        self.second = second
    def add(self):
        return self.first+self.second
    def sub(self):
        return self.first - self.second
    def mul(self):
        return self.first * self.second
    def div(self):
        return self.first / self.second

class MourFourCal(FourCal):
    def div(self):
        if self.second == 0:
            return 0
        else:
            return self.first / self.second
    def pow(self):
        return self.first ** self.second
    
first = FourCal(3,0)
print(first.add())
second = MourFourCal(4,2)
print(second.add())
print(second.pow())
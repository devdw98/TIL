class Wizard :
   def  __init__(self, health, mana, armor):
       self.health = health
       self.mana = mana
       self.armor = armor

   def attack(self):
        #print(self.health,self.mana, self.armor, sep=" ")
        print('파이어볼')


x = Wizard(health = 545, mana = 210, armor = 10)
print(x.health, x.mana, x.armor)
x.attack()
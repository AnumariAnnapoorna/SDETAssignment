import math

class Circle:
	def __init__(self,radius):
		self.radius=radius
	
	def getArea(self):
		return math.pi*self.radius**2
	
class Cylinder(Circle):
	def __init__(self,radius,height):
		super().__init__(radius)
		self.height=height
	
	def getArea(self):
		return 2*math.pi*self.radius*(self.radius+self.height)

	def getVolumn(self):
		return math.pi*self.radius**2*self.height

cylinder=Cylinder(5,10)
print("The area of Cylinder is: ", cylinder.getArea())
print("The volumn of Cylinder is: ", cylinder.getVolumn())
from __future__ import unicode_literals

from django.db import models

class SalesUser(models.Model):
	type = models.CharField(max_length = 10, default=None)
	def getMinPhoneQuantity():
		if type == None:
			return None
		elif type == 1:
			return 1
		elif type == 2:
			return 10000

class Order(models.Model):
	amtB = models.IntegerField(default=0)
	amtM = models.IntegerField(default=0)
	amtH = models.IntegerField(default=0)
	costB = models.IntegerField(default=100, editable = False)
	costM = models.IntegerField(default=200, editable = False)
	costH = models.IntegerField(default=300, editable = False)
	def getTotal(self, type):
		if type == 'B':
			return self.amtB*self.costB
		elif type == 'M':
			return self.amtM*self.costM
		elif type == 'H':
			return self.amtH*self.costH
		elif type == "T":
			return(self.getTotal('B') + self.getTotal('M') + self.getTotal('H'))
	address = models.CharField(max_length = 100, default=None)

class Phone(models.Model):
	PHONE_MODEL_CHOICES = (
		(0,"B Model"),
		(1,"M Model"),
		(2,"H Model"),
	)
	phone_model = models.IntegerField(choices=PHONE_MODEL_CHOICES)
	MEMORY_CHOICES = (
		(0,16),
		(1,32),
		(2,128),
	)
	MEMORY = models.IntegerField(choices=MEMORY_CHOICES)
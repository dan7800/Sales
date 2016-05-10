from django.shortcuts import *
from django.http import HttpResponse
from django.core.urlresolvers import reverse
from Web.models import SalesUser, Order
import requests
import json

def shipping(request):
	s = SalesUser.objects.get(id=1)
	type = s.type
	o = Order.objects.latest('id')
	amtB = o.amtB
	amtM = o.amtM
	amtH = o.amtH
	costB = o.costB
	costM = o.costM
	costH = o.costH
	totalB = o.getTotal('B')
	totalH = o.getTotal('H')
	totalM = o.getTotal('M')
	totalT = o.getTotal('T')
	success = False
	message = [None] * 1
	if request.method == 'POST':
		address = request.POST.get('address')
		if (not address):
			message[0] = "Please enter an address"
		else:
			o.address = address
			o.save()
			success = True
			#begin hardcoded api calls
			url = 'http://localhost:8069/makeTransaction'
			userid = 0
			product_id = 0
			quantity = 0
			if type == "Customer":
				userid = 1
			if amtM > 0:
				product_id = 1
				quantity = amtM
			elif amtH > 0:
				product_id = 2
				quantity = amtH
			else:
				quantity = amtB
			data = {'userId': userid, 'product_id':product_id, 'quantity':quantity}
			headers = {'Content-Type': 'application/json'}
			r = requests.post(url, data=json.dumps(data), headers=headers)
	context = {'success':success, 'message':message, 'type':type, 'totalT':totalT, 'totalB':totalB, 'totalM':totalM, 'totalH':totalH, 'costB':costB, 'costM':costM, 'costH':costH, 'amtB':amtB, 'amtM':amtM, 'amtH':amtH}
	return render(request, 'shipping.html', context)

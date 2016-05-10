from django.shortcuts import *
from django.http import HttpResponse
from django.core.urlresolvers import reverse
from Web.models import SalesUser, Order

def order(request):
	s = SalesUser.objects.get(id=1)
	type = s.type
	if request.method == 'POST':
		amtB = request.POST.get('amtB')
		amtM = request.POST.get('amtM')
		amtH = request.POST.get('amtH')
		message = [None] * 4
		#these phones should really be derived from a database
		#is the string in text input "amtB" a positive integer?
		if amtB.isdigit():
			amtB = int(amtB)
		else:
			message[0] = "Please enter a positive integer"
		#is the string in text input "amtM" a positive integer?
		if amtM.isdigit():
			amtM = int(amtM)
		else:
			message[1] = "Please enter a positive integer"
		#is the string in text input "amtH" a positive integer?
		if amtH.isdigit():
			amtH = int(amtH)
		else:
			message[2] = "Please enter a positive integer"
		#this is a double check to ensure no strings are being passed through
		#and it works whether the "amt"s have been mutated to ints or not
		if isinstance(amtB, int) and isinstance(amtM, int) and isinstance(amtH, int):
			#is the sum of all these text inputs greater than one ? (for customer)
			if ((amtB+amtM+amtH) < 1) and type == "Customer":
				message[3] = "To order, you must request at least one phone"
			#is the sum of all these text inputs greater than 10 thousand ? (for business)
			elif ((amtB+amtM+amtH) < 10000) and type == "Business":
				message[3] = "You've ordered: {} phones. You must request at least 10,000 phones. ".format(amtB+amtM+amtH)
			else:
				o = Order()
				o.amtB = amtB
				o.amtM = amtM
				o.amtH = amtH
				o.address = ''
				o.save()
				return HttpResponseRedirect(reverse('shipping'))
		context = {'type':type, 'amtB':amtB, 'amtM':amtM, 'amtH':amtH, 'message':message}
		return render(request, 'order.html', context)
	context = {'type':type}
	return render(request, 'order.html', context)
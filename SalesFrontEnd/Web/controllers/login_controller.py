from django.shortcuts import *
from django.http import HttpResponse
from django.core.urlresolvers import reverse
from Web.models import SalesUser

def login(request):
	if request.method == 'POST':
		type = request.POST.get('borc')
		print(type)
		if (not SalesUser.objects.filter()):
			s = SalesUser()
			s.type = type
			s.save()
		else:
			s = SalesUser.objects.get(id=1)
			s.type = type
			s.save()
		return HttpResponseRedirect(reverse('order'))
	return render(request, 'login.html')

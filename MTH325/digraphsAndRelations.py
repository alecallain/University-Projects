Python 3.4.2 (v3.4.2:ab2c023a9432, Oct  5 2014, 20:42:22) 
[GCC 4.2.1 (Apple Inc. build 5666) (dot 3)] on darwin
Type "copyright", "credits" or "license()" for more information.
>>> WARNING: The version of Tcl/Tk (8.5.9) in use may be unstable.
Visit http://www.python.org/download/mac/tcltk/ for current information.

Alec Allain
Professor Santana
Project
Due 4/19/18

>>> ground1 = ['A', 'B', 'C']
>>> relation1 = [['A', 'A'], ['A', 'B'], ['A', 'C'], ['B', 'A'], ['B', 'C'], ['B', 'B'], ['C', 'A'], ['C', 'B'], ['C', 'C']]
>>> 
>>> def is_reflex(ground, relation):
	result = True
	for i in range(len(ground)):
		for j in range(len(relation)):
			if relation[j] == [ground[i], ground[i]]:
				result = True
			else:
				result = False
	return result

>>> is_reflex(ground1, relation1)
True
>>> 

>>> def is_sym(ground, relation):
	result = True
	for i in range(len(ground)):
		for j in range(len(relation)):
			if relation[j] == [ground[i-1], ground[1]] and relation[j] == [ground[i], ground[i-1]]:
				result = True
			else:
				result = False
	return result


>>> def is_antisym(ground, relation):
	result = False
	for i in range(len(ground)):
		for j in range(len(relation)):
			if relation[j] == [ground[i], ground[i-1]] and relation[j] == [ground[i-1], ground[i]]:
				result = False
			else:
				result = True
	return result


>>> def is_trans(ground, relation):
	result = True
	for i in range(len(ground)):
		for j in range(len(relation)):
			if relation[j] == [ground[i], ground[i-1]] and relation[j] == [ground[i-1], ground[i-2]] and relation[j] == [ground[i], ground[i-2]]:
				result = True
			else:
				result = False
	return result

>>> digraph1 = {'A' : ['B'],'B' : ['C'],'C' : ['B'],'D' : ['A','C']}

>>> def trans_close(digraph):
        newDict = {}
	post = list(digraph.keys())
	for key in digraph:
		if digraph[key] == [key]:
			newDict[key] = [key]
		elif digraph[key] == [post[0]] and digraph[post[0]] == [key]:
			newDict[key] = [post[0]]
			newDict[post[0]] = [key]
		elif digraph[key] == [post[0]] and digraph[post[2]] != [key]:
			newDict[key] = [post[0], post[2]]
	return newDict

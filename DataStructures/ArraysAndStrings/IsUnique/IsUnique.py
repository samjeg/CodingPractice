

def IsUnique(string):

	for s in string:
		charOcc = 0;


		for t in string:
			if charOcc >= 2:
				break
			if s == t:
				charOcc = charOcc + 1

		if charOcc > 1:
			return False

	return True


if __name__ == '__main__':
	print("Is unique: %s"%IsUnique("asduf"))
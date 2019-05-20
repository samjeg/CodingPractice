

function isUnique(string){
	for(i=0; i<string.length; i++){
		nextChar = string.charAt(i);
		charOcc = 0;

		for(j=0; j<string.length; j++){
			if(charOcc>=2){
				break;
			}
			if(nextChar==string.charAt(j)){
				charOcc++;
			}
		}
		if(charOcc>1){
			return false;
		}
	}
	return true;
}

console.log("Is Unique: "+isUnique("asdfhjj"));
public class IsUnique{
	public static void main(String[] args){
		System.out.println("is unique: "+isUnique("asdfhje"));
		System.exit(0);
	}

	private static boolean isUnique(String str){
		char nextChar;
		int charOcc = 0;

		for(int i=0; i<str.length(); i++){
			charOcc = 0;
			nextChar = str.charAt(i);

			for(int j=0; j<str.length(); j++){
				if(charOcc>=2){
					break;
				}
				if(nextChar==str.charAt(j)){
					charOcc++;
				}
			}
			if(charOcc>1){
				return false;
			}
		}
		return true;
	} 
}
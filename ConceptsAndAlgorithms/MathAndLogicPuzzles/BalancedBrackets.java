import java.util.Stack;
import java.util.HashMap;

class BalancedBrackets {
	public static void main(String[] param) {
		String s = "({[(([]]))]})";
		System.out.println("has balanced brackets: "+hasBalancedBrackets(s));
		System.exit(0);
	}

	public static boolean hasBalancedBrackets(String s) {
		if (s.length() % 2 > 0) return false;

		Stack stack = new Stack();
		HashMap map = new HashMap();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

        for (int i=0; i<s.length(); i++) {
        	char current = s.charAt(i);
        	if (map.containsKey(current)) {
        		if(stack.isEmpty() || map.get(current) != stack.pop()) return false;
        	} else {
        		stack.push(current);
        	}
        }

        return stack.isEmpty();
	}
}
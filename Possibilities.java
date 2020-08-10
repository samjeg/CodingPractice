class Possibilities {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("number of possibilities: "+numTilePossibilities(str));
        System.exit(0);
    }
    public static int numTilePossibilities(String tiles) {
        int[] chars = new int[26];
        int callOrder = 0;
        for(int i=0; i<tiles.length(); i++) {
            chars[tiles.charAt(i) - 'A']++;
        }
        return dfs(chars, callOrder);
    }
    
    public static int dfs(int[] arr, int callOrder) {
        callOrder++;
        System.out.println("---current call: "+callOrder+"---");
        int sum = 0;
        
        for(int i=0; i<26; i++) {
            if(arr[i] == 0) continue;
            
            sum++;
            arr[i]--;
            System.out.println("loop i: "+i+" sum: "+sum);
            sum += dfs(arr, callOrder);
            arr[i]++;
        }
        System.out.println("return sum: "+sum);
        return sum;
    }
}
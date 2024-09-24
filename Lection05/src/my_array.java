public class my_array {
    public static void main(String[] args) {
        int[] aa = new int[1000];

        System.out.println(allEq(aa));
    }

    static boolean allEq(int[] a){
        if(a==null)return false;
        for(int i=1;i<a.length;i++)if(a[i]!=a[i-1])return false;
        return true;
    }

}

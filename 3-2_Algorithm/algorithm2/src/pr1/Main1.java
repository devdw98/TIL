package pr1;

public class Main1 {
    public static void main(String[] args){
        String[] s1 = {"A","C","C","G","G","T","C","C","G","A","G","T","G",
        "C","G","C","G","G","A","A","G","C","C","G","G","C","C","G","A","A"};
        String[] s2 = {"G","T","C","G","T","T","C","G","G","A","A","T","G",
        "C","C","G","T","T","G","C","T","C","T","G","T","A","A","A"};
        LCSProblem pr = new LCSProblem(s1, s2);
        pr.exec();
        System.out.print("result = ");
        pr.printLCS(s1.length, s2.length);
    }
}

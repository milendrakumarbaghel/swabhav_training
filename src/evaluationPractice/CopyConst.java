package evaluationPractice;

public class CopyConst{
    int x;

    public CopyConst(int val) {
        this.x = val;
    }

    public CopyConst(CopyConst obj) {
        this.x = obj.x;
    }
}
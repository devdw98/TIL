import java.io.File;

public class CompareSize implements Comparable{

    @Override
    public int compareTo(Object o1, Object o2) {
        return ((FileInfo) o1).getSize()-((FileInfo) o2).getSize();
    }
}

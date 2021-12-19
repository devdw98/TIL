public class CompareFileType implements Comparable{
    @Override
    public int compareTo(Object o1, Object o2) {
        return ((FileInfo) o1).getType().compareTo(((FileInfo) o2).getType());
    }
}

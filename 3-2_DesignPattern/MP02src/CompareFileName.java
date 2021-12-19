public class CompareFileName implements Comparable{
    //내부적으로 FileInfo 타입으로 변환을 해서 두 개 비교
    @Override
    public int compareTo(Object o1, Object o2) {
        return ((FileInfo) o1).getName().compareTo(((FileInfo) o2).getName());
    }
}

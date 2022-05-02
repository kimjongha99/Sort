import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0); //get(0) 0번쨰 인덱스를 받는다는것

        ArrayList<Integer> leftarr = new ArrayList<>();
        ArrayList<Integer> rightarr = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightarr.add(dataList.get(index));
            } else {
                leftarr.add(dataList.get(index));
            }
        }
        // 간단히 ArrayList 생성 후, addAll() 메서드로 순차적으로 배열을 넣어줌
        ArrayList<Integer> MergedArr = new ArrayList<>();
        MergedArr.addAll(sort(leftarr));//ArrayList의 addAll() 메소드는 인자로 전달되는 Collection 객체의 모든 아이템을 리스트에 추가합니다.
        MergedArr.addAll(Arrays.asList(pivot));
        MergedArr.addAll(sort(rightarr));

        return MergedArr;

    }
    public static void main(String []args){
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        QuickSort qSort = new QuickSort();
        System.out.println(qSort.sort(testData));
    }
}
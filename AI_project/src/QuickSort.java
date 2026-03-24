import java.util.List;

public class QuickSort {
    static int partition(List<NodeWithValue> sorty, int low, int high)
    {
        int pivot = sorty.get(low).getValue();
        int i= low-1;

        for (int j=low; j<=high-1;j++)
        {
            if (sorty.get(j).getValue()<pivot)
            {
                i++;
                swap(sorty,i,j);
            }
        }
        swap(sorty,i+1, high);
        return i+1;
    }

    static void swap(List<NodeWithValue> sorty, int i, int j)
        {
            NodeWithValue temp = sorty.get(i);
            sorty.set(i, sorty.get(j));
            sorty.set(j, temp);
        }
        
    public void quickSort(List<NodeWithValue> sorty, int low, int high)
    {
        if (low<high)
        {
            int pi=partition(sorty, low, high);

            quickSort(sorty, low, pi-1);
            quickSort(sorty, pi+1, high);
        }
    }



}

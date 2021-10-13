/*******************************
 * 
 * Project: Sorting algorithm visualizer
 * Language: Java
 * Date: September 2021
 * 
 * Dev: Jayed Rafi
 *
*******************************/

import java.util.Scanner;
public class sortingVisualizer
{
    public static int count = 1;
    public static void main (String[] args)
    {
        String text = " Welcome to Sorting Algorithm Visualizer\n Bienvenue dans le visualiseur d'algorithmes de tri\n\n";
        text+=" Press 1: Bubble sort     |  Press 2: Insertion sort  \n Press 3: Selection sort  |  Press 4: Merge sort      \n Press 5: Quick sort\n\n";
        text+=" Note: To adjust the array values, use the testList array in the main method. \n\n";
        System.out.println(text);
        
        int[] testList = {1,8,3,9,4,5,7}; //Test array
        
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        
        if(inputNumber == 1)
        {
        visualize("Initial array", 0, testList);
        bubbleSort(testList);
        }
        else if(inputNumber == 2)
        {
        visualize("Initial array", 0, testList);
        insertionSort(testList);
        }
        else if(inputNumber == 3)
        {
        visualize("Initial array", 0, testList);
        selectionSort(testList);
        }
        else if(inputNumber == 4)
        {
        visualize("Initial array", 0, testList);
        mergeSort(testList, 0, testList.length-1);
        }
        else if(inputNumber == 5)
        {
        visualize("Initial array", 0, testList);
        quickSort(testList, 0, testList.length-1);
        }
        else
        { 
        System.out.println(" Not a valid input!");
        }
    }//main
    
    /**
     * 
     * Bubble sort algorithm
     * 
     */
    public static void bubbleSort(int[] list) {
    boolean sorted = false;
    int temp;
    int step = 1;
    
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i+1]) {
                temp = list[i];
                list[i] = list[i+1];
                list[i+1] = temp;
                sorted = false;
                visualize("Bubble sort algorithm", step, list);
                step++;
            }
        }
    }
    }//bubbleSort
    
    /**
     * 
     * Insertion sort algorithm
     * 
     */
    public static void insertionSort(int[] list) {
    int step = 1;
        for (int i = 1; i < list.length; i++) {
        int current = list[i];
        int j = i - 1;
        while(j >= 0 && current < list[j]) {
            list[j+1] = list[j];
            j--;
        }
        list[j+1] = current;
        visualize("Insertion sort algorithm", step, list);
        step++;
    }
    }//insertionSort
    
    /**
     * 
     * Selection sort algorithm
     * 
     */
    
    public static void selectionSort(int[] list) {
    int step = 1;
        for (int i = 0; i < list.length; i++) {
        int min = list[i];
        int minId = i;
        for (int j = i+1; j < list.length; j++) {
            if (list[j] < min) {
                min = list[j];
                minId = j;
            }
        }
        // swapping
        int temp = list[i];
        list[i] = min;
        list[minId] = temp;
        visualize("Selection sort algorithm", step, list);
        step++;
    }
    }//selectionSort
    
    /**
     * 
     * Merge sort algorithm
     * 
     */
    public static void mergeSort(int[] list, int left, int right) {
    if (right <= left) return;
    int mid = (left+right)/2;
    mergeSort(list, left, mid);
    mergeSort(list, mid+1, right);
    merge(list, left, mid, right);
    visualize("Merge sort algorithm", count++, list);
    }//mergeSort
    
    /**
     * 
     * Helper method for merge sort algorithm
     * 
     */
    private static void merge(int[] list, int left, int mid, int right) {
    // calculating lengths
    int lengthLeft = mid - left + 1;
    int lengthRight = right - mid;

    // creating temporary subarrays
    int leftArray[] = new int [lengthLeft];
    int rightArray[] = new int [lengthRight];

    // copying our sorted subarrays into temporaries
    for (int i = 0; i < lengthLeft; i++)
        leftArray[i] = list[left+i];
    for (int i = 0; i < lengthRight; i++)
        rightArray[i] = list[mid+i+1];

    // iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // copying from leftArray and rightArray back into array
    for (int i = left; i < right + 1; i++) {
        // if there are still uncopied elements in R and L, copy minimum of the two
        if (leftIndex < lengthLeft && rightIndex < lengthRight) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                list[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else {
                list[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        // if all the elements have been copied from rightArray, copy the rest of leftArray
        else if (leftIndex < lengthLeft) {
            list[i] = leftArray[leftIndex];
            leftIndex++;
        }
        // if all the elements have been copied from leftArray, copy the rest of rightArray
        else if (rightIndex < lengthRight) {
            list[i] = rightArray[rightIndex];
            rightIndex++;
        }
    }
    }//merge
    
    /**
     * 
     * Helper method for quick sort algorithm
     * 
     */
    private static int partition(int[] list, int begin, int end) {
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
        if (list[i] < list[pivot]) {
            int temp = list[counter];
            list[counter] = list[i];
            list[i] = temp;
            counter++;
        }
    }
    int temp = list[pivot];
    list[pivot] = list[counter];
    list[counter] = temp;

    return counter;
    }//partition
    
    /**
     * 
     * Quick sort algorithm
     * 
     */
    public static void quickSort(int[] list, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(list, begin, end);
    
    quickSort(list, begin, pivot-1);
    quickSort(list, pivot+1, end);
    visualize("Quick sort algorithm", count++, list);
    }//quickSort
    
    /**
     * 
     * A private helper method to find the maximum value
     * 
     */
    private static int maximum(int[] list)
    {
        int maximum = list[0];
        for(int i=0; i<list.length; i++)
        {
            if(list[i] > maximum)
            maximum = list[i];
        }
        return maximum;
    }//maximum
    
    /**
     * 
     * This method helps to visualize
     * Takes 3 inputs as parameter (Name of the sorting algorithm, current step and the array)
     * First it initializes the 2D array
     * Modify the indexes (Column of 2D is the value of each index in the list)
     * Example: If list[0] value is 6 then the first column of 2D index will be modified upto 6 indexes
     * Reverse the 2D matrix into another 2D matix to align the graph in correct order
     * Aligns the output style
     * 
     */
    public static void visualize(String name, int step, int[] list)
    {
        String array = "";
        String stepDisplay = "";
        String[][] helperArray = new String [maximum(list)+1][list.length];
        String[][] helperArrayTwo = new String [maximum(list)+1][list.length];
        String outline = "";
        
        if(step <= 1) //Only prints the name in the beginning
        System.out.println("\n Visualize: "+name+"\n");
        
        //Initializes the 2D array
        for(int i = 0; i<helperArray.length; i++)
        {
            for(int j=0; j<helperArray[0].length; j++)
            {
                helperArray[i][j] = "        ";
            }
        }
        
        //Modify the indexes
        for(int i = 0; i<list.length; i++)
        {
            for(int j = 0; j<list[i]; j++)
            {
                helperArray[(list[i]-1)-j][(list.length-1)-i] = "  |  |  ";
                helperArray[list[i]][(list.length-1)-i] = "   __   ";
            }
        }
        
        //Reverse 2D matix
        for(int i = 0; i<helperArray.length; i++)
        {
            for(int j=0; j<helperArray[0].length; j++)
            {
                helperArrayTwo[i][j] = helperArray[(helperArray.length-1)-i][(helperArray[0].length-1)-j];
            }
        }
        
        for(int i=0; i<helperArrayTwo[0].length*8; i++)
        {
            if(i== (helperArrayTwo[0].length*8)-1)
            outline+="-\n";
            else
            outline+="-";
        }
        
        stepDisplay+=" Step     : "+step+"\n Array    : [ ";
        for(int i=0; i<list.length; i++)
        {
            if(i != list.length-1)
            stepDisplay+=list[i]+",";
            else stepDisplay+=list[i]+" ]";
        }
        //System.out.println(outline);
        System.out.println(stepDisplay);
        for(int i = 0; i<helperArray.length; i++)
        {
            array = "";
            for(int j=0; j<helperArray[0].length; j++)
            {
                array+= helperArrayTwo[i][j];
            }
            System.out.println(array);
        }
        System.out.println(outline);
    } //visualize
}//End class sortingVisualizer

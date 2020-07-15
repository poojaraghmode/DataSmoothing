
package datasmoothening;
import java.util.Arrays;
import java.util.Scanner;

public class DataSmoothening {

    public static void main(String[] args) {
        // Data Smoothening
        System.out.println("Data Smoothening Program:");
        int arraySize, binSize, temp;
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nEnter the size of the array: ");
        arraySize=in.nextInt();
        
        int[] dataArray = new int[arraySize];
        
        System.out.println("Populate the data array with random values: ");
        for(int i = 0; i < arraySize; i++){
            dataArray[i]=in.nextInt();
        }
        
        System.out.println("\nEntered Data Array:");
        for(int i = 0; i < arraySize; i++){
            System.out.print(dataArray[i]+" ");
        }
        
        //Sorting
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j <= i; j++){
                if(dataArray[i] < dataArray[j]){
                    temp=dataArray[i];
                    dataArray[i]=dataArray[j];
                    dataArray[j]=temp;
                }
            }
        }
        
        System.out.println("\nSorted Data Array:");
        for(int i = 0; i < arraySize; i++){
            System.out.print(dataArray[i]+" ");
        }
        
        //Binning
        System.out.println("\nEnter bin size:");
        binSize = in.nextInt();
        int noOfBins = arraySize/binSize;
        int k=0, sum, avg;
        
        int[][] binArray = new int[noOfBins][binSize];
        for(int i = 0; i < noOfBins; i++){
            for(int j = 0; j<binSize; j++){
                binArray[i][j]=dataArray[k];
                k++;
            } 
        }
        
        System.out.println("\nOriginal Data in the Bins:");
        for(int i = 0; i < noOfBins; i++){
            System.out.print("Bin "+(i+1)+": ");
            for(int j = 0; j<binSize; j++){
                System.out.print(binArray[i][j]+"   ");
            }
            System.out.println();
        }
        
        int[][] avgArray = new int[noOfBins][binSize];
        for(int i = 0; i < noOfBins; i++){
            sum=0;
            for(int j = 0; j<binSize; j++){
                sum=sum+binArray[i][j];
            }
            avg=sum/binSize;
            for(int j=0;j<binSize;j++){
                avgArray[i][j]=avg;
            }
        }
        
        System.out.println("\nData in the Bins after Binning:");
        for(int i = 0; i < noOfBins; i++){
            System.out.print("Bin "+(i+1)+": ");
            for(int j = 0; j<binSize; j++){
                System.out.print(avgArray[i][j]+"   ");
            }
            System.out.println();
        }
    }   
}

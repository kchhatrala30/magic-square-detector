/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package magicsquaredetector;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author minis_a
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner input = new Scanner(new File("file.txt"));
        
        int[][] superSquare = returnArray("file.txt");
        
        if (isMagicSquare(superSquare))
        {
            System.out.println("This square is a magic square!");
        }
        else
        {
            System.out.println("This square is not a magic square...");
        }
    }
    
    public static int[][] returnArray(String filePath) throws IOException {
        Scanner input = new Scanner(new File(filePath));
        
        int[][] arrInts = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            String line = input.nextLine();
            String arr[] = new String[3];
            arr = line.split(" ");
            int newArr[] = new int[3];
            
            for (int j = 0; j < 3; j++)
            {
                newArr[j] = Integer.parseInt(arr[j]);
            }
            arrInts[i] = newArr;
        }
        
        return arrInts;
    }
    
    public static int numLinesInString(String fileName)
    {
        int counter = 0;
        for (int i = 0; i < fileName.length(); i++)
        {
            if (fileName.substring(i, i + 1).equals("\n"))
            {
                counter++;
            }
        }
        return counter + 1;
    }
    
    public static int[][] toSquare(String fileName)
    {
        int[][] returner = new int[numLinesInString(fileName)][numLinesInString(fileName)];
        
        return returner;
    }
    
    public static boolean isMagicSquare(int[][] squareArray)
    {
        return isRowMagic(squareArray) && isColumnMagic(squareArray) && isDiagonalMagic(squareArray);
    }
    
    public static boolean isRowMagic(int[][] tempParam)
    {
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        
        for (int i = 0; i < tempParam.length; i++)
        {
            row1 += tempParam[0][i];
            row2 += tempParam[1][i];
            row3 += tempParam[2][i];
        }
        
        if (row1 == row2 && row2 == row3)
        {
            return true;
        }
        return false;
    }
    
    public static boolean isColumnMagic(int[][] tempParam)
    {
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        
        for (int i = 0; i < tempParam.length; i++)
        {
            col1 += tempParam[i][0];
            col2 += tempParam[i][1];
            col3 += tempParam[i][2];
        }
        
        if (col1 == col2 && col2 == col3)
        {
            return true;
        }
        return false;
    }
    
    public static boolean isDiagonalMagic(int[][] tempParam)
    {
        int diag1 = 0;
        int diag2 = 0;
        
        for (int i = 0; i < tempParam.length; i++)
        {
            diag1 += tempParam[i][i];
            diag2 += tempParam[i][tempParam.length - 1 - i];
        }
        
        if (diag1 == diag2)
        {
            return true;
        }
        return false;
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        int[][] numbers = new int[6][5];
        int[][] test = new int[6][5];

        try
        {
            Scanner scanner = new Scanner(new File("input.txt"));
            int n=0;
            while(scanner.hasNextLine())
            {
                String temp = scanner.nextLine();
                String[] number = temp.split(":");

                for(int i=0; i<number.length; i++)
                {
                    {numbers[n][i] = Integer.parseInt(number[i]);}
                }
                n++;
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        test[5][0]=numbers[5][0];
        test[5][1]=numbers[5][1];
        test[5][2]=numbers[5][2];
        test[5][3]=numbers[5][3];
        test[5][4]=numbers[5][4];
        outLoop:
        for (int j = 1; j < 101; j++)
        {
            test[4][0]=j *numbers[4][0];
            test[4][1]=j *numbers[4][1];
            test[4][2]=j *numbers[4][2];
            test[4][3]=j *numbers[4][3];
            test[4][4]=j *numbers[4][4];
            for (int k = 1; k < 101; k++)
            {
                test[3][0]=k *numbers[3][0];
                test[3][1]=k *numbers[3][1];
                test[3][2]=k *numbers[3][2];
                test[3][3]=k *numbers[3][3];
                test[3][4]=k *numbers[3][4];
                for (int l = 1; l < 101; l++)
                {
                    test[2][0]=l *numbers[2][0];
                    test[2][1]=l *numbers[2][1];
                    test[2][2]=l *numbers[2][2];
                    test[2][3]=l *numbers[2][3];
                    test[2][4]=l *numbers[2][4];
                    for (int m = 1; m < 101; m++)
                    {
                        test[1][0]=m *numbers[1][0];
                        test[1][1]=m *numbers[1][1];
                        test[1][2]=m *numbers[1][2];
                        test[1][3]=m *numbers[1][3];
                        test[1][4]=m *numbers[1][4];
                        if(tester(test,numbers)!=0 && tester(test,numbers)<101)
                        {
                            FileWriter fileWriter;
                            try {
                                int i = (numbers[0][0]-(test[1][0]+ test[2][0]+ test[3][0]+ test[4][0]))/numbers[5][0];
                                    fileWriter = new FileWriter("output.txt");
                                    fileWriter.write(m + "\n" + l + "\n" + k + "\n" + j + "\n" + i);
                                    fileWriter.close();
                            } catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            break outLoop;
                        }
                    }
                }
            }
        }
    }

    static int tester(int[][] test, int[][] numbers)
    {
        int[] total = new int[5];

        total[0]=numbers[0][0]-(test[1][0]+ test[2][0]+ test[3][0]+ test[4][0]);
        total[1]=numbers[0][1]-(test[1][1]+ test[2][1]+ test[3][1]+ test[4][1]);
        total[2]=numbers[0][2]-(test[1][2]+ test[2][2]+ test[3][2]+ test[4][2]);
        total[3]=numbers[0][3]-(test[1][3]+ test[2][3]+ test[3][3]+ test[4][3]);
        total[4]=numbers[0][4]-(test[1][4]+ test[2][4]+ test[3][4]+ test[4][4]);


        if(total[0]%test[5][0]==0 && total[1]%test[5][1]==0 && total[2]%test[5][2]==0 && total[3]%test[5][3]==0 && total[4]%test[5][4]==0)
        {
            return total[0] / test[5][0];
        }
        return 0;
    }
}

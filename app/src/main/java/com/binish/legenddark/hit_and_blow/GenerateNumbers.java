package com.binish.legenddark.hit_and_blow;

import java.util.Random;

/**
 * Created by legenddark on 2016/01/11.
 */
public class GenerateNumbers {
    int numberInOrder[];
    Random numberGenerator = new Random();
    public void Generate(int level){
        int[] tempNumber= new int[level];
        for (int i = 0; i<level;i++){
            tempNumber[i] = numberGenerator.nextInt(6) + 1;
        }
        numberInOrder = tempNumber;
    }

    public void DeleteRepetation(){
        if(numberInOrder.length == 3){	//for level 1
            while ( numberInOrder[1] == numberInOrder[0] ){
                numberInOrder[1] = numberGenerator.nextInt(6)+ 1;
            }
            while ( numberInOrder[2] == numberInOrder[1] ||
                    numberInOrder[2] == numberInOrder[0] ){
                numberInOrder[2] = numberGenerator.nextInt(5)+ 1;
            }
        }
        else if(numberInOrder.length == 4){ //for level 2
            while ( numberInOrder[1] == numberInOrder[0] ){
                numberInOrder[1] = numberGenerator.nextInt(5)+ 1;
            }
            while ( numberInOrder[2] == numberInOrder[1] ||
                    numberInOrder[2] == numberInOrder[0] ){
                numberInOrder[2] = numberGenerator.nextInt(6)+ 1;
            }
            while ( numberInOrder[3] == numberInOrder[0] ||
                    numberInOrder[3] == numberInOrder[1] ||
                    numberInOrder[3] == numberInOrder[2]){
                numberInOrder[3] = numberGenerator.nextInt(6)+ 1;
            }
        }
        else if(numberInOrder.length == 5){	//for level 3
            while ( numberInOrder[1] == numberInOrder[0] ){
                numberInOrder[1] = numberGenerator.nextInt(6)+ 1;
            }
            while ( numberInOrder[2] == numberInOrder[1] ||
                    numberInOrder[2] == numberInOrder[0] ){
                numberInOrder[2] = numberGenerator.nextInt(5)+ 1;
            }
            while ( numberInOrder[3] == numberInOrder[0] ||
                    numberInOrder[3] == numberInOrder[1] ||
                    numberInOrder[3] == numberInOrder[2]){
                numberInOrder[3] = numberGenerator.nextInt(6)+ 1;
            }
            while ( numberInOrder[4] == numberInOrder[0] ||
                    numberInOrder[4] == numberInOrder[1] ||
                    numberInOrder[4] == numberInOrder[2] ||
                    numberInOrder[4] == numberInOrder[3]){
                numberInOrder[4] = numberGenerator.nextInt(6)+ 1;
            }
        }
    }

    public int[] getNumber(){
        return numberInOrder;
    }
}

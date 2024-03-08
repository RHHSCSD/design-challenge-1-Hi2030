/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.Scanner;
import java.text.*;
/***************************************************
*  Program: Tech Fair Cost Calculator
*  Author: Haydn Y
*  Date: March 7, 2024
*  Description: Calculate total material cost and cost for each student for a science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
*Number of students doing each project
*PROCESSING:
*Calculate total number of students and decide if discount is applicable
*Calculate the material cost of each type of project and decide if discounts are applicable
*Add up the costs and divide by number of students
*OUTPUT:
*Total material cost
*Cost for each student
***************************************************/
  
/**************** TEST CASES ************************
*Test      Input      Desired Ouput
*1         1 1 1      195 65
*2         0 -1 -1    Please refrain from entering negative numbers
*3         50 50 50   9175 61.17
*4         -1 50 1    Please refrain from entering negative numbers
*5         -50 50 0   Please refrain from entering negative numbers
*6         0 1 0      65 65
*7         46 67 12   7395.5 59.16
*8         0 0 0      There are no students participating
***************************************************/
public class DesignProjectOne {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
       /*
   PROGRAM CostCalculator    
        READ arduinoNum
        READ raspberryNum
        READ vrNum
        totalNum = ardunioNum + raspberryNum + vrNum
        IF (arduinoNum < 0 || raspberryNum < 0 || vrNum < 0){
            PRINT "Please refrain from entering negative numbers"
            return
        }
        ELSE
            IF (totalNum > 100)
                fixedCost *= 0.95
            ELSE
                fixedCost = 50
            ENDIF
   
            IF (ardunioNum > 15)
                arduinoPrice--
            ELSE IF (Num > 0 && Num<=15)
                arduinoPrice = 10
            ELSE
                arduinoPrice -= 10
            ENDIF
   
            IF (raspberryNum > 20)
                raspberryPrice -= 3
            ELSE IF (Num > 0 && Num<15)
                raspberryPrice = 15
            ELSE
                raspberryPrice -= 15
            ENDIF
   
            totalPrice = (fixedCost * totalNum) + (arduinoNum * arduinoPrice) + (raspberryNum * raspberryPrice) + (vrNum * vrPrice)
            studentPrice = totalPrice/totalNum
            IF (totalPrice == 0)
               PRINT "No students participating"
            ELSE
                PRINT studentPrice
                PRINT totalPrice
            ENDIF
        ENDIF
   END
   */
  //CONSTANTS
        
  //VARIABLES
        double fixedCost;
        int arduinoPrice = 10;
        int raspberryPrice = 15;
        int vrPrice = 20;
  
        int arduinoNum;
        int raspberryNum;
        int vrNum;
        int totalNum;
        double studentPrice;
        double totalPrice;
  //CODE
        //Get input of number of students from the user
        Scanner input = new Scanner (System.in);
        System.out.print("Enter number of students for Arduino: ");
        arduinoNum = input.nextInt();
        System.out.print("Enter number of students for Raspberry PI: ");
        raspberryNum = input.nextInt();
        System.out.print("Enter number of students for VR: ");
        vrNum = input.nextInt();
        
        //Calculate total number of students participating
        totalNum = arduinoNum + raspberryNum + vrNum;
        
        //Decide if the user inputted any negative numbers
        if (arduinoNum < 0 || raspberryNum < 0 || vrNum < 0){
            System.out.println("Please refrain from entering negative numbers");
        }
        else{
            //Decide if there should be a discount based on total number of students
            if (totalNum > 100)
                fixedCost = 47.5;
            else
                fixedCost = 50;
            
           //Decide if there should be a discount for price of Arduino 
           if (arduinoNum > 15)
                arduinoPrice--;
            else if (arduinoNum > 0 && arduinoNum<=15)
                arduinoPrice = 10;
            else
                arduinoPrice = 0;
            
            //Decide if there should be a discount for price of RaspberryPI 
            if (raspberryNum > 20)
                raspberryPrice -= 3;
            else if (raspberryNum > 0 && raspberryNum<=20)
                raspberryPrice = 15;
            else
                raspberryPrice = 0;
            
            //Calculate final totals and output to the user to two decimal places
            DecimalFormat d = new DecimalFormat("#.##");
            totalPrice = (fixedCost * totalNum) + (arduinoNum * arduinoPrice) + (raspberryNum * raspberryPrice) + (vrNum * vrPrice);
            studentPrice = totalPrice/totalNum;
            
            //Check to see if user inputted 0s and there are no students participating
            if (totalPrice == 0){
                System.out.println("There are no students participating");
            }
            else {
               System.out.println("Total Price: $" + d.format(totalPrice)); 
               System.out.println("Student Price: $" + d.format(studentPrice));  
            }
        }
    }
}
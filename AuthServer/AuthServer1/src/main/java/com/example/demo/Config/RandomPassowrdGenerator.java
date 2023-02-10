package com.example.demo.Config;

public class RandomPassowrdGenerator {
    private int num_of_characters = 8;

    public RandomPassowrdGenerator() {
    }

    public RandomPassowrdGenerator(int num_of_characters) {
        this.num_of_characters = num_of_characters;
    }

    public int getNum_of_characters() {
        return num_of_characters;
    }

    public void setNum_of_characters(int num_of_characters) {
        this.num_of_characters = num_of_characters;
    }

    int total = 1;
    String[] randomPasswords = new String[total];

    public String passwordGen() {
        //Randomly generate passwords total number of times
        for (int i = 0; i < total; i++) {
            //Create a variable to store the random password
            String randomPassword = "";
            //Randomly generate a character for the password length number of times
            for (int j = 0; j < num_of_characters; j++) {
                //Add a random lowercase or UPPERCASE character to our randomPassword String
                randomPassword += randomCharacter();
            }
            //Add the random password to your array
            randomPasswords[i] = randomPassword;
        }

        //Print out the random passwords array

        return randomPasswords[0];
    }


    public static void printArray(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static char randomCharacter(){

        int rand = (int)(Math.random()*62);

        if(rand <= 9) {
            //Number (48-57 in ASCII)
            //To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
            int number = rand + 48;
            //This way, rand = 0 => number = 48 => '0'
            //Remember to cast our int value to a char!
            return (char)(number);
        } else if(rand <= 35) {
            //Uppercase letter (65-90 in ASCII)
            //To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
            int uppercase = rand + 55;
            //This way, rand = 10 => uppercase = 65 => 'A'
            //Remember to cast our int value to a char!
            return (char)(uppercase);
        } else {
            //Lowercase letter (97-122 in ASCII)
            //To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
            int lowercase = rand + 61;
            //This way, rand = 36 => lowercase = 97 => 'a'
            //Remember to cast our int value to a char!
            return (char)(lowercase);
        }
    }
}

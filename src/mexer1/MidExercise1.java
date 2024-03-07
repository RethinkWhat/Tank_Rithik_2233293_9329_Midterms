/**
 * Author: TANK, Rithik
 * Date: March 7, 2024
 * Activity: Midterms Exercise 1
 *
 */
package mexer1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MidExercise1 extends UnicastRemoteObject implements MidInterface1{

    /**
     * Constructor
     * @throws RemoteException
     */
    public MidExercise1() throws RemoteException {
    }

    /**
     * Method to handle counting characters, vowels, and consonants in a string, and sending order of occurrences to client
     * Algorithm:
     *      1. Instantiate variables
     *      2. Create a for loop to iterate the size of the passed in string
     *          2.1. Have a variable hold the current character
     *          2.2. Check if character is a letter
     *              2.2.1. Increment alphabet count
     *              2.2.2. Check if character is a vowel
     *                  2.2.2.1. Increment vowel count
     *              2.2.3. If it is not a vowel
     *                  2.2.3.1. Increment consonant count
     * @param s
     * @return
     * @throws RemoteException
     */
    @Override
    public String profileString(String s) throws RemoteException {

        // Will hold the total letter count of the passed in string
        int alphabetCount = 0;

        // Will hold the total vowel count of the passed in string
        int vowelCount = 0;

        // Will hold the total consonant count of the passed in string
        int consonantCount = 0;

        // A list of all the vowels
        String vowels = "aeiouAeiou";

        // Will hold the list of vowels by order of occurrence in the string
        String vowelsString = "";
        // Will hold the list of consonants by order of occurrence in the string
        String consonantsString = "";

        // Iterate through all the characters in the string
        for (int x =0; x <s.length(); x++) {
            char character = s.charAt(x);

            // Check if character is a letter
            if (Character.isLetter(character)) {

                // increment alphabet count
                alphabetCount += 1;

                // If the vowel is a  vowel increment vowel count
                if (vowels.contains(String.valueOf(character))) {
                    vowelCount += 1;
                    vowelsString += character;
                } else {
                    // Else increment consonant count
                    consonantCount += 1;
                    consonantsString += character;
                }
            }
        }

        return alphabetCount + " " + vowelsString + " " + vowelCount + " " + consonantsString + " " + consonantCount;
    }

    public static void main(String[] args) {
        final int port = 1099;
        try {
            MidExercise1 stub = new MidExercise1();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("midExercise1", stub);
            System.out.println("RMI BOUND");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

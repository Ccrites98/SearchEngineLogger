package com.pluralsight;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//Stuff is set
public class SearchEngineLogger {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//File and Buff
        try {
            FileWriter fileWriter = new FileWriter("logs.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            logAction(bufferedWriter,
                    dateFormat.format(new Date()), "launch");
//Create the UI
            while (true) {
                System.out.print("Search for a term (or type 'X' to quit): ");
                String input = keyboard.nextLine().trim();

                if ("x".equalsIgnoreCase(input)) {
                    logAction(bufferedWriter,
                            dateFormat.format(new Date()), "exit");
                    break;
                } else {
                    logAction(bufferedWriter,
                            dateFormat.format(new Date()), "search: " + input);
                }
            }
            bufferedWriter.close(); fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   }
    //Make the final method Jamie
    private static void logAction(BufferedWriter writer, String timestamp, String action)
            throws IOException {
        writer.write(timestamp + " " + action);
        writer.newLine();
    }
}

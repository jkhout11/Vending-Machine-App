package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TransactionLog
{

    private final String logFile = "LogFile.txt";
    private final File fileLog = new File(logFile);
    private final DecimalFormat cents = new DecimalFormat("#.00");
    public void writeLog(String product, Double price, Double remBalance)
    {

        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy - MM - dd, HH:mm:ss");
        String timeOfPurchase = dateTime.format(formatDate);

        try (PrintWriter logTransactions = new PrintWriter(new FileWriter(logFile, true))) {
            logTransactions.println(timeOfPurchase + " - " + product + ", $" + cents.format(price) + ", $" + remBalance);
        } catch (IOException ex) {
            System.out.println("I wasn't programmed correctly" + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
    public void writeEndTrans(int qtr, int dimebag, int nick, double change)
    {
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy - MM - dd, HH:mm:ss");
        String timeOfPurchase = dateTime.format(formatDate);

        try (PrintWriter logTransactions = new PrintWriter(new FileWriter(logFile, true))) {
            logTransactions.println(timeOfPurchase + " - $" + cents.format(change) + " was dispensed - " + qtr + " quarters " + dimebag + " dimes " + nick + " nickles - End of transaction ****");
        } catch (IOException ex) {
            System.out.println("I wasn't programmed correctly" + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}

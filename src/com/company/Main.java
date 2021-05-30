package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.zip.CRC32;

public class Main {

    public static void main(String[] args) {
        long password_hash = 0x89854990L;
        CRC32 c = new CRC32();
        File file = new File("message (8).txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while(scan.hasNext()){
                String s = scan.nextLine().replace("\n", "");
                boolean Flagok = true;
                for(int i = 0; i < 10000; i++){
                    c.reset();
                    String t = s + String.valueOf(i);
                    c.update(t.getBytes(StandardCharsets.UTF_8));
                    long current = c.getValue();
                    System.out.println(t);
                    System.out.println(current);
                    if(current == password_hash){
                        Flagok = false;
                        System.out.println("Your password is: " + t);
                        break;
                    }
                }
                if(!Flagok){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

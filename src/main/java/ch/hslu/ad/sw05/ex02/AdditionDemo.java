package ch.hslu.ad.sw05.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionDemo {

    private static Logger LOG = LogManager.getLogger(AdditionDemo.class);

    public static void main(String[] args) {
        int[] checksum1 = new int[10];
        checksum1[0] = 1;
        checksum1[1] = 2;
        checksum1[2] = 3;
        checksum1[3] = 6;
        checksum1[4] = 7;
        checksum1[5] = 8;
        checksum1[6] = 9;
        checksum1[7] = 3;
        checksum1[8] = 2;
        checksum1[9] = 4;

        int[] checksum2 = convertIntToIntArray(999999999);

        AdditionTask addT1 = new AdditionTask(checksum1);
        AdditionTask addT2 = new AdditionTask(checksum1);
        AdditionTask addT3 = new AdditionTask(checksum1);
        AdditionTask addT4 = new AdditionTask(checksum1);
        AdditionTask addT5 = new AdditionTask(checksum1);
        AdditionTask addT6 = new AdditionTask(checksum2);

        Thread threadT1 = new Thread(addT1);
        Thread threadT2 = new Thread(addT2);
        Thread threadT3 = new Thread(addT3);
        Thread threadT4 = new Thread(addT4);
        Thread threadT5 = new Thread(addT5);
        Thread threadT6 = new Thread(addT6);

        threadT1.start();
        threadT2.start();
        threadT3.start();
        threadT4.start();
        threadT5.start();
        threadT6.start();


    }

    private static int[] convertIntToIntArray(Integer intNumber) {
        String temp = Integer.toString(intNumber);
        int[] converted = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            converted[i] = temp.charAt(i) - '0';
        }
        return converted;
    }
}

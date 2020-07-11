package util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> dataProviderFirst() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/negativeLoginIncorrectTest.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }



    @DataProvider
    public static Iterator<Object[]> dataProviderSecond() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"login@mail.ru", "psw1"});
        data.add(new Object[]{"login2@mail.ru", "psw2"});

        return data.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataProviderThird() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 2; ++i) {
            data.add(new Object[]{this.generateRandomName(),this.generateRandomPassword()});
        }

        return data.iterator();
    }


    private Object generateRandomPassword() {

        return "pass" + (new Random()).nextInt();
    }

    private Object generateRandomName() {

        return "demo" + (new Random()).nextInt()+"@gmail.com";
    }
}

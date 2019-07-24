import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class RegistrationTests extends BaseUI {

    @DataProvider(name = "Registration")
    public static Object[][] testRegistration2() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s-> {

            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});

        });

        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "Registration")
    public void testRegistration(String email, String password, String day, String month, String year,
                                 String phone, String city, String location) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5), phone,
                month, day, year, city, location);



    }


}

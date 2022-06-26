package commons;

import com.github.javafaker.Faker;

public class DataUtil {
    private Faker faker;

    public static DataUtil getData() {
        return new DataUtil();
    }

    public DataUtil() {
        faker = new Faker();

    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getState() {
        return faker.address().stateAbbr();
    }

    public String getPINNumber() {
        return faker.number().digits(6);
    }

    public String getNumber() {
        return faker.number().digits(9);
    }

}

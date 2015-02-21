import com.Dio.lesson6.ArrayHelper;
import com.Dio.lesson6.Person;
import com.Dio.lesson6.ServiceDelegate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestCollections {
    private final ServiceDelegate serviseDelegate = new ServiceDelegate(new ArrayHelper());

    final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
            new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
            new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
            new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

    final Person [] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
            new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
            new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
            new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

    ArrayList <Person> person_list1 = new ArrayList<Person>(Arrays.asList(p1));
    ArrayList <Person> person_list2 = new ArrayList<Person>(Arrays.asList(p2));
    ArrayList <Person> person_list_null = new ArrayList<Person>();
    ArrayList <Person> person_list_empty = new ArrayList<Person>(10);

    @Test
    public void testMerge_NormalValue() throws Exception {
        Person [] result = {new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build()};

        ArrayList <Person> expectedResult = new ArrayList<Person>(Arrays.asList(result));
        ArrayList <Person> testMerge = serviseDelegate.merge(person_list1, person_list2);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }

    @Test
    public void testMerge_FirstArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.merge(person_list_null, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testMerge_SecoundArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.merge(person_list1, person_list_null);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);

    }
    @Test
    public void testMerge_FirstArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.merge(person_list_empty, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testMerge_SecoundArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.merge(person_list1, person_list_empty);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }


    @Test
    public void testInnerUnion_NormalValue() throws Exception {
        Person [] result = {new Person.Builder().setAge(25).setMail("ftt@yahoo.com")
                .setName("Kar").setNumber(12577).build(),};

        ArrayList <Person> expectedResult = new ArrayList<Person>(Arrays.asList(result));
        ArrayList <Person> testMerge = serviseDelegate.innerUnion(person_list1, person_list2);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }

    @Test
    public void testInnerUnion_FirstArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.innerUnion(person_list_null, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testInnerUnion_SecoundArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.innerUnion(person_list1, person_list_null);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);

    }
    @Test
    public void testInnerUnion_FirstArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.innerUnion(person_list_empty, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testInnerUnion_SecoundArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = new ArrayList<Person>();
        ArrayList <Person> testMerge = serviseDelegate.innerUnion(person_list1, person_list_empty);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }

    @Test
    public void testOuterUnion_NormalValue() throws Exception {
        Person [] result = {new Person.Builder().setAge(25).setMail("ftt@yahoo.com")
                .setName("Kar").setNumber(12577).build(),};

        ArrayList <Person> expectedResult = new ArrayList<Person>(Arrays.asList(result));
        ArrayList <Person> testMerge = serviseDelegate.outerUnion(person_list1, person_list2);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }

    @Test
    public void testOuterUnion_FirstArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.outerUnion(person_list_null, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testOuterUnion_SecoundArrayNull() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.outerUnion(person_list1, person_list_null);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);

    }
    @Test
    public void testOuterUnion_FirstArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.outerUnion(person_list_empty, person_list1);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
    @Test
    public void testOuterUnion_SecoundArrayEmpty() throws Exception {
        ArrayList<Person> expectedResult = (ArrayList<Person>) person_list1.clone();
        ArrayList <Person> testMerge = serviseDelegate.outerUnion(person_list1, person_list_empty);

        Collections.sort(expectedResult);
        Collections.sort(testMerge);

        Assert.assertEquals(expectedResult, testMerge);
    }
}
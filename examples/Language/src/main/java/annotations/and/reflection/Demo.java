package annotations.and.reflection;

public class Demo {
    public boolean test0() {
        return false;
    }

    public <@Foobar(123) T> void test1(T input) {
    }

    public <@Foobar(value = 456) T> void test2(T input) {
    }

    public <@Foobar T> void test3(T input) {
    }

    //public <@Foobar(789, other=1.23) T> void test4(T input) {}        //Will not compile

    public <@Foobar(value = 789, other = 1.23) T> void test4(T input) {
    }

    public <T> float test99() {
        return 0;
    }
}

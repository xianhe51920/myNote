public class test {
    int age;
    int name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        test test = (test) o;
        return age == test.age && name == test.name;
    }
}

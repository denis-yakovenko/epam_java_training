import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Trainee {
    private String name;
    private int age;
    private boolean sign;

    public Trainee(String name, int age, boolean sign) {
        this.name = name;
        this.age = age;
        this.sign = sign;
    }

    public void setName(String name) throws Exception {
        if (name == null) throw new Exception();
        this.name = name;
    }

    public void setAge(int age) throws Exception {
        if (age < 0) throw new Exception();
        this.age = age;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sign=" + sign +
                '}';
    }
}

class Group {
    private String name;
    private List<Trainee> traineeList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void addTrainee(Trainee trainee) {
        traineeList.add(trainee);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", traineeList=" + Arrays.toString(traineeList.toArray()) +
                '}';
    }
}

class test123 {
    public static void main(String[] args) {
        Group group = new Group();
        group.addTrainee(new Trainee("John", 20, true));
    }

}
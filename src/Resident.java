import java.util.ArrayList;
import java.util.List;

public class Resident implements Comparable<Resident> {

    public String name;
    private List<Resident> residentList = new ArrayList<>();

    public Resident(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public int compareTo(Resident o) {
        return this.getName().compareTo(o.getName());
    }
}

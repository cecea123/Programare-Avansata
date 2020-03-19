import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Problem problem = new Problem();
        List<Resident> r = new ArrayList<>(); // Crearea listei rezidentilor
        r = problem.residentList(r); // Initializarea listeri rezidentilor
        TreeSet<Hospital> h = new TreeSet<>(); // Crearea listei spitalelor
        h = problem.hospitalList(h); // Initializarea listei spitalelor

        Map<Resident, List<Hospital>> residentMap = problem.residentsPrefMap(r, h); // Se creaza si instantiaza mapa pentru residenti si preferintele lor
        Map<Hospital, List<Resident>> hospitalMap = problem.hospitalPrefMap(r, h);// Se creaza si instantiaza mapa pentru spitale si preferintele lor
        System.out.println("Preferintele rezidentilor: ");
        System.out.println(residentMap); // Afisarea rezidentilor cu preferinte
        System.out.println("Preferintele spitalelor: ");
        System.out.println(hospitalMap); // Afisarea spitalelor cu preferinte


        problem.Filtrare(r,h,residentMap,hospitalMap); // metoda ce afiseaza filtrarile

    }
}

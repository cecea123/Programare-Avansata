import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    public List<Resident> residentList(List<Resident> res) {
        Resident[] arr = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        res.addAll(Arrays.asList(arr));
        Collections.sort(res, (Comparator.comparing(Resident::getName)));
        return res;
    }
    public TreeSet<Hospital> hospitalList(TreeSet<Hospital> h) {
        Hospital[] arr = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i, i + 1)).toArray(Hospital[]::new);
        h.addAll(Arrays.asList(arr));
        return h;
    }

    /**
     * Algoritm ce instanteaza mapa rezidentilor cu preferintele din problema
     */
    public Map<Resident, List<Hospital>> residentsPrefMap(List<Resident> res, TreeSet<Hospital> h) {
        Map<Resident, List<Hospital>> hospitalMap = new TreeMap<>();
        List<Hospital> hospitalList = new ArrayList<>(h);
        hospitalMap.put(res.get(0), Arrays.asList(hospitalList.get(0), hospitalList.get(1), hospitalList.get(2)));
        hospitalMap.put(res.get(1), Arrays.asList(hospitalList.get(0), hospitalList.get(1), hospitalList.get(2)));
        hospitalMap.put(res.get(2), Arrays.asList(hospitalList.get(0), hospitalList.get(1)));
        hospitalMap.put(res.get(3), Arrays.asList(hospitalList.get(0), hospitalList.get(2)));
        return hospitalMap;
    }

    /**
     * Algoritm ce instanteaza mapa spitalelor cu preferintele din problema
     */
    public Map<Hospital, List<Resident>> hospitalPrefMap(List<Resident> res, TreeSet<Hospital> h) {

        Map<Hospital, List<Resident>> residentsMap = new TreeMap<>();
        List<Hospital> hospitalList = new ArrayList<>(h);
        List<Resident> prefList = new ArrayList<>();
        prefList.add(res.get(3));
        prefList.add(res.get(0));
        prefList.add(res.get(1));
        prefList.add(res.get(2));
        residentsMap.put(hospitalList.get(0), prefList);
        List<Resident> prefList1 = new ArrayList<>();
        prefList1.add(res.get(0));
        prefList1.add((res.get(2)));
        prefList1.add(res.get(1));
        residentsMap.put(hospitalList.get(1), prefList1);
        List<Resident> prefList2 = new ArrayList<>();
        prefList2.add(res.get(0));
        prefList2.add(res.get(1));
        prefList2.add(res.get(3));
        residentsMap.put(hospitalList.get(2), prefList2);
        return residentsMap;
    }


    public void Filtrare(List<Resident> r, TreeSet<Hospital> h, Map<Resident, List<Hospital>> residentMap, Map<Hospital, List<Resident>> hospitalMap) {
        List<Hospital> target = Arrays.asList(h.first(), h.last()); // first este spitalul 0, last spitalul 2
        List<Resident> result = r.stream().filter(k -> residentMap.get(k).containsAll(target)).collect(Collectors.toList());
        System.out.println(result);
        for (Map.Entry<Hospital, List<Resident>> i : hospitalMap.entrySet()) // Se verifica fiecare spital daca  are pe primul loc residentul 0 / se afiseaza doar spitalele acceptate
            if (i.getValue().toArray()[0] == r.get(0))
                System.out.print(i.getKey() + " ");
    }

}

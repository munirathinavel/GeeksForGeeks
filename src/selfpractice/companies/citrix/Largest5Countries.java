package selfpractice.companies.citrix;

import java.util.*;

/**
 * Created by sandeepkulkarni on 9/17/16.
 */
public class Largest5Countries {

    public static void main(String[] args) {
        //int[] nums = {4,4,4,4,1,1,4,1,2,2,2,2,3,3,6,5,5,4,5,6,5,4,3,3,2,2,3,4,5,6};
        int k = 5;
        Largest5Countries obj = new Largest5Countries();

        List<String> list = new ArrayList<>();
        list.add("Alameda,City,Alameda,73812");
        list.add("Anaheim,City,Orange,336265");
        list.add("Bakersfield,City,Kern,347483");
        list.add("Berkeley,City,Alameda,112580");
        list.add("Beverly Hills,City,Los Angeles,34109");
        list.add("Coachella,City,Riverside,40704");
        list.add("Costa Mesa,City,Orange,109960");
        list.add("Gilroy,City,Santa Clara,48821");
        list.add("Glendale,City,Los Angeles,191719");
        list.add("La Quinta,City,Riverside,37467");
        list.add("Long Beach,City,Los Angeles,462257");
        list.add("San Jose,City,Santa Clara,945942");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : list){
            String[] strs = s.split(",");
            if(map.containsKey(strs[2])){
                int population = map.get(strs[2]);
                map.put(strs[2], population + Integer.parseInt(strs[3]));
            }else{
                map.put(strs[2], Integer.parseInt(strs[3]));
            }
        }

        System.out.println(map);

        List<String> result = obj.topKCounties(map, k);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> topKCounties(HashMap<String, Integer> mapCounties, int k) {
        List<String> list = new ArrayList<>();

        //Using MinHeap
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new MinHeapComparator());   //min heap comparator class

        int i = 0;
        for(Map.Entry<String, Integer> entry : mapCounties.entrySet()){
            if(i < k){
                pq.offer(entry);    //add into heap till less than k
            } else {                //after that check new entries with lowest freq entry i.e root
                if(entry.getValue() > pq.peek().getValue()){    //if more freq than root, replace root with new entry
                    pq.poll();
                    pq.offer(entry);
                }
            }
            i++;
        }

        //Heap just has top k entries. So move keys from min heap to list
        while(!pq.isEmpty()){
            list.add(pq.poll().getKey());
        }

        Collections.reverse(list);
        return list;
    }

    class MinHeapComparator implements Comparator<Map.Entry<String, Integer>>{
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            //Ascending order: so min heap
            return o1.getValue() - o2.getValue();
        }
    }
}

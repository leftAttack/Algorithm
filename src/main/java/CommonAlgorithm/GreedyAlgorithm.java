package CommonAlgorithm;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author Yue_
 * @create 2021-02-15-17:33
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        // 创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        // 将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        greedyAlgorithm.greedy(broadcasts);
    }

    private ArrayList<String> all;
    private ArrayList<String> selectorList;

    public GreedyAlgorithm(){
        all = new ArrayList<>();
        selectorList = new ArrayList<>();
    }

    public void greedy(HashMap hashMap){
        ArrayList<String> all = getAll(hashMap);
        HashSet<String> tempSet = new HashSet<>();
        while (all.size() > 0){
            String maxKey = null;
            //遍历所有的电视塔
            for(Object key:hashMap.keySet()){
                tempSet.clear();
                //获得电视塔的所有地点
                HashSet<String> areas = (HashSet<String>) hashMap.get(key);
                tempSet.addAll(areas);
                //求出tempSet和All的交集并赋值给tempSet
                tempSet.retainAll(all);
                HashSet<String> maxSet = (HashSet<String>) hashMap.get(maxKey);
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxSet.size())){
                    maxKey = (String)key;
                }
            }
            if(maxKey != null){
                selectorList.add(maxKey);
                all.removeAll((Collection<?>) hashMap.get(maxKey));
            }
        }
        System.out.println(selectorList);
    }

    public ArrayList<String> getAll(HashMap hashMap){
        boolean flag = true;
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry item = (Map.Entry) iterator.next();
            HashSet<String> value = (HashSet<String>) item.getValue();
            for(String str :value){
                for(String str1:all){
                    if(str1.equals(str)){
                        flag = false;
                    }
                }
                if(flag){
                    all.add(str);
                }
                flag = true;
            }
        }
        return all;
    }
}

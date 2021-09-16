import java.util.*;

public class RandomKeySelection {
    private static SortedMap<Integer, Partition> sortedMap = new TreeMap<>();
    public static void main(String ...args){
        Data key1 = new Data("key1", 10);
        Data key2 = new Data("key2", 5);
        Data key3 = new Data("key3", 25);
        Data key4 = new Data("key4", 25);
        Data key5 = new Data("key4", 30);
        Data key6 = new Data("key6", 15);

        List<Data> dataList = new ArrayList<>();
        dataList.add(key1);
        dataList.add(key2);
        dataList.add(key3);
        dataList.add(key4);
        dataList.add(key5);
        dataList.add(key6);

        //Let's create 10 partitions
        Partition p1 = new Partition(0, 10,  1);
        Partition p2 = new Partition(11, 21, 2);
        Partition p3 = new Partition(22, 32, 3);
        Partition p4 = new Partition(33, 43, 4);

        Partition p5 = new Partition(44, 54, 5);
        Partition p6 = new Partition(55, 65, 6);
        Partition p7 = new Partition(66, 76, 7);
        Partition p8 = new Partition(77, 87, 8);
        Partition p9 = new Partition(88, 100,9);

        sortedMap.put(1, p1);
        sortedMap.put(2, p2);
        sortedMap.put(3, p3);
        sortedMap.put(4, p4);
        sortedMap.put(5, p5);
        sortedMap.put(6, p6);
        sortedMap.put(7, p7);
        sortedMap.put(8, p8);
        sortedMap.put(9, p9);

        // Add data to partition for the data.

        dataList.stream().forEach(d ->{
            Partition p = getPartition(d);
            p.addData(d);
        });
    }

    public static Partition getPartition(Data data){
        if(data.probability <= 10){
            return sortedMap.get(1);
        }else if(data.probability > 10 && data.probability <= 21){
            return sortedMap.get(2);
        }else if(data.probability > 21 && data.probability <= 32){
            return sortedMap.get(3);
        }else if(data.probability > 32 && data.probability <= 43){
            return sortedMap.get(4);
        }else if(data.probability > 43 && data.probability <= 54){
            return sortedMap.get(5);
        }else if(data.probability > 54 && data.probability <= 65){
            return sortedMap.get(6);
        }else if(data.probability > 65 && data.probability <= 76){
            return sortedMap.get(7);
        }else if(data.probability > 76 && data.probability <= 87){
            return sortedMap.get(8);
        }else if(data.probability > 87 && data.probability <= 100){
            return sortedMap.get(8);
        }
        return sortedMap.get(1);
    }

    public static Partition getPartitionForRandomNumber(long randomKey){
        if(randomKey <= 10){
            return sortedMap.get(1);
        }else if(randomKey > 10 && randomKey <= 21){
            return sortedMap.get(2);
        }else if(randomKey > 21 && randomKey <= 32){
            return sortedMap.get(3);
        }else if(randomKey > 32 && randomKey <= 43){
            return sortedMap.get(4);
        }else if(randomKey > 43 && randomKey <= 54){
            return sortedMap.get(5);
        }else if(randomKey > 54 && randomKey <= 65){
            return sortedMap.get(6);
        }else if(randomKey > 65 && randomKey <= 76){
            return sortedMap.get(7);
        }else if(randomKey > 76 && randomKey <= 87){
            return sortedMap.get(8);
        }else if(randomKey > 87 && randomKey <= 100){
            return sortedMap.get(8);
        }
        return sortedMap.get(1);
    }

    public static List<Data> randomSelectionOfKeys(List<Data> keysSet){
        Random random = new Random();
        long randomNumber  = random.nextLong()%100;
        Partition p = getPartitionForRandomNumber(randomNumber);
        return p.data;
    }
}

class Partition {
    int minKey;
    int maxKey;
    int partitionNo;
    List<Data> data;

    public Partition(int minKey, int maxKey, int partitionNo){
        this.minKey = minKey;
        this.maxKey = maxKey;
        this.partitionNo = partitionNo;
        this.data = new ArrayList<>();
    }

    public void addData(Data data){
        this.data.add(data);
    }
}
class Data{
    String key;
    Integer probability;
    public Data(String key, Integer probability){
        this.key = key;
        this.probability = probability;
    }

}
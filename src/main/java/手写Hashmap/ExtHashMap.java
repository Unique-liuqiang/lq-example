package 手写Hashmap;

public class ExtHashMap<K, V> implements ExtMap<K, V> {

    private Node<K, V>[] table;

    private int size;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    @Override
    public V put(K key, V value) {
        if (table == null || table.length == 0) {
            table = new Node[ExtHashMap.DEFAULT_INITIAL_CAPACITY];
        }
        if(size >= DEFAULT_LOAD_FACTOR*table.length){
            resize();
        }
        int index = getIndex(key, table.length);
        Node<K, V> node = table[index];
        //初始化头结点
        if (node == null) {
            node = new Node<K, V>(key, value, null);
            table[index] = node;
            size++;
            return null;
        } else {
            Node<K, V> node1 = node;
            while (node1 != null) {
                //链表中存在相同的节点,覆盖其值
                if (node1.getKey().equals(key) || node1.getKey() == key) {
                    node1.setValue(value);
                    return null;
                }
                node1 = node1.next;
            }
            //链表中增加结点
            Node<K, V> node2 = new Node<>(key, value, node);
            table[index] = node2;
            size++;
            return null;
        }
    }

    /**
     * 扩容
     */
    private void resize() {
        Node[] newTable = new Node[ table.length << 1];

        for(int i=0;i<table.length;i++){
            Node<K, V> node = table[i];
            if(node == null){
                continue;
            }
            int newIndex = getIndex(node.getKey(), newTable.length);
            newTable[newIndex] = node;
            Node<K, V> nextNode = node.next;
            node.next=null;
            while (nextNode!=null){
                Node<K, V> oldNext = nextNode.next;
                int index = getIndex(nextNode.getKey(),newTable.length);
                nextNode.next = newTable[index];
                newTable[index] = nextNode;
                nextNode = oldNext;
            }
            table[i] = null;
        }
        table = newTable;
        newTable = null;
    }

    void print() {
        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            System.out.print("下标位置[" + i + "]");
            while (node != null) {
                System.out.print("[ key:" + node.getKey() + ",value:" + node.getValue() + "]");
                node = node.next;
            }
            System.out.println();
        }
    }

    /**
     * 求出key的索引位置
     *
     * @param key
     * @param length
     * @return
     */
    private  int getIndex(K key, int length) {
        int i = key.hashCode();
        return i % length;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key, table.length);
        Node<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    class Node<K, V> implements Entry<K, V> {

        private K key;

        private V value;

        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        /**
         * //返回旧值
         */
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

}

class TestExtHashMap {
    public static void main(String[] args) {
        /* int[] a=new int[7];
         int i = a[5];
         System.out.println(i);*/
     /*   ExtHashMap extHashMap = new ExtHashMap<String, String>();
        extHashMap.put(1, "1");
        extHashMap.put(17, "2");
        extHashMap.put(1, "2");
        extHashMap.put(33, "3");
        extHashMap.print();
        System.out.println(extHashMap.size());
        System.out.println(extHashMap.get(34));*/
        ExtHashMap extHashMap = new ExtHashMap<String, String>();
        extHashMap.put("1号", "1号");// 0
        extHashMap.put("2号", "1号");// 1
        extHashMap.put("3号", "1号");// 2
        extHashMap.put("4号", "1号");// 3
        extHashMap.put("6号", "1号");// 4
        extHashMap.put("7号", "1号");
        extHashMap.put("14号", "1号");
        extHashMap.put("22号", "1号");
        extHashMap.put("26号", "1号");
        extHashMap.put("27号", "1号");
        extHashMap.put("28号", "1号");
        extHashMap.put("66号", "66");
        extHashMap.print();
        System.out.println("扩容前数据....");
        extHashMap.put("30号", "1号");
        System.out.println(extHashMap.size());
        System.out.println("扩容后数据....");
    /*    extHashMap.put("31号", "1号");
        extHashMap.put("66号", "123466666");*/
        extHashMap.print();
    }
}

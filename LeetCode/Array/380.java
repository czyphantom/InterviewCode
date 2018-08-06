/**
* 题目大意：设计一个可以平均复杂度O(1)，支持获取一个随即数的不重复集合
* 难度：Medium
* 思路：我也不知道为啥过了...
* 实际上思路把要删除的元素与最后的元素交换位置, 而删除最后一个元素就可以在O(1)完成. 这样的话还需要一个hash表
* 来记录元素在数组的位置, 这样才可以来O(1)取到这个元素, 并移动到尾部. 还需要注意的是在删除一个元素的时候与另
* 外一个元素交换了位置, 所以在hash表中还需要将另外一个元素的位置更新
*/

class RandomizedSet {
    private HashMap<Integer,Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if(map.put(val,1) == null) {
            result = true;
        }
        return result;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean result = false;
        if(map.remove(val) != null) {
            result = true;
        }
        return result;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        return list.get(random.nextInt(list.size())%list.size());
    }
}

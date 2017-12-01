/**
 * Name: Insert Delete GetRandom O(1) 
 * Number: 380
 * Tag: HashMap
 * Main Points:
   use hashmap to store a val and its location
   insert: search in hashmap whether it exists -> O(1)
           insert it at the end of list -> O(1)
   remove: search in hashmap to get its location -> O(1)
           if not last position, swap with last -> O(1)
           remove the last position of list -> O(1)
           update new val in original location -> O(1)
 * Time Complexity: all operations O(1)
 * Space Complexity: amertized O(1)
**/
class RandomizedSet {
    HashMap<Integer, Integer> locs;
    ArrayList<Integer> nums;
    Random rnd;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        locs = new HashMap<>();
        nums = new ArrayList<>();
        rnd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1) {
            int lastNum = nums.get(nums.size() - 1);
            nums.set(loc, lastNum);
            locs.put(lastNum, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rnd.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
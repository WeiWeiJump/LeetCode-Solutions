/**
 * Main Points: In fact, there has to be one operation's time complexity is O(n) and the other is O(1),
   no matter add or find. So clearly there's trade off when solve this problem, prefer quick find or quick add.
   If consider more find and less add or we only care time complexity in finding.For example, add operation can be pre-done.
 * Time Complexity: add O(n) + find O(1) / add O(1) + find O(n)
**/
/******************Quick Find********************/
class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;
    public TwoSum() {
        sum = new HashSet<>();
        num = new HashSet<>();
    }
    
    public void add(int number) {
        if (num.contains(number)) {
            sum.add(2 * number);
        } else {
            Iterator<Integer> iter = num.iterator();
            while (iter.hasNext()) {
                sum.add(iter.next() + number);
            }
        }
        num.add(number);
    }
    
    public boolean find(int value) {
        return sum.contains(value);
    }
}

/******************Quick Add********************/
class TwoSum {
    Map<Integer, Integer> numMap;
    /** Initialize your data structure here. */
    public TwoSum() {
        numMap = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (numMap.containsKey(number)) {
            numMap.put(number, 2);
        } else {
            numMap.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> iter = numMap.keySet().iterator();
        while (iter.hasNext()) {
            int num1 = iter.next();
            int num2 = value - num1;
            if (numMap.containsKey(num2)) {
                if (num2 != num1 || numMap.get(num2) == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
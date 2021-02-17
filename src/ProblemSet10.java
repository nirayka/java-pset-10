import java.util.ArrayList;
public class ProblemSet10 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 7};
        System.out.println(new ProblemSet10().maxMirror(arr));
    }

    public String[] fizzBuzz(int start, int end) {
        if (start > end) {
            return null;
        }
        String[] arr = new String[end - start];
        int index = 0;

        for (int i = start; i < end; i++) {
            String appendString = "";
            if (i % 3 == 0) {
                appendString += "Fizz";
            }
            if (i % 5 == 0) {
                appendString += "Buzz";
            }
            if (appendString.length() == 0) {
                appendString = Integer.toString(i);
            }
            arr[index] = appendString;
            index++;
        }
        return arr;
    }

    public int maxSpan(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        ArrayList<String> temp = new ArrayList<>();
        for (int i : numbers) {
            temp.add(Integer.toString(i));
        }
        int maxSpan = 0;
        while (temp.size() > 0) {
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(0).equals(temp.get(i))) {
                    if (i + 1 > maxSpan) {
                        maxSpan = i + 1;
                    }
                }
            }
            boolean tempBool = true;
            String removingVal = temp.get(0);
            while (tempBool) {
                tempBool = temp.remove(removingVal);
            }
        }
        return maxSpan;
    }

    public int[] fix34(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int threeCount = 0;
        ArrayList<Integer> threeIndexes = new ArrayList<>();
        int fourCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3) {
                if (numbers[i + 1] == 4) {
                    return null;
                }
                threeCount++;
                threeIndexes.add(i);
            }
            if (numbers[i] == 4) {
                if (threeCount == 0) {
                    return null;
                }
                fourCount++;
            }
        }
        if (threeCount != fourCount) {
            return null;
        }
        int[] arr = new int[numbers.length];
        for (int j : threeIndexes) {
            arr[j] = 3;
            arr[j + 1] = 4;
        }
        for (int k : numbers) {
            for (int l = 0; l < arr.length; l++) {
                if (arr[l] == 0 && k != 3 && k != 4) {
                    arr[l] = k;
                }
            }
        }
        return arr;
    }

    public int[] fix45(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int fourCount = 0;
        ArrayList<Integer> fourIndexes = new ArrayList<>();
        int fiveCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 4) {
                if (numbers[i + 1] == 5) {
                    return null;
                }
                fourCount++;
                fourIndexes.add(i);
            }
            if (numbers[i] == 5) {
                fiveCount++;
            }
        }
        if (fourCount != fiveCount) {
            return null;
        }
        int[] arr = new int[numbers.length];
        for (int j : fourIndexes) {
            arr[j] = 4;
            arr[j + 1] = 5;
        }
        for (int k : numbers) {
            for (int l = 0; l < arr.length; l++) {
                if (arr[l] == 0 && k != 4 && k != 5) {
                    arr[l] = k;
                }
            }
        }
        return arr;
    }

    public boolean canBalance(int[] numbers) {
        int sum = 0;
        int halfSum = 0;
        for (int i : numbers) {
            sum += i;
        }
        for (int j : numbers) {
            if (halfSum <= sum / 2) {
                halfSum += j;
            } else {
                return halfSum == sum / 2;
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        for (int i : inner) {
            boolean exists = false;
            for (int k : outer) {
                if (i == k) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                return false;
            }
        }
        return true;
    }

    public int[] squareUp(int n) {
        if (n < 0) {
            return null;
        }
        ArrayList<Integer> totalarr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] smallarr = new int[n];
            int numadditions = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (numadditions < i + 1) {
                    smallarr[j] = numadditions + 1;
                    numadditions++;
                }
            }
            for (int x : smallarr) {
                totalarr.add(x);
            }
        }
        return totalarr.stream().mapToInt(i -> i).toArray();
    }

    public int[] seriesUp(int n) {
        if (n < 0) {
            return null;
        }
        ArrayList<Integer> totalarr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                totalarr.add(j);
            }
        }
        return totalarr.stream().mapToInt(i -> i).toArray();
    }

    public int maxMirror(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        for (int i = numbers.length; i > 0; i--) {
            ArrayList<int[]> arrayList = new ArrayList<>();
            for (int j = 0; j < numbers.length; j++) {
                try {
                    int[] sublist = makeSublist(numbers, j, j + i);
                    arrayList.add(sublist);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            while (arrayList.size() > 0) {
                for (int[] ints : arrayList) {
                    if (compareReverseLists(arrayList.get(0), ints)) {
                        return i;
                    }
                }
                arrayList.remove(0);
            }
        }
        return 0;
    }

    public int countClumps(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        boolean inClump = false;
        int numClumps = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                if (!inClump) {
                    numClumps++;
                    inClump = true;
                }
            } else {
                inClump = false;
            }
        }
        return numClumps;
    }

    private int[] makeSublist(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = start; i < end; i++) {
            temp.add(arr[i]);
        }
        return temp.stream().mapToInt(i -> i).toArray();
    }

    private boolean compareReverseLists(int[] list1, int[] list2) {
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[list2.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
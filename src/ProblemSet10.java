import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProblemSet10 {

    public static void main(String[] args) {

    }

    public String[] fizzBuzz(int start, int end) {
        if (start > end) {
            return null;
        } else {
            String[] newArray = new String[end - start];
            int index = 0;

            for (int i = start; i < end; i++) {
                String stringToBeAdded = "";
                if (i % 3 == 0) {
                    stringToBeAdded += "Fizz";
                }
                if (i % 5 == 0) {
                    stringToBeAdded += "Buzz";
                }
                if (stringToBeAdded.length() == 0) {
                    stringToBeAdded = Integer.toString(i);
                }
                newArray[index] = stringToBeAdded;
                index++;
            }

            return newArray;
        }
    }

    public int maxSpan(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        if (numbers.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> firstAppearance = new HashMap<>();
        int span = 1;
        int maxSpan = 1;

        for (int i = 0; i < numbers.length; i++) {
            Integer s = firstAppearance.get(numbers[i]);
            if (s == null) {
                firstAppearance.put(numbers[i], i);
            } else {
                span = i - s + 1;
                if (span > maxSpan) {
                    maxSpan = span;
                }
            }
        }
        return maxSpan;
    }

    public int[] fix34(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        int threeValues = 0;
        int fourValues = 0;
        int firstThreeIndex = -1;
        int firstFourIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3) {
                if (firstThreeIndex == -1) {
                    firstThreeIndex = i;
                } if (i != numbers.length-1 && numbers[i+1] == 3) {
                    return null;
                }
                threeValues++;
            } else if (numbers[i] == 4) {
                if (firstFourIndex == -1) {
                    firstFourIndex = i;
                }
                fourValues++;
            }
        }

        if (threeValues != fourValues) {
            return null;
        }

        for (int k = firstThreeIndex; k < numbers.length; k++) {

            if (numbers[k] == 4) {
                for (int j = 0; j < numbers.length; j++) {
                    if ((numbers[j] == 3)) {
                        int t = numbers[j+1];
                        numbers[j+1] = numbers[k];
                        numbers[k] = t;
                    }
                }
            }

        }
        return numbers;
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
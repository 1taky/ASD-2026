class Sorter {
    public static void selectionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].region.compareToIgnoreCase(arr[minIndex].region) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static int[] indexSort(Student[] arr) {
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }

        for (int i = 1; i < indices.length; i++) {
            int keyIndex = indices[i];
            int j = i - 1;

            while (j >= 0) {
                int currentStudentIndex = indices[j];
                int regionCompare = arr[currentStudentIndex].region.compareToIgnoreCase(arr[keyIndex].region);
                int cityCompare = arr[currentStudentIndex].city.compareToIgnoreCase(arr[keyIndex].city);

                if (regionCompare > 0 || (regionCompare == 0 && cityCompare > 0)) {
                    indices[j + 1] = indices[j];
                    j--;
                } else {
                    break;
                }
            }
            indices[j + 1] = keyIndex;
        }
        return indices;
    }

    public static void mergeSort(Student[] arr) {
        if (arr.length <= 1) return;
        Student[] temp = new Student[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(Student[] arr, Student[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(Student[] arr, Student[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int iLeft = left;
        int iRight = mid + 1;
        int current = left;

        while (iLeft <= mid && iRight <= right) {
            if (temp[iLeft].region.compareToIgnoreCase(temp[iRight].region) <= 0) {
                arr[current] = temp[iLeft];
                iLeft++;
            } else {
                arr[current] = temp[iRight];
                iRight++;
            }
            current++;
        }

        int remaining = mid - iLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = temp[iLeft + i];
        }
    }
}
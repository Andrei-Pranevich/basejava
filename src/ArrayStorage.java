/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int numberElem = 0; // количество элементов в массиве

    void clear() {
        for (int i = 0; i < numberElem; i++) {
            storage[i] = null;
        }
        numberElem = 0;
    }

    void save(Resume r) {
        if (r == null) {
            return;
        }

        storage[numberElem] = r;
        numberElem++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < numberElem; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < numberElem; i++) {
            if (storage[i].uuid == uuid) {
                for (int j = i; j < numberElem - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[numberElem - 1] = null;
                numberElem--;
                break;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[numberElem];
        for (int i = 0; i < numberElem; i++) {
            array[i] = storage[i];
        }
        return array;

    }

    int size() {
        return numberElem;
    }

}

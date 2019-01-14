/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int nElem = 0; // количество элементов в массиве

    void clear() {
        for (int i = 0; i < nElem; i++) {
            storage[i] = null;
        }
        nElem=0;
    }

    void save(Resume r) {
        if (r == null){
            return;
        }

        storage[nElem] = r;
        nElem++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < nElem; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < nElem; i++) {
            if (storage[i].uuid == uuid) {
                for (int j = i; j < nElem; j++) {
                    storage[j] = storage[j + 1];
                }
                nElem--;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] mas = new Resume[nElem];
        for (int i = 0; i < nElem; i++) {
            mas[i] = storage[i];
        }
        return mas;

    }

    int size() {
        return nElem;
    }

}

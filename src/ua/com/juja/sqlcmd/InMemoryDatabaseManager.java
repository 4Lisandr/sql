package ua.com.juja.sqlcmd;

import java.util.Arrays;

/**
 *
 */
public class InMemoryDatabaseManager implements DatabaseManager {

    public static final String TABLE_NAME = "user";
    private DataSet[] data = new DataSet[1000];
    private int freeIndex = 0;

    @Override
    public DataSet[] getTableData(String tableName) {
        return Arrays.copyOf(data, freeIndex);
    }

    @Override
    public String[] getTableNames() {
        return new String[]{TABLE_NAME};
    }

    @Override
    public void connect(String database, String user, String password) {

    }

    @Override
    public void clear(String tableName) {
        data = new DataSet[1000];
        freeIndex = 0;
    }

    @Override
    public void create(DataSet input) {
        data[freeIndex] = input;
        freeIndex++;
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        for (int i = 0; i < freeIndex ; i++) {
            if (data[i].get("id").equals(id)){
                data[i].update(newValue);
            }
        }
    }
}

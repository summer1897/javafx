package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName DataReader
 * @Author solstice
 * @Date 19/5/15 15:14
 * @Version 1.0.0
 * @Description
 **/
public class DataReader {

    private InputStream is;

    public DataReader(String filePath) throws IOException {
        this(new FileInputStream(filePath));
    }

    public DataReader(InputStream is) {
        this.is = is;
    }

    public List<Position> getPositions() throws Exception {
        List<Position> positions = new ArrayList<>();

//        FileInputStream fis = new FileInputStream(this.filePath);
        Scanner reader = new Scanner(this.is);
        while (reader.hasNext()) {
            String line = reader.nextLine();
            System.out.println("line" + line);
            if (null != line || "".equals(line.trim())) {
                continue;
            }
            String []columns = line.split(",");
            if (6 != columns.length) {
                continue;
            }

            try {
                String city = columns[0];
                String state = columns[1];
                double latDegree = Double.parseDouble(columns[2]);
                double latMinute = Double.parseDouble(columns[3]);
                double longDegree = Double.parseDouble(columns[4]);
                double longMinute = Double.parseDouble(columns[5]);
                Position p = new Position(city, state, latDegree, latMinute, longDegree, longMinute);
                positions.add(p);
            } catch (NumberFormatException e) {
                System.out.println("Number format error!");
                continue;
            }
        }

        this.is.close();
        reader.close();

        return positions;
    }
}

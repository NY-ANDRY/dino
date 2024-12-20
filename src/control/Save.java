package control;

import java.io.*;
import java.util.ArrayList;

public class Save {
    String path;

    public Save(String path) {
        this.path = path;
    }

    public void write(int data) {
        try {
            FileWriter fw = new FileWriter(this.path, true);
            PrintWriter writer = new PrintWriter(fw);
            writer.print(String.valueOf(data) + ";");
            writer.close();
        } catch (Exception exept) {
        }
    }

    public ArrayList<Integer> getData() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] datas = data.split(";");
                for (int i = 0; i < datas.length; i++) {
                    result.add(Integer.parseInt(datas[i]));
                }
            }

        } catch (Exception e) {
        }
        return result;
    }

    public static boolean isEmpty(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            if (br.readLine() == null) {
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            return true;
        }
    }

}
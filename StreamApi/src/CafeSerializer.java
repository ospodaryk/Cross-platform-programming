import java.io.*;

public class CafeSerializer {
    private static final String path = "/Users/oksanaspodarik/Documents/JAVA/KPP_6/res.dat";
    public static void saveObject(Cafe cafe) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cafe);
        objectOutputStream.close();
    }

    public static Cafe readObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Cafe lbr = (Cafe) objectInputStream.readObject();
        return lbr;
    }
}

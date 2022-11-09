import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestClass {

    public int byte2int(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                ((bytes[3] & 0xFF) << 0);
    }

    public byte[] toBytes(int i)
    {
        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }

    @Test
    public void testToByte(){
        int testLen = 43664;
        byte[] actualRes = toBytes(testLen);
    }

    @Test
    public void start() throws IOException {

        // Создаю сокет с ip и портом + создаю объекты для удобства отправки и получения данных
        Socket clientSocket = new Socket("10.24.10.211", 9999);
        DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());


        // Читаю файл, конвертирую и отправляю через сокет
        String data = FileUtils.readFileToString(new File("src/main/java/config_woth_nopin.cmd"), StandardCharsets.UTF_8);
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
        byte[] bytesLen = toBytes(dataBytes.length);
        dOut.write(bytesLen);
        dOut.write(dataBytes);
        byte[] bytesLenIn = new byte[4];
        dIn.read(bytesLenIn) ;
        int lenIn = byte2int(bytesLenIn);
        byte[] bytesIn = new byte[lenIn];
        dIn.read(bytesIn) ;

        clientSocket.close();
    }
}
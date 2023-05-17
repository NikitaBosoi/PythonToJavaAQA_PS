import org.apache.commons.io.FileUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    // Создаю сокет с ip и портом + создаю объекты для удобства отправки и получения данных
    Socket clientSocket;

    {
        try {
            clientSocket = new Socket("10.24.10.202", 9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Получаем поток через который пишем в сокет
    DataOutputStream dOut;

    {
        try {
            dOut = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Получаем пото через который читаем из сокета
    DataInputStream dIn;

    {
        try {
            dIn = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected String getOutput(DataInputStream dIn) throws IOException {
        byte[] bytesLenIn = new byte[4];
        dIn.read(bytesLenIn) ;
        int lenIn = byte2int(bytesLenIn);
        byte[] bytesIn = new byte[lenIn];
        dIn.read(bytesIn) ;
        return  new String(bytesIn);
    }

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

    protected String loadCommand(String path) throws IOException {
        String data = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        return data;
    }

    protected void sendCommand(String cmd, DataOutputStream dOut) throws IOException {
        byte[] dataBytes = cmd.getBytes(StandardCharsets.UTF_8);
        byte[] bytesLen = toBytes(dataBytes.length);
        dOut.write(bytesLen);
        dOut.write(dataBytes);
    }
}

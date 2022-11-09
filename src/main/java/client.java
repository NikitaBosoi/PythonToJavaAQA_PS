
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class client {
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;
    ByteArrayOutputStream dataBuffer = new ByteArrayOutputStream();


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

        public void startConnection() throws IOException {

        }

        public void sendMsg() throws IOException {

        }

        public String recvMsg() throws IOException {
            String resp = in.readLine();
            System.out.println(resp);
            return resp;

        }

        public String sendMessage(String msg) throws IOException {
            return msg ;
        }

        public void stopConnection() throws IOException {

        }
}

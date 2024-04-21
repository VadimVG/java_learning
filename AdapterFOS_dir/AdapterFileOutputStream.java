package test_classes.AdapterFOS_dir;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream=fileOutputStream;
    }

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush(); // метод flush класса AdapterFileOutputStream делегирует полномочия методу flush класса FileOutputStream
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes()); // метод writeString класса AdapterFileOutputStream делегирует полномочия методу write класса FileOutputStream
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close(); // метод close класса AdapterFileOutputStream делегирует полномочия методу close класса FileOutputStream
    }
}

package test.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        int c;
        try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/media/andy/Data/LearningNotes/HEAD_FIRST/DecoratorPattern/src/test/io/test.txt")))) {
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try(InputStream in2 = new LowerCaseInputStream(new LowerCaseInputStream(new FileInputStream("/media/andy/Data/LearningNotes/HEAD_FIRST/DecoratorPattern/src/test/io/test.txt")))){
            while ((c = in2.read()) >= 0){
                System.out.print((char) c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

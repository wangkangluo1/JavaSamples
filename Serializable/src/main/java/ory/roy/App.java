package ory.roy;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Worm w = new Worm(6 ,'a');
        System.out.println("before serializable!");
        System.out.println("w="+w);

        //序列化操作1--FileOutputStream
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("worm.out"));
        oos1.writeObject("Worm storage By FileOutputStream ");
        oos1.writeObject(w);//必须所有引用的对象都实现序列化（本例终究是Data这个类），否则抛出有java.io.NotSerializableException:这个异常
        oos1.close();

        //反序列化操作1---FileInputStream
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("worm.out"));
        String s1 = (String)ois1.readObject();
        Worm w1 = (Worm)ois1.readObject();
        ois1.close();
        System.out.println("After deserialize 1");
        System.out.println(s1);
        System.out.println("w1:"+w1);

/*
        //序列化操作2--ByteArrayOutputStream
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(byteOutStream);
        oos2.writeObject("Worm storage By ByteOutputStream ");
        oos2.writeObject(w);
        oos2.flush();

        //反序列操作2--ByteArrayInputStream
        ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
        ObjectInputStream ois2 = new ObjectInputStream(byteInStream);
        String s2 = (String)ois2.readObject();
        Worm w2 = (Worm)ois2.readObject();
        ois2.close();
        System.out.println("After deserialize 1");
        System.out.println(s2);
        System.out.println("w2:"+w2);
*/
    }
}

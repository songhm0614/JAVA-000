import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName HelloClassLoader
 * @Description 自定义类加载器，加载一个255-x的字节码文件
 * @Author frode
 * @Date 2020/10/17 上午10:56
 **/
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> clz = new HelloClassLoader().findClass("Hello");
            Method hello = clz.getDeclaredMethod("hello");
            hello.setAccessible(true);
            hello.invoke(clz.newInstance());
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> findClass(String name) {
        String filePath = "/Users/haomiaosong/code/geektime/JAVA-000/Week_01/"+name+".xlass";
        File file = new File(filePath);
        int length = (int) file.length();
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, length);
    }
}
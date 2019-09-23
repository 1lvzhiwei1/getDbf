package util;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class readDbf2 {

    private final static  String CHARSET = "GB2312";

    public static Object readDBF(String path) {
        JSONObject json = new JSONObject();
        JSONArray infojson = new JSONArray();
        //创建存储文件内容的ArrayList集合
        List<Object> list = new ArrayList<>();
        List<String> keyname = new ArrayList<>();
        InputStream fis = null;
        try {
            // 读取文件的输入流
            fis = new FileInputStream(path);
            // 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息
            DBFReader reader = new DBFReader(fis);
            // 设置读取文件的字符集规范，这一步是为了解决中文乱码问题
            reader.setCharactersetName(CHARSET);
            // 调用DBFReader对实例方法得到path文件中字段的个数
            int fieldsCount = reader.getFieldCount();
            // 取出字段信息
            for (int i = 0; i < fieldsCount; i++) {
                DBFField field = reader.getField(i);
                keyname.add(field.getName());
            }
            Object[] rowValues;
            // 一条条取出path文件中记录
            while ((rowValues = reader.nextRecord()) != null) {
                for (int i = 0; i < rowValues.length; i++) {
                    //将逐条取出的内容装进ArrayList中
                    list.add(rowValues[i]);
                    json.put(keyname.get(i),list.get(i));
                }
                infojson.put(json);
                json=new JSONObject();
                list.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return infojson;
    }
    public static void main(String[] orgs){

        System.out.print(readDbf2.readDBF("C:/Users/Lenovo/Desktop/T_TDD.dbf"));
    }

}
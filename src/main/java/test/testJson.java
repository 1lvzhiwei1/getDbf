package test;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class testJson {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add(0,"小明");
        list.add(1,"小王");
        list.add(2,"小张");
        JSONArray js = JSONArray.fromObject(list);
        System.out.println(js.toString());

    }
}

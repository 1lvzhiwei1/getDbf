package service.impl;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;
import service.InfoServcie;
import util.readDbf2;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoServcie {
   public List<JSONArray> getInfo(){
        readDbf2 readdbf = new readDbf2();
        List<JSONArray> list = (List<JSONArray>) readdbf.readDBF("C:/Users/Lenovo/Desktop/T_TDD.dbf");
        return  list;
    }
}

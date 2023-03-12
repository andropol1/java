package Java.Lesson2;

import java.util.HashMap;
import java.util.Map;

//1) Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class task2_1 {
    public static void main(String[] args) {
        HashMap<String, String> dataBase = new HashMap<>();
        dataBase.put("name","Ivanov");
        dataBase.put("country","Russia");
        dataBase.put("city","Moscow");
        dataBase.put("age","null");
        System.out.println(sqlQuery(dataBase));
    }

    public static String sqlQuery(Map<String, String> dataBase){
        StringBuilder request = new StringBuilder();
        for (Map.Entry<String,String> elements: dataBase.entrySet()) {
            if (elements.getValue() != "null"){
                request.append(elements.getKey() + " : " + elements.getValue() + ", ");
            }
        }
        return request.toString();
    }
}

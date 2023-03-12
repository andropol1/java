package Java.Lesson2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//3.** Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class task2_3 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("\\Users\\andre\\IdeaProjects\\java\\src\\Java\\Lesson2\\task3_json.txt");
        Scanner scan = new Scanner(fr);
        StringBuilder convertText = new StringBuilder();
        String jsonInfo;
        jsonInfo = scan.nextLine().replaceAll("[\\[\\]\\{\\:\\,]","");
        String[] newLine = jsonInfo.split("}");

        for (String item : newLine) {
            String[] studentInfo = item.split("\"");
                convertText.append("Студент ");
                convertText.append(studentInfo[3]).append(" ").append("получил").append(" ");
                convertText.append(studentInfo[7]).append(" ").append("по предмету").append(" ").append(studentInfo[11]);
                convertText.append("\n");
        }
        System.out.println(convertText);
        fr.close();
    }
}

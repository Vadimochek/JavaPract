package com.company;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.Files.readString;


public class file {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try (FileWriter writer = new FileWriter("C:\\Users\\vadim\\OneDrive\\Рабочий стол\\Новый текстовый документ.txt", false)) {
            String text = "HELLO, RIGHT?";
            System.out.println("Запись");
            writer.write(text);
            System.out.println("Добавление");
            writer.append("YESYES");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileReader reader = new FileReader("C:\\Users\\vadim\\OneDrive\\Рабочий стол\\Новый текстовый документ.txt")) {
            System.out.println("Чтение");
            char c;
            while (reader.read() != -1) {
                c = (char) reader.read();
                System.out.print(c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Введите строку для замены:");
        in.nextLine();
        String slovo = in.nextLine();
        try (FileWriter writer = new FileWriter("C:\\Users\\vadim\\OneDrive\\Рабочий стол\\Новый текстовый документ.txt", false)) {
            writer.write(slovo+"\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
class file2{
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\vadim\\OneDrive\\Рабочий стол\\text.txt";
        System.out.println("Поиск 10 слов...");
        Path path = Path.of(fileName);
        Charset charset = StandardCharsets.UTF_8;
        String input = readString(path, charset);
        String[] m = input.split(" ");
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < m.length; i++) {
            if (h.containsKey(m[i])) {
                h.replace(m[i], h.get(m[i]) + 1);
            } else {
                h.put(m[i], 1);
            }
        }
        String s = null;
        int p = 0;
        int i=0;
        for (String w : h.keySet()) {
            if (p < h.get(w)) {
                p = h.get(w);
                s = w;
            }
        }
        Map<String, Integer> orderedMap = h.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> b - a))
                .collect(LinkedHashMap::new,
                        (g, c) -> g.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);
        int iterator=0;
        for(String qu:orderedMap.keySet()){
            int ch=orderedMap.get(qu);
            if(i==0||i==2) {i++;continue;}
            System.out.println(qu+ " встречается "+ch+" раз");
            if(i==11) break;
            i++;
        }
        System.out.println("Замена пробелов....");
        String probel = " ";
        String resh = "#";
        Files.write(path,
                new String(Files.readAllBytes(path), charset).replace(probel, resh)
                        .getBytes(charset));
        System.out.println("Готово!");
    }

    }



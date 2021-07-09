package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	//сериализация - представление объекта и/или примитивного типа в двоичном виде
    //(для записи в файл, перидачи по сети и т.д)
    // десериализация - преобразование объекта и /или примитивного типа из двоичного вида
    // в объект и/или примитивный тип языка програмирования
        File f = new File("1.bin");
        if (!f.exists()){
            f.createNewFile();
        }

        //***сериализация
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos  = new ObjectOutputStream(fos);
        oos.writeInt(156);
        oos.writeDouble(-45.36);

        //не все объекты джава подвергаются сериализации, а только те классы которых реализуются
        // интерфейс Serializable
        User u = new User();
        u.setAge(13);
        u.name = "Vasya";

        u.job = new Job();
        u.job.name = "programer";
        u.job.salary = 1000000;
        oos.writeObject(u);

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i<20;i++){
            User user = new User();
            user.setAge(i);
            users.add(user);
        }

        oos.writeObject(users);



        oos.close();
        fos.close();
        //потоки закрывают в обратном порядке


        //***десериализация
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        //ЧТЕНИЕ ДАННЫХ ИЗ БИНАРНОГО ПОТОКА (ФАЙЛА) ДОЛЖНО ПРОИСХОДИТЬ В ТОМ ЖЕ ПОРЯДКЕ
        // ЧТО И БЫЛА ПРОИЗВЕДЕНА ЗАПИСЬ
        int x = ois.readInt();
        double d = ois.readDouble();
        User u2 = (User) ois.readObject();
        ArrayList<User> usersList = (ArrayList<User>)ois.readObject();

        System.out.println(x);
        System.out.println(d);
        System.out.println(u2.getAge());
        System.out.println(u2.name);

        usersList.stream().forEach((user) -> System.out.println(user.getAge()) );
        ois.close();
        fis.close();



    }
}

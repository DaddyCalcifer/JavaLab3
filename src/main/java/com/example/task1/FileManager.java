package com.example.task1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class FileManager {
    public static void SaveFigures(List<Shape> figures)
    {
        try(FileWriter writer = new FileWriter("save.txt",false))
        {
            for (int i =0; i < figures.size(); i++)
            {
                writer.write(figures.get(i).toSaveFormat() + "\n");
            }
            writer.flush();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static Deque ReadFigures(String path)
    {
        Deque<Shape> deque = new ArrayDeque<Shape>();
        try {
            File file = new File("save.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                deque.add(Shape.fromSaveFormat(line.trim()));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deque;
    }

}
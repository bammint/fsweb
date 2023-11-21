package a1026.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClass {
    private File file;
    private String dir;
    private String fileName;
    public FileClass() {
        file = new File("d:\\");
    }
    public FileClass(String dir, String fileName) {
        file = new File("d:\\"+dir+"\\"+fileName+".txt");
        this.dir = "d:\\"+dir;
        this.fileName = fileName+".txt";
        //d:\\Temp\abc.txt
    }
    // 파일명이 있는지 확인하기
    public boolean check(File file){
        if(file.exists()){
            return true;
        }
            return false;
    }

    // create
    public void create() throws Exception{
        boolean exists = check(file);
        if(exists){
            file.delete();
            file.createNewFile();
        }else{
            file = new File(dir);
            file.mkdir(); // 디렉토리(폴더) 만들기
            file = new File(dir+"\\"+fileName);
            file.createNewFile();
        }
    }

    // read
    public void read() throws Exception{
        boolean exist = check(file);
        if(exist){
            FileReader fr = new FileReader(file);
            BufferedReader bw = new BufferedReader(fr);
            String str;
            while((str = bw.readLine()) != null){
                System.out.println(str);
            }
            bw.close();
        }else {
            System.out.println("읽을 파일이 없습니다");
        }
    }

    // write
    public void write(String str) throws Exception{
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(str);
        fw.close();
    }
}

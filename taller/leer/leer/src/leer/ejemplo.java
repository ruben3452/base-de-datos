/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leer;
import java.io.*;
/**
 *
 * @author alucard
 */
public class ejemplo {

    
public static void main(String[] args) {
// TODO code application logic here
try {
RandomAccessFile rf =
new RandomAccessFile("rtest.dat", "rw");
for(int i = 0; i < 10; i++)
rf.writeDouble(i*1.414);
rf.close();

rf = new RandomAccessFile("rtest.dat", "rw");
rf.seek(5*8);
rf.writeDouble(47.0001);
rf.close();
rf = new RandomAccessFile("rtest.dat", "r");
 for(int i = 0; i < 10; i++)

System.out.println("Value " + i + ": " +

rf.readDouble());
 rf.close();
 } catch(FileNotFoundException e) {

System.out.println(

"File Not Found:" + args[0]);
 } catch(IOException e) {

System.out.println("I/O Exception");
 }
 }

    
}

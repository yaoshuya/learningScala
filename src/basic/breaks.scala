package basic

import scala.util.control.Breaks

object breaks extends App {
     println("hello break")
     println("hello outer")
     val numList = List(1,2,3,4,5)
     val numList2 = List(1,2,3)
     
     val loop = new Breaks;
     loop.breakable{
     for ( i <- numList)
       for(j <- numList2)
         {
           println(s"$i * $j = ${i*j}")
           if (j==2 && i==5)
             loop.break;
         }
     }
    
    var go = true;
    for(i <- numList ; if(go))
    {
      if(i==4) 
        go=false
      println(i)
    }
    
}
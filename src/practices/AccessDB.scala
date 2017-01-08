package practices
import scalikejdbc._


//a sample app for access mysql database
//get data from mysql and insert data into msql oracle like database batch
object AccessDB extends App {
  
def method1 = {
 val  connStr="jdbc:mysql://192.168.1.175:3306/monitor?user=root&password=Root_1234"
 import java.sql.{ DriverManager, ResultSet } 
    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection(connStr)
    try {
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val rs = statement.executeQuery("select * from t_user")
      val md = rs.getMetaData
      val colNames = for (i <- 1 to md.getColumnCount) yield md.getColumnName(i)
      while (rs.next) {
            println(rs.getString(2))
       }
    }
    catch
       {
           case e:Exception=> 
             e.printStackTrace()
       }
    finally {
      conn.close
    }
  }

   //Loading JDBC Drivers
    Class.forName("com.mysql.jdbc.Driver")
    //Connection Pool Settings
    import scalikejdbc._
    ConnectionPool.singleton("jdbc:mysql://192.168.1.175:3306/monitor", "root", "Root_1234")
     // do something
    using(DB(ConnectionPool.borrow())) { db =>
      db.localTx { implicit session =>
//      sql"""
//            create table members (
//              id serial not null primary key,
//              name varchar(64),
//              created_at timestamp not null
//            )
//            """.execute.apply()
//            
//                  // insert initial data
//                  Seq("Alice", "Bob", "Chris") foreach { name =>
//                    sql"insert into members (name, created_at) values (${name}, current_timestamp)".update.apply()
//                  }
      
      val entities: List[Map[String, Any]] = sql"select * from members".map(_.toMap).list.apply()
      entities.foreach(println)
      
      
      }  


    }

 

}
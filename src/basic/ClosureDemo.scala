package basic

object ClosureDemo extends App{
  
  var jdbcurl = ""
  
  jdbcurl = "jdbc:mysql:localhost:3306/monigtor"
  readJdbc 
  jdbcurl = "jdbc2:mysql:localhost:3306/test"
  readJdbc
  
  updateJdbc
  readJdbc
  
  def readJdbc = 
  {
      println(s"Now the value of jdbcurl is $jdbcurl")
  }
  
  def updateJdbc =
  {
    jdbcurl = "jdbc3:mysql:localhost:3306/new"
  }
  
  
}
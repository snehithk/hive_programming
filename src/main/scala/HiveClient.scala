import java.sql.{Connection, DriverManager, ResultSet}


object HiveClient extends App {
  val driverName: String = "org.apache.hive.jdbc.HiveDriver"
  Class.forName(driverName)

  val connection: Connection = DriverManager
    .getConnection("jdbc:hive2://172.16.129.58:10000/snehith;user=snehith;password=snehith")
  val stmt = connection.createStatement()

  val res: ResultSet = stmt.executeQuery("SELECT * FROM fall2019_snehith.logs_internal")
  while (res.next()) {
    println("" +
      "userid: " + res.getString(3))
  }
  stmt.close()
  connection.close()

}

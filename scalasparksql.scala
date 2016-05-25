import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.hive.HiveContext;

object ScalaSparkSQL {

        def main(args: Array[String]): Unit = {
                val conf = new SparkConf().setAppName("scalaspark").setMaster("local").set("spark.driver.allowMultipleContexts","false");
                val sc = new SparkContext(conf);

                import sqlContext.implicits._;

                val sqlContext = new HiveContext(sc);
                val df = sqlContext.sql("select * from test_join_id");
                df.registerTempTable("test_tmp");
                val res = sqlContext.sql("select count(*) from test_tmp").collect();
                res.map(t => t(0)).foreach(println);
        }

}
